package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Profesor;
import logica.Usuario;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    
    Controladora control = new Controladora();
    
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
        
        String userName = request.getParameter("userName");
        String contrasena = request.getParameter("contrasena");
        
        Usuario usuario = control.comprobarIngreso(userName, contrasena);

        
        if(usuario != null){
            
            Profesor profesor = control.getProfesor(usuario.getIdUsuario());
            
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", userName);
            String rol = usuario.getRol();
            if("alumno".equals(rol)){
                
                response.sendRedirect("pages/inicioAlumnoPage.jsp");
            }else if("profesor".equals(rol)){
                misession.setAttribute("profesor", profesor);
                System.out.println("profesor: " + misession.getAttribute("profesor"));
                response.sendRedirect("SvGrupo");
            }
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
