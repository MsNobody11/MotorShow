package com.client;


import com.Salon.SostavCompl;

import com.service.SostavComplService;
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
public class SostavComplController {
    private SostavComplService sostavComplService;

    @Autowired
    @Qualifier(value = "sostavcomplService")
    public void setSostavComplService(SostavComplService ps) {
        this.sostavComplService = ps;
    }

    @RequestMapping(value = {"/sostavcompl"}, method = RequestMethod.GET)
    public String listSostavCompl(Model model) {
        model.addAttribute("sostavcompl", new SostavCompl());
        model.addAttribute("listSostavCompl", this.sostavComplService.listSostavCompl());
        return "/sostavcompl";
    }

    @RequestMapping(value = "/add_sostav", method = RequestMethod.POST)
    public String addSostavCompl(@ModelAttribute("sostavcompl") SostavCompl s) {

        SostavCompl cl = this.sostavComplService.getId(s.getKodElement());

        if (cl == null)
        {
            this.sostavComplService.addSostavCompl(s);
        }

        else {
            cl.setKodElement(s.getKodElement());
            cl.setName(s.getName());

            this.sostavComplService.updateSostavCompl(cl);
        }
        return "redirect:/sostavcompl";
    }

    @RequestMapping(value = "/delete_sostav/{kodElement}", method = RequestMethod.GET)
    public String deleteSostavCompl(@PathVariable("kodElement") Integer kodElement) {
        this.sostavComplService.deleteSostavCompl(kodElement);
        return "redirect:/sostavcompl";
    }

    @RequestMapping(value = "/edit_sostav/{kodElement}", method = RequestMethod.GET)
    public String editSostavCompl(@PathVariable("kodElement") Integer kodElement, Model model) {

        model.addAttribute("sostavcompl", this.sostavComplService.getId(kodElement));
        model.addAttribute("listSostavCompl", this.sostavComplService.listSostavCompl());

        return "/sostavcompl";
    }
}
