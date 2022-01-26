package com.mrgrd56.springlearning.mvc.controllers;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Log
@Controller
public class HomeController {
    @GetMapping("/")
    public String index(@CookieValue(name = "user_name", required = false) String userName,
                        Model model) {
        log.info("user_name, " + userName);
        model.addAttribute("name", userName);
        return "index";
    }
}
