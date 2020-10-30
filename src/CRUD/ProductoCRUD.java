
package CRUD;

import Modelo.Conexion;
import Modelo.ProductoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// Hereda de la clase Conexion
// Se implemente una interfaz con metodos que se utilizaran para generar el reporte
public class ProductoCRUD extends Conexion implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    // metodo para actualizar la cantidad de productos que hay
     public int actualizarStock(int cant, int id) {
        String sql = "update Producto set Stock=? where id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el stock: " +  e.getMessage());
        }

        return r;
    }
    
     // metodo para listar por id del producto para mostrar en el formulario de generar ventas
     public ProductoModel listarID(int id) {
        ProductoModel m = new ProductoModel();
        String sql = "select * from Producto where id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                m.setId(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setPrecio(rs.getDouble(3));
                m.setStock(rs.getInt(4));
                m.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el proceso: " +  e.getMessage());
        }

        return m;
    }

     // metodo para listar registros
    @Override
    public List listar() {
        List<ProductoModel> lista = new ArrayList<>();
        String sql = "select * from Producto";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductoModel m = new ProductoModel();
                m.setId(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setPrecio(rs.getDouble(3));
                m.setStock(rs.getInt(4));
                m.setEstado(rs.getString(5));
                lista.add(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar los registros: " +  e.getMessage());
        }

        return lista;
    }

    // metodo para agregar registros a la bd
    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into Producto(Nombres, Precio, Stock, Estado) values(?,?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el registro: " +  e.getMessage());
        }
        return r;
    }

    // metodo para actualizar registro
    @Override
    public int actualizar(Object[] o) {
          int r = 0;
        String sql = "update Producto set Nombres=?, Precio=?, Stock=?, Estado=? where id = ? ";

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro: " +  e.getMessage());
        }
        return r;
    }

    // metodo para mostrar eliminar registro por id
    @Override
    public void eliminar(int id) {
          String sql = "delete from Producto where id = ? ";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro: " +  e.getMessage());
        }
    }

}
