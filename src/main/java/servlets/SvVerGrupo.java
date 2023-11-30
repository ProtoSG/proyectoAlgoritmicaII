
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
import logica.Grupo;

@WebServlet(name = "SvVerGrupo", urlPatterns = {"/SvVerGrupo"})
public class SvVerGrupo extends HttpServlet {
    
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
        
        int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        
        Grupo grupo = control.getGrupo(idGrupo);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("grupo", grupo);
        
        response.sendRedirect("pages/estadisticaGrupo.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
