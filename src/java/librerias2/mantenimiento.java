/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ARosa
 */
public class mantenimiento extends bd{
    Statement sen;
    PreparedStatement sen2;
    
    public boolean insertar (int codigo, String nombre, double precio, int stock) {
        try {
            String sql = "INSERT INTO productos values (?, ?, ?, ?)";
            sen2 = obtenerConexion().prepareStatement(sql);
            sen2.setInt(1, codigo);
            sen2.setString(2, nombre);
            sen2.setDouble(3, precio);
            sen2.setInt(4, stock);
            sen2.executeUpdate();
        }catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto.");
        }
        return true;
    }
    
    public ResultSet consultar () {
        ResultSet data = null;
        try {
            sen = obtenerConexion().createStatement();
            data = sen.executeQuery("SELECT * FROM productos");
            
        }catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Error en la consulta.");
        }
        return data;
    }
    
    public ResultSet consultarXnombre (String nombre) {
        ResultSet data = null;
        try {
            sen = obtenerConexion().createStatement();
            data = sen.executeQuery("SELECT * FROM productos where nombre = '" + nombre + "'");
            
        }catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Error en la consulta.");
        }
        return data;
    }
}
