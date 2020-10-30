
package CRUD;

import java.util.List;

// Interfaz con metodos abstractos utilizados para los CRUD de las entidades
public interface CRUD {
    public List listar();
    public int add(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int id);
}
