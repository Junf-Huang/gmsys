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

        registry.addViewController("/categoryAdd").setViewName("basicDataAdmin/categoryAdd");
        registry.addViewController("/departmentAdd").setViewName("basicDataAdmin/departmentAdd");
        registry.addViewController("/assetAdd").setViewName("basicDataAdmin/assetAdd");
        registry.addViewController("/providerAdd").setViewName("providerAdmin/providerAdd");
        //registry.addViewController("/purchaseAdd").setViewName("assetAdmin/purchaseAdd");
    }
}