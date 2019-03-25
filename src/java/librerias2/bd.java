/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ARosa
 */
public class bd {
    private Connection cnx;
    String driver = "com.mysql.jdbc.Driver";
    String cadena = "jdbc:mysql://localhost/inventario";
    String usuario = "root";
    String clave = "";
    
    public Connection obtenerConexion() {
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(cadena, usuario, clave);
            
        } catch(ClassNotFoundException | SQLException e1) {
            
        }
        return cnx;
    }
}
