package com.client;

import com.Salon.Selling_auto;
import com.service.Selling_autoService;
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
public class Selling_autoController {
    private Selling_autoService selling_autoService;

    @Autowired
    @Qualifier(value = "selling_autoService")
    public void setSelling_autoService(Selling_autoService ps) {
        this.selling_autoService = ps;
    }

    @RequestMapping(value = {"/selling_auto"}, method = RequestMethod.GET)
    public String listSelling_auto(Model model) {
        model.addAttribute("selling_auto", new Selling_auto());
        model.addAttribute("listSelling_auto", this.selling_autoService.listSelling_auto());
        return "/selling_auto";
    }

    @RequestMapping(value = "/add_sel_auto", method = RequestMethod.POST)
    public String addSelling_auto(@ModelAttribute("selling_auto") Selling_auto s) {
        Selling_auto cl = this.selling_autoService.getId(s.getId());
        if (cl == null) {
            this.selling_autoService.addSelling_auto(s);
        }
        else {
            cl.setClient(s.getClient());
            cl.setCar(s.getCar());
            cl.setDateOfSale(s.getDateOfSale());
            this.selling_autoService.updateSelling_auto(cl);
        }
        return "redirect:/selling_auto";
    }

    @RequestMapping(value = "/delete_sel_auto/{id}", method = RequestMethod.GET)
    public String deleteSelling_auto(@PathVariable("id") Integer id) {
        this.selling_autoService.deleteSelling_auto(id);
        return "redirect:/selling_auto";
    }

    @RequestMapping(value = "edit_sel_auto/{id}", method = RequestMethod.GET)
    public String editSellingAuto(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("selling_auto", this.selling_autoService.getId(id));
        model.addAttribute("listSelling_auto", this.selling_autoService.listSelling_auto());

        return "/selling_auto";
    }
}
