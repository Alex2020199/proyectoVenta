
package CRUD;

import Modelo.Conexion;
import Modelo.DetalleVentaModel;
import Modelo.VentaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

// Hereda de la clase Conexion
// Se implemente una interfaz con metodos que se utilizaran para generar el reporte
public class VentaCRUD extends Conexion {

    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    // metodo para generar numero serie de ventas
    public String NroSerieVentas() {
        String serie ="";
        String sql = "select max(NumeroSerie) from Ventas";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el proceso: " +  e.getMessage());
        }

        return serie;
    }
    
    // obtener id de ventas 
    public String IdVentas() {
        String idv = "";
        String sql = "select max(id) from Ventas";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                idv = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el proceso: " +  e.getMessage());
        }

        return idv;
    }

    // guardar la venta
    public int GuardarVentas(VentaModel v) {
        VentaModel vm = new VentaModel();
        String sql = "insert into Ventas(IdCliente, IdVendedor, NumeroSerie, FechaVentas, Monto, Estado) values(?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setString(3, v.getSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            r = ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la venta: " +  e.getMessage());
        }

        return r;
    }
    
    // guardar detalle de ventas
    public int GuardarDetalleVentas(DetalleVentaModel dv) {
       DetalleVentaModel dvm = new DetalleVentaModel();
        String sql = "insert into Detalle_Ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) values(?,?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecioVenta());
            r = ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el detalle de venta: " +  e.getMessage());
        }

        return r;
    }
}
