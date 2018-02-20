package com.denisgl.web.controller;

import com.denisgl.web.model.CheckerSide;
import com.denisgl.web.model.Move;
import com.denisgl.web.model.Rules;
import com.denisgl.web.model.WhichColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class DescController {

    @Autowired
    WhichColor whichColor;

    @Autowired
    Rules rules;

    @RequestMapping("/")
    public String getDesc(){
        return "board";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public boolean move(@RequestBody Move move,HttpSession session){
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
}
