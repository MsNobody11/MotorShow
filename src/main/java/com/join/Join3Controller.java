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
public class Join3Controller
{
    private Join3Service join3Service;

    @Autowired(required = true)
    @Qualifier(value = "join3Service")
    public void setJoin3Service(Join3Service ps){this.join3Service = ps; }

    @RequestMapping(value = {"/join3"}, method = RequestMethod.GET)
    public String listAuto(Model model) {
        model.addAttribute("zapros3", this.join3Service.zapros3());
        return "/join3";
    }
}
