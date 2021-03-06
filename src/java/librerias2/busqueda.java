/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ARosa
 */
public class busqueda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            mantenimiento m = new mantenimiento();
            ResultSet datos = null;
            if (request.getParameter("buscar") != null) {
                String nombre = request.getParameter("txtNombre");
                
                if (nombre.isEmpty())
                    out.println("<div class='container w-25 p-3 alert alert-warning'>Complete el campo</div>");
                else    
                    datos = m.consultarXnombre(nombre);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Laboratorio 4</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1 class='text-center'>Productos</h1>");
            out.println("<form method='POST'>");
            out.println("<div class='form-group'>");
            out.println("<label for='txtNombre'>Nombre</label>");
            out.println("<input type='text' name='txtNombre' class='form-control'>");
            out.println("</div>");
            out.println("<div class='text-center'>");
            out.println("<button type='submit' class='btn btn-success' name='buscar'>Buscar</button>");
            out.println("</div>");
            out.println("</form><br/>");
            out.println("<table class='table'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th scope='col'>Código</th>");
            out.println("<th scope='col'>Nombre</th>");
            out.println("<th scope='col'>Precio</th>");
            out.println("<th scope='col'>Stock</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            try {
                while (datos.next()) {
                    out.println("<tr>");
                    out.println("<td>" + datos.getInt(1) + "</td>");
                    out.println("<td>" + datos.getString(2) + "</td>");
                    out.println("<td>" + datos.getDouble(3) + "</td>");
                    out.println("<td>" + datos.getInt(4) + "</td>");
                    out.println("</tr>");
                }
            }catch (SQLException e) {
                
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<div class='text-center'>");
            out.println("<a href='opciones.jsp'><button type='button' class='btn btn-secondary'>Volver</button></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
