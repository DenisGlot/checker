package com.denisgl.web.controller;

import com.denisgl.web.model.CheckerSide;
import com.denisgl.web.model.Move;
import com.denisgl.web.model.Rules;
import com.denisgl.web.model.WhichColor;
import com.denisgl.web.repository.InitSessionFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class DescController {

    final static Logger logger = Logger.getLogger(DescController.class);

   @Autowired
   List<String> messages;

    @Autowired
    WhichColor whichColor;

    @Autowired
    Rules rules;

    @RequestMapping("/")
    public String getDesc(Model model){
        model.addAttribute("list",messages);
        return "board";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public boolean move(@RequestBody Move move,HttpSession session,Model model){
        model.addAttribute("list",messages);
        return rules.isValidMove(move, (CheckerSide) session.getAttribute("side"));
    }



    @RequestMapping("/newgame")
    public String createNewGame(HttpSession session, Principal principal){
        whichColor.setDenisAndNikitaSideToNull();
        whichColor.declareSidesIfTheyAreNull();
        if(principal.getName().equals("nikita")){
            CheckerSide nikitaSide = whichColor.getNikitaSide();
            session.setAttribute("side",nikitaSide);
        }
        if(principal.getName().equals("denis")){
            CheckerSide denisSide = whichColor.getDenisSide();
            session.setAttribute("side",denisSide);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "message",method = RequestMethod.POST)
    @ResponseBody
    public boolean addMessage(@RequestBody String message){
        logger.debug(">>>>> was post " + message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            final JsonNode jsonNode = mapper.readTree(message).get("message");
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
