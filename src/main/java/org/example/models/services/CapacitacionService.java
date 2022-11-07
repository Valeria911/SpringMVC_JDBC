package org.example.models.services;

import org.example.models.Capacitacion;
import org.example.models.DAO.CapacitacionDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapacitacionService {

    @Autowired
    CapacitacionDAOImpl capacitacionDAO;

    public void create(Capacitacion capacitacion){
        capacitacionDAO.create(capacitacion);
    }

    public List<Capacitacion> readAll(){
        return capacitacionDAO.readAll();
    }

    public Capacitacion readOne(Long idCapacitacion){
        return capacitacionDAO.readOne(idCapacitacion);
    }

    public void update(Capacitacion capacitacion){
        capacitacionDAO.update(capacitacion);
    }

    public void delete(Long idCapacitacion){
        capacitacionDAO.delete(idCapacitacion);
    }
}
