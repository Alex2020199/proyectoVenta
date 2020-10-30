
package Modelo;

 // Se establece campos de la tabla para luego se utilizado como objeto
public class ClienteModel {
   int id;
   String dpi;
   String nit;
   String nombres;
   String telefono;
   String direccion;

    public ClienteModel() {
    }

    public ClienteModel(int id, String dpi, String nit, String nombres, String telefono, String direccion) {
        this.id = id;
        this.dpi = dpi;
        this.nit = nit;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   
   
}
