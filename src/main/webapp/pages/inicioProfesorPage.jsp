
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Profesor"%>
<%@page import="logica.Grupo"%>
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
        <%@include file="../components/navBarProfesor.jsp"%>
                <section class="py-8mt-10 flex items-center justify-center">
        <div class="max-w-screen-xl rounded-2xl py-10 mx-10 px-4 sm:px-6 lg:px-8 bg-[#FFD6BE] mt-10 flex gap-5">
            <div class="w-1/3">
                    <img src="../assets/perfil.png" alt="Foto de perfil" class="h-40 w-40 rounded-full">
                </div>
                <div class="w-2/3">
                    <div class="">
                        <% 
                           Profesor profesor = (Profesor)request.getSession().getAttribute("profesor");
                           Date dateParameter = profesor.getFechaNacimiento();
                           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                           String fechaFormateada = sdf.format(dateParameter);
                        %>
                        <h2 class="text-2xl font-bold"><%=request.getSession().getAttribute("usuario")%></h2>
                        <p class="text-lg">Nombres: <span class="font-bold"><%=profesor.getNombre()%></span></p>
                        <p class="text-lg">Apellidos: <span class="font-bold"><%=profesor.getApellido()%></span></p>
                        <p class="text-lg">Fecha de nacimiento: <span class="font-bold"><%=fechaFormateada%></span></p>
                        <p class="text-lg">Carrera Profesional: <span class="font-bold"><%=profesor.getCarreraProfesional()%></span></p>
                    </div>
                </div>
            </div>
    </section>
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
                            List<Grupo> listGroup = profesor.getListaGrupos();
                        %>
                    <% for(Grupo grupo : listGroup){ %>
                        <div class="flex-col justify-between bg-white overflow-hidden shadow rounded-lg pb-5">
                            <div class="px-4 py-5 sm:p-6">
                                <dl>
                                    <dd class="mt-1 text-3xl mb-4 text-center font-semibold text-gray-700">
                                        Grupo <%=grupo.getNombreGrupo()%>
                                    </dd>
                                    <dt class="text-base font-normal text-gray-900">
                                        Codigo: <%=grupo.getCodigoGrupo()%>
                                    </dt>
                                </dl>
                            </div>
                            <form action="../SvVerGrupo" method="POST">
                                <input hidden type="text" name="idGrupo" value="<%=grupo.getIdGrupo()%>">
                                <div class="mt-5 flex justify-center">
                                    <button type="submit" class=" h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">Ingresar</button>
                                </div>
                            </form>
                        </div>
                    <%}%>
                    </div>
                </div>
                <div class="mt-5 flex justify-center">
                    <a href="crearGrupo.jsp" class=" h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">Crear nuevo grupo</a>
                </div>
            </div>
        </section>
    </body>
</html>
