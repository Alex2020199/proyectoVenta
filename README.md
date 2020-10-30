# Proyecto de Ventas

_Repositorio del proyecto de graduacion 2020_


### Pre-requisitos 📋

- Java 8
- Netbeans

### Abrir proyecto 🔧
entrar a netbeans, opcion file o archivo, click en abrir proyecto 

### Configurar base de datos en la clase conexion 🔧
Luego de haber entrado al proyecto, ir a los paquetes >Modelo>Conexion.java
y abrir el archivo 

```
    public static final String USERNAME = "tu usuario de base de datos";
    public static final String PASSWORD = "tu contrasenia de usuario";
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "ProyectoVentas";
    public static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
```

### Ejecutar el proyecto

ir al paquete vistas del proyecto, y elegir el formulario "LoginForm.java"
click derecho en el archivo y elegir la opcion "run file" o con la combinacion "shift+f6"



