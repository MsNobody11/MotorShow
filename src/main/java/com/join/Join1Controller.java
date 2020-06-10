package com.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller
public class Join1Controller {
    private Join1Service join1Service;

    @Autowired(required = true)
    @Qualifier(value = "join1Service")
    public void setJoin1Service(Join1Service ps){this.join1Service = ps; }

    @RequestMapping(value = {"/join1"}, method = RequestMethod.GET)
    public String listAuto(Model model) {
        model.addAttribute("zapros1", this.join1Service.zapros1());
        return "/join1";
    }
}
