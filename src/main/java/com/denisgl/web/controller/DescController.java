package com.denisgl.web.controller;

import com.denisgl.web.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Controller
public class DescController {

    final static Logger logger = Logger.getLogger(DescController.class);

    @Autowired
    private List<String> messages;

    @Autowired
    private WhichColor whichColor;

    @Autowired
    private Rules rules;

    @Autowired
    private GameBoard gameBoard;

    private boolean updateBoard;

    private boolean updateChat;

    @ModelAttribute("updateBoard")
    public boolean isUpdateBoard(){
        return updateBoard;
    }

    @ModelAttribute("updateChat")
    public boolean isUpdateChat(){
        return updateChat;
    }

    @RequestMapping("/")
    public String getDesc(Model model, HttpServletRequest request,Principal principal){
        if(request.getSession().getAttribute("side") == null) {
            if (principal.getName().equals("nikita")) {
                CheckerSide nikitaSide = whichColor.getNikitaSide();
                request.getSession().setAttribute("side", nikitaSide);
            }
            if (principal.getName().equals("denis")) {
                CheckerSide denisSide = whichColor.getDenisSide();
                request.getSession().setAttribute("side", denisSide);
            }
        }
        request.setAttribute("board",gameBoard);
        model.addAttribute("list",messages);
        updateBoard = false;
        updateChat = false;
        return "board";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public boolean move(@RequestBody Move move,HttpSession session,Model model){
        model.addAttribute("list",messages);
        if(rules.isValidMove(move, (CheckerSide) session.getAttribute("side"))){
            updateBoard = true;
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/updateboard",method = RequestMethod.POST)
    @ResponseBody
    public boolean getUpdateBoard(){
        return updateBoard;
    }


    @RequestMapping("/newgame")
    public String createNewGame(HttpSession session, Principal principal) throws BrokenBarrierException, InterruptedException {
        whichColor.setDenisAndNikitaSideToNull();
        whichColor.declareSidesIfTheyAreNull();
        return "redirect:/";
    }

    @RequestMapping(value = "message",method = RequestMethod.POST)
    @ResponseBody
    public boolean addMessage(@RequestBody String message){
        logger.debug(">>>>> was post " + message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            final JsonNode jsonNode = mapper.readTree(message).get("message");
            updateChat = true;
            return messages.add(jsonNode.asText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/resetMessages")
    public String resetList(){
        messages.clear();
        return "redirect:/";
    }
}
