/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias2;

/**
 *
 * @author ARosa
 */
public class Producto {
    int codigo;
    String nombre;
    Double precio;
    int stock;
    
    public Producto (int codigo, String nombre, Double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}
