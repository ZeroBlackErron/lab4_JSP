/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ARosa
 */
public class logueo extends HttpServlet {

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
            Usuario u = new Usuario();
            if (request.getParameter("ingresar") != null) {
                
                String nombre = request.getParameter("txtNombre");
                String clave = request.getParameter("txtClave");
                
                if (nombre.isEmpty() || clave.isEmpty())
                    out.println("<div class='container w-50 p-3 alert alert-warning text-center'>Complete los campos vacíos</div>");
                else {    
                    boolean conf = u.ingresar(nombre, clave);

                    if (conf) response.sendRedirect("menu.jsp");
                    else if (conf == false)
                        out.println("<div class='container w-50 p-3 alert alert-danger text-center'>Usuario y/o clave incorrectos</div>");
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Laboratorio 4</title>"); 
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container w-50 p-3'>");
            out.println("<h1><center>Caso 1</center></h1>");
            out.println("<form method='POST'>");
            out.println("<div class='form-group'>");
            out.println("<label for='nombre'>Usuario</label>");
            out.println("<input type='text' class='form-control' id='nombre' name='txtNombre'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='clave'>Contraseña</label>");
            out.println("<input type='password' class='form-control' id='clave' name='txtClave'>");
            out.println("</div>");
            out.println("<button type='submit' class='btn btn-primary' name='ingresar'>Ingresar</button>");
            out.println("<button type='reset' class='btn btn-secondary'>Limpiar</button>");
            out.println("</form>");
            out.println("</form>");
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
