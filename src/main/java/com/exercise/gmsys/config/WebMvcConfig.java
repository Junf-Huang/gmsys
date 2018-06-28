package com.exercise.gmsys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/sign-up").setViewName("sign-up");
        registry.addViewController("/404").setViewName("404");

        registry.addViewController("/addCategory").setViewName("category/addCategory");
    }
}