package com.ton.springclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ton-SSD on 7/10/2017.
 */
@Controller
@EnableAutoConfiguration
@SpringBootApplication //add as project has restcontroller and repository classes
public class HomeController {

    //@ResponseBody : no need if return html page
    @RequestMapping("/")
    public String getHello(){
        //return a name(only name) of a template (.html file)
        return "index";
    }

    @RequestMapping("/about")
    @ResponseBody
    public String getAbout(){return "Hello about";}

    public static void main(String[] args){
        SpringApplication.run(HomeController.class,args);
    }
}
