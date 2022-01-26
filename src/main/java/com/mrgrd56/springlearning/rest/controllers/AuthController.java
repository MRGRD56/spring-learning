package com.mrgrd56.springlearning.rest.controllers;

import com.mrgrd56.springlearning.rest.dto.LoginDto;
import com.mrgrd56.springlearning.rest.services.AuthService;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Log
@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/api/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object logIn(LoginDto loginDto, HttpServletResponse response, RedirectAttributes redirect) {
        if (!authService.validateCredentials(loginDto)) {
            redirect.addFlashAttribute("error", "Invalid login or password");
            return new RedirectView("/login", true);
        }

        var userNameCookie = new Cookie("user_name", loginDto.getLogin());
        userNameCookie.setMaxAge(Integer.MAX_VALUE);
        userNameCookie.setPath("/");
        response.addCookie(userNameCookie);
        return new RedirectView("/", true);
    }

    @GetMapping("/logout")
    public RedirectView logOut(HttpServletResponse response) {
        var userNameCookie = new Cookie("user_name", null);
        userNameCookie.setMaxAge(0);
        response.addCookie(userNameCookie);
        return new RedirectView("/", true);
    }
}
