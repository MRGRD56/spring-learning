package com.mrgrd56.springlearning.mvc.controllers;

import lombok.extern.java.Log;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Log
@Controller
public class LoginController {
    @GetMapping("/login")
    public Object index(@ModelAttribute("error") @Nullable String error) {
        var modelAndView = new ModelAndView("login");
        log.info(String.format("Error: %s", error));
        modelAndView.addObject("error", error);
        return modelAndView;
    }
}
