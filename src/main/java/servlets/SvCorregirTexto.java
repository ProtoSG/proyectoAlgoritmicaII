
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvCorregirTexto", urlPatterns = {"/SvCorregirTexto"})
public class SvCorregirTexto extends HttpServlet {

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
        List<String> respuestas = obtenerRespuestas(request);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("respuestas", respuestas);
        
        response.sendRedirect("pages/solucionTexto.jsp");
        
    }
    
    private List<String> obtenerRespuestas(HttpServletRequest request){
        int cantidadPreguntas = Integer.parseInt(request.getParameter("cantidadPreguntas"));
        List<String> respuestas = new ArrayList<>();
        
        for(int i = 1; i <= cantidadPreguntas; i++){
            String respuesta = request.getParameter("respuestaCorrecta" + i);
            respuestas.add(respuesta);
        }

        return respuestas;
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
