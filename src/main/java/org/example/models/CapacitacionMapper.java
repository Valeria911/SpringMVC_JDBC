package org.example.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CapacitacionMapper implements RowMapper<Capacitacion> {


    @Override
    public Capacitacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Capacitacion(resultSet.getInt("rut_cliente"),
                resultSet.getString("dia"),
                resultSet.getString("hora"),
                resultSet.getString("lugar"),
                resultSet.getLong("id_capacitacion"),
                resultSet.getString("duracion"),
                resultSet.getInt("cantidad_asistentes"));
    }
}
