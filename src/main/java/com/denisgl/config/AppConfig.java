package com.denisgl.config;

import com.denisgl.web.model.GameBoard;
import com.denisgl.web.model.Rules;
import com.denisgl.web.model.User;
import com.denisgl.web.model.WhichColor;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.denisgl.web" })
@Import({ SecurityConfig.class })
public class AppConfig /*Supports <mvc:resources mapping="/resources/**" location="/resources/" />*/extends WebMvcConfigurationSupport {

    /**
     * Supports <mvc:resources mapping="/resources/**" location="/resources/" />
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    /**
     * Supports <mvc:resources mapping="/resources/**" location="/resources/" />
     */
    @Override
    @Bean
    public HandlerMapping resourceHandlerMapping() {
        AbstractHandlerMapping handlerMapping = (AbstractHandlerMapping) super.resourceHandlerMapping();
        handlerMapping.setOrder(-1);
        return handlerMapping;
    }


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    @Scope("singleton")
    public User user(){
        return new User();
    }

    @Bean
    public WhichColor whichColor(){
        return WhichColor.getInstance();
    }

    @Bean
    @Scope("singleton")
    public GameBoard gameBoard(){
        return new GameBoard();
    }

    @Bean
    @Scope("singleton")
    public Rules rules(){
        return new Rules();
    }



}