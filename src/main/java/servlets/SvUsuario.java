/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Persona;
import logica.Usuario;

/**
 *
 * @author dgocr
 */
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {
    
    
    Controladora control = new Controladora();
    Usuario usuario;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("nombreUsuario");
        String contrasena = request.getParameter("contrasena");
        String alumno = request.getParameter("alumno");
        String carreraProfesional = request.getParameter("carreraProfesional");
        
        String dateParameter = request.getParameter("date");
        Date date = null;
        
        if (dateParameter != null && !dateParameter.isEmpty()) {
            // El formato aquí debería coincidir con el formato esperado de la fecha en el parámetro.
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                date = dateFormat.parse(dateParameter);
            } catch (ParseException e) {
                e.printStackTrace(); 
            }
        }
        usuario = new Usuario();
        usuario.setNombreUsuario(userName);
        usuario.setContrasena(contrasena);
        
        boolean coincide = false;
        coincide = control.comprobarUsuario(userName);
        
        if(coincide){

        }else{
            if ("on".equals(alumno)) {
                usuario.setRol("alumno");
                control.crearEstudiante(usuario, name, lastName, date);
            }else{
                usuario.setRol("profesor");
                control.crearProfesor(usuario, name, lastName, date, carreraProfesional);
            }
        }

        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
