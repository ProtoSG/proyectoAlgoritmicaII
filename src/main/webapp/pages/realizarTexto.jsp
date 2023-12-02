<%-- 
    Document   : realizarTexto
    Created on : 29 nov. 2023, 00:39:24
    Author     : dgocr
--%>

<%@page import="java.util.List"%>
<%@page import="logica.Texto"%>
<%@page import="logica.Pregunta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../components/header.jsp"%>
    <body class="h-screen bg-[url('../assets/fondo.png')]">
        <% HttpSession misession = request.getSession();
        String usuario = (String) request.getSession().getAttribute("usuario");
        
        if(usuario == null){
            response.sendRedirect("../index.jsp");
        }
    %>
        <%@include file="../components/navBar.jsp"%>
        <div class="flex items-center">
        <div class="md:container md:mx-auto pb-10 mt-10 px-20 w-full bg-[#FFD6BE] rounded-2xl ">
            <form action="../SvCorregirTexto" method="POST">  
                <%
                    Texto texto = (Texto) request.getSession().getAttribute("texto");
                %>
                <div class="flex justify-center pt-5">
                    <h1 class="text-3xl ">Texto <%=texto.getIdTexto()%></h1>
                </div>
                <div class="pt-5">
                    <p class="text-lg"><%=texto.getTexto()%></p>
                </div>
                    <%
                        List<Pregunta> preguntas = texto.getListaPreguntas();
                        int i = 0;
                        for(Pregunta pregunta : preguntas){
                            i++;
                    %>
                <div class="my-5 font-bold">
                    <h2>Pregunta <%=i%></h2>
                </div>
                <div>
                    <h3><%=pregunta.getEnunciado()%></h3>
                </div>
                    <div class="my-5 font-semibold" >Alternativas</div>
                    <div class="mb-5">
                        <ul>
                            <%
                                List<String> alternativas = pregunta.getAlternativas();
                                for(String alternativa : alternativas){
                            %>
                            <li><%=alternativa%></li>
                            <%}%>
                        </ul>
                    </div>
                    <label for="respuestaCorrecta">Respuesta Correcta</label>
                    <input required id="respuestaCorrecta" name="respuestaCorrecta<%=i%>" type="text">
                <%}%>
                <input hidden id="cantidadPreguntas" name="cantidadPreguntas" value="<%=i%>" type="text">
                
                <div class="mt-4">
                    <button type="submit" class="w-40 h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">Enviar</button>
                </div>
            </form>
        </div>
        
    </div>
    </body>
</html>
