package Reportes;

import Modelo.ClienteModel;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Hereda de la clase Conexion
// Se implemente una interfaz con metodos que se utilizaran para generar el reporte
public class VentaSemana extends Conexion implements GenerarReporte {

    PreparedStatement ps;
    ResultSet rs;

    // Metodo de la interfaz de GenerarReportes;
    @Override
    public ResultSet generar() {
        ResultSet filas = null;
        Statement st = null;
        try {
            // se crea conexion que se heredo de la clase Conexion
            st = connection.createStatement();
            // String de consulta
            String sql = "select v.FechaVentas, v.NumeroSerie, c.Nombres as Cliente, c.Nit, ve.Nombres as Vendedor, v.Monto as TotalVenta from Ventas v\n"
                    + "inner join cliente c on v.IdCliente = c.id\n"
                    + "inner join vendedor ve on v.IdVendedor = ve.id\n"
                    + "where week(now(),1)-1 = week(v.FechaVentas);";
            filas = st.executeQuery(sql);
            // Manejo de excepciones
        } catch (SQLException e) {
            System.err.println("Error en la carga del driver: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error en: " + e.getMessage());
        }
        // envia resultado de la consulta
        return filas;
    }

}
