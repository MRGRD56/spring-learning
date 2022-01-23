package com.mrgrd56.springlearning.rest.controllers;

import com.mrgrd56.springlearning.rest.services.LogoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/logo")
public class LogoController {
    private final LogoService logoService;

    public LogoController(LogoService logoService) {
        this.logoService = logoService;
    }

    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public CompletableFuture<byte[]> getLogo(HttpServletResponse response) {
        response.addHeader("X-Made-By", "MRGRD56");
        return logoService.getLogo();
    }
}
