package com.example.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.example")
public class SpringConfig {

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver(){
        UrlBasedViewResolver r = new UrlBasedViewResolver();
        r.setViewClass(JstlView.class);
        r.setPrefix("/jsp/");
        r.setSuffix(".jsp");
        return r;
    }
}
