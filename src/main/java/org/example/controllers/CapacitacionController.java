package org.example.controllers;

import org.example.models.Capacitacion;
import org.example.models.services.CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ModelAndView mostrarCapacitaciones(){
        ModelAndView model = new ModelAndView();
        List<Capacitacion> capacitaciones = capacitacionService.readAll();
        model.addObject("capacitaciones", capacitaciones);
        model.setViewName("capacitaciones");
        return model;
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)//para el boton que muestra el formulario para crear
    public ModelAndView agregarCapacitacion(){
        ModelAndView model = new ModelAndView();
        Capacitacion capacitacion = new Capacitacion();
        model.addObject("capacitacionForm", capacitacion);
        model.setViewName("crearCapacitacion");
        return model;
    }

    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
    public ModelAndView actualizarCapacitacion(@PathVariable Long id) {
        ModelAndView model = new ModelAndView();
        Capacitacion capacitacion = capacitacionService.readOne(id);
        model.addObject("capacitacionForm", capacitacion);
        model.setViewName("crearCapacitacion");
        return model;
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ModelAndView guardarOEditarCapacitacion(@ModelAttribute("capacitacionForm") Capacitacion capacitacion){
        if (capacitacion.getIdCapacitacion() != null) {
            capacitacionService.update(capacitacion);
        } else {
            capacitacionService.create(capacitacion);
        }
        return new ModelAndView("redirect:/capacitacion/lista");
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public ModelAndView eliminarCapacitacion(@PathVariable("id") Long id) {
        capacitacionService.delete(id);
        return new ModelAndView("redirect:/capacitacion/lista");
    }


}
