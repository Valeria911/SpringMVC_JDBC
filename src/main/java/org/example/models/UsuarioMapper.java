package org.example.models;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {

    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Usuario(resultSet.getLong("id_usuario"),
                resultSet.getString("nombre_completo"),
                resultSet.getString("fecha_nacimiento"),
                resultSet.getInt("run"),
                resultSet.getString("tipo"));
    }

}
