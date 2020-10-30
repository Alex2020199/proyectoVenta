
package Reportes;

import java.sql.ResultSet;


//Interfaz para que se implemente en los reportes
public interface GenerarReporte {
    // metodo abstracto que se utilizara en otra clase
     public ResultSet generar();
}
