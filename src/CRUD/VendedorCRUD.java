
package CRUD;

import Modelo.Conexion;
import Modelo.VendedorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// Hereda de la clase Conexion
// Se implemente una interfaz con metodos que se utilizaran para generar el reporte
public class VendedorCRUD extends Conexion implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    // metodo para validar el usuario
    public VendedorModel validar(String Nombre, String Password) {
        VendedorModel vendedor = new VendedorModel();
        String sql = "select * from vendedor where User=? and Password=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Password);
            rs = ps.executeQuery();
            while (rs.next()) {
                vendedor.setId(rs.getInt(1));
                vendedor.setNombres(rs.getString(2));
                vendedor.setTelefono(rs.getString(3));
                vendedor.setEstado(rs.getString(4));
                vendedor.setUser(rs.getString(5));
                vendedor.setPassword(rs.getString(6));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo validar el usuario: " +  e.getMessage());
        }
        return vendedor;
    }

    // metodo para listar los registros
    @Override
    public List listar() {
        List<VendedorModel> lista = new ArrayList<>();
        String sql = "select * from Vendedor";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                VendedorModel m = new VendedorModel();
                m.setId(rs.getInt(1));
                m.setNombres(rs.getString(2));
                m.setTelefono(rs.getString(3));
                m.setEstado(rs.getString(4));
                m.setUser(rs.getString(5));
                m.setPassword(rs.getString(6));
                lista.add(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los registros: " +  e.getMessage());
        }

        return lista;
    }
    
    // metodo para agregar el registro
    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into Vendedor(Nombres, Telefono, Estado, User, Password) values(?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se pudo agregar el registro: " +  e.getMessage());
        }
        return r;
    }

    // metodo para actualizar
    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update Vendedor set Nombres=?, Telefono=?, Estado=?, User=?, Password=? where id = ? ";

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
    
    // metodo para eliminar
    @Override
    public void eliminar(int id) {
        String sql = "delete from Vendedor where id = ? ";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro: " +  e.getMessage());
        }
    }
}
