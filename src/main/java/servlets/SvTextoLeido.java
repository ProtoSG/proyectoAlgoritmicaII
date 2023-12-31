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
import logica.Estudiante;
import logica.Texto;


@WebServlet(name = "SvTextoLeido", urlPatterns = {"/SvTextoLeido"})
public class SvTextoLeido extends HttpServlet {

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
        
        
        Texto texto = (Texto)request.getSession().getAttribute("texto");
        int cantidadPreguntasCorrectas = Integer.parseInt(request.getParameter("cantidadPreguntasCorrectas"));
        Estudiante estudiante = (Estudiante)request.getSession().getAttribute("estudiante");
        
        control.agregarTextoLeido(texto, cantidadPreguntasCorrectas, estudiante);
        
        response.sendRedirect("pages/inicioAlumnoPage.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
