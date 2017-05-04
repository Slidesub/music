package org.unicome.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@RestController
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableWebSocket
@SpringBootApplication
public class Application {
	/*
    @RequestMapping("/")
    @ResponseBody
    ModelAndView home(ModelAndView model) {
        //model.setViewName("music/register");
        model.setViewName("demo/demo");
        return model;
    }
	*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
