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
public class Join2Contriller
{
    private Join2Service join2Service;

    @Autowired(required = true)
    @Qualifier(value = "join2Service")
    public void setJoin2Service(Join2Service ps){this.join2Service = ps; }

    @RequestMapping(value = {"/join2"}, method = RequestMethod.GET)
    public String listAuto(Model model) {
        model.addAttribute("zapros2", this.join2Service.zapros2());
        return "/join2";
    }
}
