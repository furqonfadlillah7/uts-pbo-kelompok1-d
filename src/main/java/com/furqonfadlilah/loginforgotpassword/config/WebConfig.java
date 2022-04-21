package com.furqonfadlilah.loginforgotpassword.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.xml.validation.Validator;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    private final MessageSource messageSource;
    private final String[] RESOURCE_HANDLER = {
            "/webjars/**", "/css/**", "/js/**", "/img/**", "/assets/**", "/static/**", "/blog.css/**",
    };
    private final String[] RESOURCE_LOCATION = {
            "classpath:/META-INF/resources/webjars/",
            "classpath:/static/css/",
            "classpath:/static/js/",
            "classpath:/static/img/",
            "classpath:/assets/"
    };

    public WebConfig(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler(RESOURCE_HANDLER)
                .addResourceLocations(RESOURCE_LOCATION);
    }

    @Bean
    @Override
    public Validator getValidator(){
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
    }
}
