
package CRUD;

import Modelo.ClienteModel;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// Hereda de la clase Conexion
// Se implemente una interfaz con metodos que se utilizaran para generar el reporte
public class ClienteCRUD extends Conexion implements CRUD {

    PreparedStatement ps;
    ResultSet rs;

    // metodo para mostrar el nombre cuando se envie el nit
    public ClienteModel listarID(String codigo) {
        List<ClienteModel> lista = new ArrayList<>();
        ClienteModel c = new ClienteModel();
        String sql = "select * from Cliente where nit = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {

                c.setId(rs.getInt(1));
                c.setDpi(rs.getString(2));
                c.setNit(rs.getString(3));
                c.setNombres(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setDireccion(rs.getString(6));
            }
        // manejo de excepciones
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el proceso: " +  e.getMessage());
        }

        return c;
    }

    // Listar registros que se persisten en la base de datos
    @Override
    public List listar() {
        List<ClienteModel> lista = new ArrayList<>();
        String sql = "select * from Cliente";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ClienteModel c = new ClienteModel();
                c.setId(rs.getInt(1));
                c.setDpi(rs.getString(2));
                c.setNit(rs.getString(3));
                c.setNombres(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setDireccion(rs.getString(6));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los registros: " +  e.getMessage());
        }

        return lista;
    }

    // metodo para agregar registros a la tabla
    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into Cliente(Dpi, Nit, Nombres, Telefono, Direccion) values(?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el registro: " +  e.getMessage());
        }
        return r;
    }

    // metodo para actualizar registros a la bd
    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update Cliente set Dpi=?, Nit=?, Nombres=?, Telefono=?, Direccion=? where id = ? ";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro: " +  e.getMessage());
        }
        return r;
    }

    
    // eliminar registro por id del registro
    @Override
    public void eliminar(int id) {
        String sql = "delete from Cliente where id = ? ";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro: " +  e.getMessage());
        }

    }

}
