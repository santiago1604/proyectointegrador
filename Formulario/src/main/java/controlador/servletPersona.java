
package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Personas;

/**
 *
 * @author Brayan
 */
@WebServlet(name = "servletPersona", urlPatterns = {"/servletPersona"})
public class servletPersona extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ///////////////////////////////////////////////
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        
    
        
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
        
        
        /////////////////////////////////////////
        // Aca traigo los datos
        String Nombre = request.getParameter("nombre");
        String Apellido = request.getParameter("apellido");
        String Correo = request.getParameter("correo");
        String Telefono = request.getParameter("telefono");
        
        ////////////////////////////////////////
        ////Creo un objeto de tipo personas
        Personas persona = new Personas(Nombre, Apellido, Correo, Telefono);
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario", "root", "");
           
            String consulta = "INSERT INTO datos (nombre, apellido, correo, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Correo);
            ps.setString(4, Telefono);
            ps.executeUpdate();
            ps.close();
            conexion.close();
            response.sendRedirect("confirmacion.jsp");
        }
        catch(SQLException ex){
                response.getWriter().println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(servletPersona.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("error.jsp");
        }
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
