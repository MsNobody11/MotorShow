package com.client;


import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller
public class WelcomeController
{
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String Welcome() {
        return "/welcome";
    }
}
