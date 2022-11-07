package org.example.models.DAO;

import org.example.models.Capacitacion;
import org.example.models.CapacitacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CapacitacionDAOImpl implements ICapacitacionDAO{

    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public void create(Capacitacion capacitacion) {
        String sql = "insert into capacitacion (duracion, cantidad_asistentes, rut_cliente, dia, hora, lugar) values (?, ?, ?, ?, ?, ?)";
        template.update(sql, new Object[] {capacitacion.getDuracion(),
        capacitacion.getCantidadAsistentes(),
        capacitacion.getRutCliente(),
        capacitacion.getDia(),
        capacitacion.getHora(),
        capacitacion.getLugar()});
    }

    @Override
    public List<Capacitacion> readAll() {
        String sql = "select id_capacitacion, duracion, cantidad_asistentes, rut_cliente, dia, hora, lugar from capacitacion";
        return template.query(sql, new CapacitacionMapper());
    }

    @Override
    public Capacitacion readOne(Long idCapacitacion) {
        String sql = "select id_capacitacion, duracion, cantidad_asistentes, rut_cliente, dia, hora, lugar from capacitacion where id_capacitacion = ?";
        RowMapper<Capacitacion> rowMapper = new CapacitacionMapper();
        Capacitacion capacitacion = template.queryForObject(sql, rowMapper, idCapacitacion);
        return capacitacion;
    }

    @Override
    public void update(Capacitacion capacitacion) {
        String sql = "update capacitacion set duracion =?, cantidad_asistentes =?, rut_cliente =?, dia =?, hora =?, lugar =? where id_capacitacion =?";
        template.update(sql, capacitacion.getDuracion(),
                capacitacion.getCantidadAsistentes(),
                capacitacion.getRutCliente(),
                capacitacion.getDia(),
                capacitacion.getHora(),
                capacitacion.getLugar(),
                capacitacion.getIdCapacitacion());
    }

    @Override
    public void delete(Long idCapacitacion) {
        String sql = "delete from capacitacion where id_capacitacion = ?";
        template.update(sql, idCapacitacion);
    }



   /* private Connection connection = null;

    @Override
    public void create(Capacitacion capacitacion) {
        String sql = "insert into capacitacion (rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes) values ('" +
                capacitacion.getRutCliente() + "', '"
                + capacitacion.getDia() + "', '" +
                capacitacion.getHora() + "', '" + capacitacion.getLugar() +
                "', '" + capacitacion.getDuracion() + "', '" +
                capacitacion.getCantidadAsistentes() + "')";
        try {
            connection = Conexion.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Capacitacion> readAll() {
       String sql = "select * from capacitacion";
       List<Capacitacion> capacitaciones = new ArrayList<>();
       try{
           connection = Conexion.getConnection();
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);

           while(resultSet.next()){
               capacitaciones.add(new Capacitacion(resultSet.getInt("rut_cliente"), resultSet.getString("dia"),
                       resultSet.getString("hora"), resultSet.getString("lugar"), resultSet.getLong("id_capacitacion"),
                       resultSet.getString("duracion"), resultSet.getInt("cantidad_asistentes")));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return capacitaciones;
    }

    @Override
    public Capacitacion readOne(Long idCapacitacion) {
        String sql = "select rut_cliente, dia, hora, lugar, id_capacitacion, duracion, cantidad_asistentes from capacitacion where id_capacitacion = '" + idCapacitacion + "'";
        Capacitacion capacitacion = null;
        try {
            connection = Conexion.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                capacitacion = new Capacitacion(resultSet.getInt("rut_cliente"), resultSet.getString("dia"),
                        resultSet.getString("hora"), resultSet.getString("lugar"), resultSet.getLong("id_capacitacion"),
                        resultSet.getString("duracion"), resultSet.getInt("cantidad_asistentes"));
            }
            resultSet.close();
            statement.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return capacitacion;
    }

    @Override
    public void update(Capacitacion capacitacion) {
        String sql = "update capacitacion set rut_cliente = '" + capacitacion.getRutCliente() + "', "
                + "dia = '" + capacitacion.getDia() + "', hora = '"
                + capacitacion.getHora() + "', lugar = '" + capacitacion.getLugar() + "', id_capacitacion = '"
                + capacitacion.getIdCapacitacion().intValue() + "', duracion = '" + capacitacion.getDuracion()
                + "', cantidad_asistentes = '" + capacitacion.getCantidadAsistentes()+ "' where id_capacitacion ='" + capacitacion.getIdCapacitacion() + "'";
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
    public void delete(Long idCapacitacion) {
        String sql = "delete capacitacion where id_capacitacion = '" + idCapacitacion + "'";
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
