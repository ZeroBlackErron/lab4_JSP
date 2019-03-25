/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias1;

/**
 *
 * @author ARosa
 */
public class Usuario {
    
    public boolean ingresar (String nombre, String clave) {
        if ( "arosado".equals(nombre) && "123456".equals(clave)) {
            return true;
        }else if ("gmiranda".equals(nombre) && "654321".equals(clave)){
            return true;
        }
        return false;
    }
}
