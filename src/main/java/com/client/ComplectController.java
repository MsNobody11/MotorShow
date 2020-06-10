package com.client;

import com.Salon.Complect;


import com.service.ComplectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller
public class ComplectController {
    private ComplectService complectService;

    @Autowired
    @Qualifier(value = "complectService")
    public void setComplectService(ComplectService ps) {
        this.complectService = ps;
    }

    @RequestMapping(value = {"/complect"}, method = RequestMethod.GET)
    public String listComplect(Model model) {
        model.addAttribute("complect", new Complect());
        model.addAttribute("listComplect", this.complectService.listComplect());
        return "/complect";
    }

    @RequestMapping(value = "/add_compl", method = RequestMethod.POST)
    public String addComplect(@ModelAttribute("complect") Complect s) {
        Complect cl = this.complectService.getId(s.getKodCompl());
        if (cl == null) {
            this.complectService.addComplect(s);
        }
        else {
            cl.setKodCompl(s.getKodCompl());
            cl.setName(s.getName());
            cl.setSostav(s.getSostav());
            this.complectService.updateComplect(cl);
        }
        return "redirect:/complect";
    }

    @RequestMapping(value = "/delete_compl/{kodCompl}", method = RequestMethod.GET)
    public String deleteComplect(@PathVariable("kodCompl") Integer kodCompl) {
        this.complectService.deleteComplect(kodCompl);
        return "redirect:/complect";
    }

    @RequestMapping(value = "/edit_compl/{kodCompl}", method = RequestMethod.GET)
    public String editComplect(@PathVariable("kodCompl") Integer kodCompl, Model model) {
        model.addAttribute("kodCompl", this.complectService.getId(kodCompl));
        model.addAttribute("listComplect", this.complectService.listComplect());
        model.addAttribute("complect", this.complectService.getId(kodCompl));
        return "/complect";
    }
}
