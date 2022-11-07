package org.example.models.DAO;

import org.example.models.Capacitacion;

import java.util.List;

public interface ICapacitacionDAO {
    public void create(Capacitacion capacitacion);
    public List<Capacitacion> readAll();
    public Capacitacion readOne(Long idCapacitacion);
    public void update(Capacitacion capacitacion);
    public void delete(Long idCapacitacion);
}
