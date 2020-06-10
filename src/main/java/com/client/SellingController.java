package com.client;

import com.Salon.Selling;
import com.service.SellingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller
public class SellingController {
    private SellingService sellingService;
    Logger logger = LoggerFactory.getLogger(Selling.class);
    @Autowired
    @Qualifier(value = "sellingService")
    public void setSellingService(SellingService ps) {
        this.sellingService = ps;
    }

    @RequestMapping(value = {"/selling"}, method = RequestMethod.GET)
    public String listSelling(Model model) {
        model.addAttribute("selling", new Selling());
        model.addAttribute("listSelling", this.sellingService.listSelling());
        return "/selling";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addSelling(@ModelAttribute("selling")  Selling s)
    {
        Selling cl = this.sellingService.getIdCl(s.getId());

        if (cl == null) {
            this.sellingService.addSelling(s);
            System.out.println("Function ADD!!!");
        }
        else {
            cl.setId(s.getId());
            cl.setPasport(s.getPasport());
            cl.setFIO(s.getFIO());
            cl.setDateOfBirth(s.getDateOfBirth());
            cl.setAddress(s.getAddress());
            cl.setTelef(s.getTelef());
            this.sellingService.updateSelling(cl);
            System.out.println("Function EDIT!!!");
        }
        return "redirect:/selling";
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSelling(@PathVariable("id") Integer id) {
        this.sellingService.deleteSelling(id);
        return "redirect:/selling";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editSelling(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("selling", this.sellingService.getIdCl(id));
        model.addAttribute("listSelling", this.sellingService.listSelling());
        return "/selling";
    }
}
