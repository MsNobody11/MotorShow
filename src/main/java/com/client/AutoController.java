package com.client;

import com.Salon.Auto;
import com.service.AutoService;
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
public class AutoController {
    private AutoService autoService;

    @Autowired
    @Qualifier(value = "autoService") //аннотация позволяющая явно задать имя нужного бина
    public void setAutoService(AutoService s) {
        this.autoService = s;
    }

    //RequestMapping - Аннотация используется для сопоставления веб-запросов с методами Spring Controller//
    @RequestMapping(value = {"/auto"}, method = RequestMethod.GET)
    public String listAuto(Model model) {
        model.addAttribute("auto", new Auto());
        model.addAttribute("listAuto", this.autoService.listAuto());
        return "/auto";
    }

    //Аннотация, которая связывает параметр метода или возвращаемое значение метода с именованным атрибутом модели,
    // доступным для веб-представления. Поддерживается для классов контроллеров с @RequestMapping методами.
    //GET - запрашиваем данныеи из указанного ресурса
    //POST - отправка данных для обработки в указанный ресурс
    @RequestMapping(value = "/add_auto", method = RequestMethod.POST)
    public String addAuto(@ModelAttribute("auto") Auto s) {

        Auto cl = this.autoService.getIdC(s.getId_auto());

        if (cl == null) {
            this.autoService.addAuto(s);
            System.out.println("Function ADD!!!");
        }
        else {
            cl.setId_auto(s.getId_auto());
            cl.setManufacturer(s.getManufacturer());
            cl.setMarka(s.getMarka());
            cl.setModel(s.getModel());
            cl.setTypeBody(s.getTypeBody());
            cl.setTypeDvigatel(s.getTypeDvigatel());
            cl.setRaspDvig(s.getRaspDvig());
            cl.setObDvig(s.getObDvig());
            cl.setTypeBox(s.getTypeBox());
            cl.setTypePrivod(s.getTypePrivod());
            cl.setCompl(s.getCompl());
            cl.setPrice(s.getPrice());
            this.autoService.updateAuto(cl);
            System.out.println("Function EDIT!!!");
        }
        return "redirect:/auto";
    }

    //указывает  на то, что данный параметр получается из адресной строки.
    @RequestMapping(value = "/delete_auto/{id_auto}", method = RequestMethod.GET)
    public String deleteAuto(@PathVariable("id_auto") Integer id_auto) {
        this.autoService.deleteAuto(id_auto);
        return "redirect:/auto";
    }

    //redirect - используется в сучае сохранения информации в БД
    //заставляет браузер дать другой URL отличный от оригинального
    @RequestMapping(value = "/edit_auto/{id_auto}", method = RequestMethod.GET)
    public String editAuto(@PathVariable("id_auto") Integer id_auto, Model model)
    {
        model.addAttribute("auto", this.autoService.getIdC(id_auto));
        model.addAttribute("listAuto", this.autoService.listAuto());
        return "/auto";
    }
}
