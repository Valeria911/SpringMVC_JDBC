package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @RequestMapping(value = ("/form"), method = RequestMethod.GET)
    public ModelAndView mostrarFormContacto(){
        return new ModelAndView("contacto");
    }
}
