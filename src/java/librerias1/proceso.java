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
public class proceso extends HttpServlet {

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
            String nombre = "";
            Double precio, subtotal = 0.0, igv = 0.0, total = 0.0;
            int cantidad;
            if(request.getParameter("registrar") != null) {
                nombre = request.getParameter("txtNombre");
                precio = Double.parseDouble(request.getParameter("txtPrecio"));
                cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                
                subtotal = precio * cantidad;
                igv = subtotal * 0.18;
                total = subtotal + igv;
                
                /*String pr = precio.toString();
                String can = String.valueOf(cantidad);
                
                if (nombre.isEmpty() || "".equals(pr) || "".equals(can)) {
                    out.println("<div class='container w-25 p-3 alert alert-warning'>Complete los campos vacíos</div>");
                }*/
                        
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Laboratorio 4</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container w-50 p-3'>");
            out.println("<h3 class='border-bottom'>Reporte del producto: " + nombre + "</h3><br/>");
            out.println("<p>Subtotal: " + subtotal + " </p>");
            out.println("<p>IGV: " + igv + "</p>");
            out.println("<p>Total: " + total + "</p>");
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
