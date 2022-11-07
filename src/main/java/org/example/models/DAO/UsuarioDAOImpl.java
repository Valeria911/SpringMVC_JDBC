package org.example.models.DAO;

import org.example.models.Usuario;
import org.example.models.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {
    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public void create(Usuario usuario) {
        String sql = "insert into usuario (nombre_completo, fecha_nacimiento, run, tipo) values (?, ?, ?, ?)";
        template.update(sql, new Object[] {usuario.getNombreCompleto(), usuario.getFechaNacimiento(),
        usuario.getRun(), usuario.getTipo()});

    }

    @Override
    public List<Usuario> readAllUsers() {
        String sql = "select id_usuario, nombre_completo, fecha_nacimiento, run, tipo from usuario";
        return template.query(sql, new UsuarioMapper());
    }

    @Override
    public Usuario readOne(Long idUsuario) {
        String sql = "select id_usuario, nombre_completo, fecha_nacimiento, run, tipo from usuario where id_usuario = ?";
        RowMapper<Usuario> rowMapper = new UsuarioMapper();
        Usuario usuario = template.queryForObject(sql, rowMapper, idUsuario);

        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "update usuario set nombre_completo =?, fecha_nacimiento =?, run =?, tipo =? where id_usuario =?";
        template.update(sql, usuario.getNombreCompleto(),
        usuario.getFechaNacimiento(), usuario.getRun(), usuario.getTipo(), usuario.getIdUsuario());
    }

    @Override
    public void delete(Long idUsuario) {
        String sql = "delete from usuario where id_usuario =?";
        template.update(sql,idUsuario);

    }



   /* @Override
    public void create(Usuario usuario) {
        String sql = "insert into usuario (nombre_completo, fecha_nacimiento, run, tipo) values ('" + usuario.getNombreCompleto() + "', '"
                + usuario.getFechaNacimiento() + "', '"
                + usuario.getRun() + "', '"
                + usuario.getTipo() + "')";
        try {
            connection = Conexion.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> readAllUsers() {
        String sql = "select id_usuario, nombre_completo, fecha_nacimiento, run, tipo from usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            connection = Conexion.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                usuarios.add(new Usuario(resultSet.getLong("id_usuario"), resultSet.getString("nombre_completo"),
                        resultSet.getString("fecha_nacimiento"),
                        resultSet.getInt("run"), resultSet.getString("tipo")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario readOne(Long idUsuario) {
        String sql = "select id_usuario, nombre_completo, fecha_nacimiento, run, tipo from usuario where id_usuario = '" + idUsuario + "'";
        Usuario usuario = null;
        try {
            connection = Conexion.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                usuario = new Usuario(resultSet.getLong("id_usuario"),
                        resultSet.getString("nombre_completo"), resultSet.getString("fecha_nacimiento"),
                        resultSet.getInt("run"), resultSet.getString("tipo"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "update usuario set "
                + "nombre_completo = '" + usuario.getNombreCompleto() + "', "
                + "fecha_nacimiento = '" + usuario.getFechaNacimiento() + "', "
                + "run = '" + usuario.getRun() + "', "
                + "tipo = '" + usuario.getTipo() +
                "' where id_usuario ='" + usuario.getIdUsuario() + "'";

        try{
            connection = Conexion.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long idUsuario) {
        String sql = "delete from usuario where id_usuario = '" + idUsuario + "'";

        try{
            connection = Conexion.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }*/
}
