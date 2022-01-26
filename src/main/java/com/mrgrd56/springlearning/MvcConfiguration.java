package com.mrgrd56.springlearning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
//    public TemplateEngine templateEngine() {
//
//    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//        var resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine();
//    }
}
