
package Reportes;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// Hereda de la clase Conexion
// Se implemente una interfaz con metodos que se utilizaran para generar el reporte
public class ClienteCompra extends Conexion implements GenerarReporte {
    
    // Metodo de la interfaz de GenerarReportes;
    @Override
    public ResultSet generar() {
        ResultSet filas = null;
        Statement st = null;
        try {
             // se crea conexion que se heredo de la clase Conexion
            st = connection.createStatement();
            // String de consulta
            String sql = "select c.Nombres as Cliente, c.Nit, sum(v.Monto) as Total, count(*) Compras from Ventas v\n"
                    + "inner join cliente c on v.IdCliente = c.id\n"
                    + "inner join vendedor ve on v.IdVendedor = ve.id\n"
                    + "group by c.Nombres\n"
                    + "order by Compras desc;";
            filas = st.executeQuery(sql);
        // manejo de expeciones
        } catch (SQLException e) {
            System.err.println("Error en la carga del driver: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error en: " + e.getMessage());
        }
        // retorna resultado obtenido
        return filas;
    }

}
