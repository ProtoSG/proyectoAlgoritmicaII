
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
import logica.Controladora;
import logica.Pregunta;
import logica.Texto;


@WebServlet(name = "SvTexto", urlPatterns = {"/SvTexto"})
public class SvTexto extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Texto> listText = new ArrayList<Texto>();
        listText = control.getTextos();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaTexto", listText);
        
        
     
            response.sendRedirect("pages/inicioAlumnoPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String texto = request.getParameter("texto");
        List<Pregunta> preguntas = obtenerPreguntasDesdeRequest(request);
        
     
        control.crearTexto(texto, preguntas);
        
        response.sendRedirect("pages/inicioProfesorPage.jsp");
    }
    
    private List<Pregunta> obtenerPreguntasDesdeRequest(HttpServletRequest request) {
        List<Pregunta> preguntas = new ArrayList<>();

        // Obtén la cantidad de preguntas desde el formulario
        int cantidadPreguntas = Integer.parseInt(request.getParameter("cantidadPreguntas"));

        // Itera sobre las preguntas y sus respuestas
        for (int i = 1; i <= cantidadPreguntas; i++) {
            String enunciado = request.getParameter("question" + i);
            
            String respuestString = request.getParameter("correctAnswer" + i);
            int respuestaCorrecta;
            switch (respuestString.toUpperCase()) {
                case "A":
                    respuestaCorrecta = 0;
                    break;
                case "B":
                    respuestaCorrecta = 1;
                    break;
                case "C":
                    respuestaCorrecta = 2;
                    break;
                case "D":
                    respuestaCorrecta = 3;
                    break;
                case "E":
                    respuestaCorrecta = 4;
                    break;
                case "F":
                    respuestaCorrecta = 5;
                    break;
                default:
                    respuestaCorrecta = -1;
                    break;
            }
            
            String razonamiento = request.getParameter("reason" + i);
            
            // Asegúrate de ajustar esto según la estructura real de tu formulario
            List<String> alternativas = obtenerAlternativasDesdeRequest(request, i);

            // Crea el objeto Pregunta y agrégalo a la lista
            Pregunta pregunta = new Pregunta();
            pregunta.setEnunciado(enunciado);
            pregunta.setAlternativas(alternativas);
            pregunta.setRespuestaCorrecta(respuestaCorrecta);
            pregunta.setRazonamiento(razonamiento);
            preguntas.add(pregunta);
        }

        return preguntas;
    }

    private List<String> obtenerAlternativasDesdeRequest(HttpServletRequest request, int numPregunta) {
        List<String> alternativas = new ArrayList<>();

        // Obtén la cantidad de alternativas para la pregunta específica
        int cantidadAlternativas = Integer.parseInt(request.getParameter("cantidadAlternativas" + numPregunta));

        // Itera sobre las alternativas
        for (int i = 1; i <= cantidadAlternativas; i++) {
            String alternativa = request.getParameter("alternative" + numPregunta + "_" + i);
            alternativas.add(alternativa);
        }

        return alternativas;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
