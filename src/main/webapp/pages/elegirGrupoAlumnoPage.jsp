<%-- 
    Document   : elegirGrupoAlumnoPage
    Created on : 26 nov. 2023, 19:34:16
    Author     : dgocr
--%>

<%@page import="logica.Profesor"%>
<%@page import="logica.Controladora"%>
<%@page import="logica.Grupo"%>
<%@page import="logica.Estudiante"%>
<%@page import="java.util.List"%>
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
        <section class="py-8mt-10 flex items-center justify-center">
            <div class="max-w-screen-xl rounded-2xl py-10 mx-10 px-4 sm:px-6 lg:px-8 bg-[#FFD6BE] mt-10">
                <div class="lg:text-center">
                    <p class="mt-2 text-3xl leading-8 font-extrabold tracking-tight text-black sm:text-4xl">
                        Grupos
                    </p>
                </div>
                <div class="mt-10">
                    <div class="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
                        <%
                            List<Grupo> listaGrupos =(List)request.getSession().getAttribute("listaGrupos");
                        %>
                        <% for(Grupo grupo : listaGrupos){ %>
                        <div class="bg-white overflow-hidden shadow rounded-lg">
                            <div class="px-4 py-5 sm:p-6">
                                 <form action="../SvActualizarEstudiante" method="POST">
                                    <input type="hidden" name="grupoId" value="<%=grupo.getIdGrupo()%>" />
                                    <dl>
                                        <dd class="mt-1 text-3xl mb-4 text-center font-semibold text-gray-700">
                                            Grupo <%=grupo.getNombreGrupo()%>
                                        </dd>
                                        <dt class="text-base font-normal text-gray-900">
                                            Codigo: <%=grupo.getCodigoGrupo()%>
                                        </dt>
                                        <dt class="text-base font-normal text-gray-900">
                                            <%
                                                Profesor profesor = grupo.getProfesor();
                                            %>
                                            Profesor : <%=profesor.getNombre()%>
                                        </dt>
                                    </dl>
                                        <div class="flex items-center justify-center mt-5">
                                            <button type="submit" class="text-center text-xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">
                                                Seleccionar Grupo
                                            </button>
                                        </div>
                                </form>
                            </div>
                        </div>  
                    <%}%>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
