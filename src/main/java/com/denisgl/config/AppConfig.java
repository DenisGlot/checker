package com.denisgl.config;

import com.denisgl.web.model.GameBoard;
import com.denisgl.web.model.Rules;
import com.denisgl.web.model.User;
import com.denisgl.web.model.WhichColor;
import com.denisgl.web.repository.InitSessionFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

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

    @Bean
    @Scope("singleton")
    public SessionFactory sessionFactory(){
        return InitSessionFactory.getSessionFactory();
    }

    @Bean
    @Scope("singleton")
    public List<String> messages(){
        List<String> messages = new ArrayList<String>();
        messages.add("<div class=\"left-chat\">\n" +
                "                        <img src=\"/resources/images/man01.png\">\n" +
                "                        <p>Write something\n" +
                "                        </p>\n" +
                "                    </div>");
        return messages;
    }

}