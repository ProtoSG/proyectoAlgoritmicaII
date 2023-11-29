<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logica.Texto"%>
<%@page import="logica.Pregunta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../components/header.jsp"%>
    <body class="h-screen bg-[url('../assets/fondo.png')]">
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
                        List<String> respuestasDadas = (List<String>) request.getSession().getAttribute("respuestas");
                        List<Integer> respuestasDadasInt = new ArrayList<>();
                        int respuestaCorrectaInt = -1;
                        for (String respuesta : respuestasDadas) {
                            switch (respuesta.toUpperCase()) {
                                case "A":
                                    respuestaCorrectaInt = 0;
                                    break;
                                case "B":
                                    respuestaCorrectaInt = 1;
                                    break;
                                case "C":
                                    respuestaCorrectaInt = 2;
                                    break;
                                case "D":
                                    respuestaCorrectaInt = 3;
                                    break;
                                case "E":
                                    respuestaCorrectaInt = 4;
                                    break;
                                default:
                                    respuestaCorrectaInt = -1;
                                    break;
                            }
                            respuestasDadasInt.add(respuestaCorrectaInt);
                        }

                        int i = 0;
                        String mensajeAcerto = "";
                        for (Pregunta pregunta : preguntas) {
                            if (respuestasDadasInt.get(i) == pregunta.getRespuestaCorrecta()) {
                                mensajeAcerto = "Correcto";
                            } else {
                                mensajeAcerto = "Incorrecto";
                            }
                    %>
                    <div class="my-5 font-bold">
                        <h2>Pregunta <%=i+1%></h2>
                    </div>
                    <div>
                        <h3><%=pregunta.getEnunciado()%></h3>
                    </div>
                    <div class="my-5 font-semibold">Alternativas</div>
                    <div class="mb-5">
                        <ul>
                            <%
                                List<String> alternativas = pregunta.getAlternativas();
                                for (String alternativa : alternativas) {
                            %>
                            <li><%=alternativa%></li>
                            <%}%>
                        </ul>
                    </div>
                    <p>Respuesta Correcta:</p>
                    <%
                        int j = 0;
                        String respuestaCorrecta = "";
                        for (String alternativa : alternativas) {
                            if (j == pregunta.getRespuestaCorrecta()) {
                                respuestaCorrecta = alternativa;
                            }
                            j++;
                        }
                    %>                
                    <p><%=respuestaCorrecta%></p>
                    <%
                        if(mensajeAcerto == "Correcto"){
                    %>    
                        <p class="text-lime-500"><%=mensajeAcerto%></p>
                    <%}else{%>
                        <p class="text-rose-600"><%=mensajeAcerto%></p>

                    <%}%>
                    <% i++; } %>
                    <input hidden id="cantidadPreguntas" name="cantidadPreguntas" value="<%=i%>" type="text">
                    <div class="mt-4">
                        <button type="submit" class="w-40 h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">Enviar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>