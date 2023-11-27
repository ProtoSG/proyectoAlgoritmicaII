<%-- 
    Document   : estadisticaAlumnoPage
    Created on : 25 nov. 2023, 17:44:59
    Author     : dgocr
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Estudiante"%>
<%@page import="logica.Controladora"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%Controladora control = new Controladora();%>
<html>
    <%@include file="../components/header.jsp"%>
    <body class="h-screen bg-[url('../assets/fondo.png')]">
        <%@include file="../components/navBar.jsp"%>
        <section class="py-8mt-10 flex items-center justify-center">
        <div class="max-w-screen-xl rounded-2xl py-10 mx-10 px-4 sm:px-6 lg:px-8 bg-[#FFD6BE] mt-10 flex gap-5">
            <div class="w-1/3">
                    <img src="../assets/perfil.png" alt="Foto de perfil" class="h-40 w-40 rounded-full">
                </div>
                <div class="w-2/3">
                    <div class="">
                        <% String userName = (String) request.getSession().getAttribute("usuario");
                           Usuario usuario1 = control.getUsuario(userName);
                           Estudiante estudiante = control.getEstudiante(usuario1.getIdUsuario());
                           Date dateParameter = estudiante.getFechaNacimiento();
                           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                           String fechaFormateada = sdf.format(dateParameter);
                        %>
                        <h2 class="text-2xl font-bold"><%=request.getSession().getAttribute("usuario")%></h2>
                        <p class="text-lg">Nombres: <span class="font-bold"><%=estudiante.getNombre()%></span></p>
                        <p class="text-lg">Apellidos: <span class="font-bold"><%=estudiante.getApellido()%></span></p>
                        <p class="text-lg">Fecha de nacimiento: <span class="font-bold"><%=fechaFormateada%></span></p>
                        <p class="text-lg">Grupo: <span class="font-bold"><%=estudiante.getGrupo().getNombreGrupo()%></span></p>
                    </div>
                </div>
            </div>
    </section>
    <section class="py-8mt-10 flex items-center justify-center">
        <div class="max-w-screen-xl rounded-2xl py-10 mx-10 px-4 sm:px-6 lg:px-8 bg-[#FFD6BE] mt-10">
            <div class="lg:text-center">
                <p class="mt-2 text-3xl leading-8 font-extrabold tracking-tight text-black sm:text-4xl">
                    Estadísticas
                </p>
            </div>
            <div class="mt-10">
                <div class="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Cantidad de textos leídos
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    10
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Porcentaje de preguntas correctamente respondidas en total
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    80%
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Porcentaje promedio de preguntas correctamente respondidas por texto
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    75%
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Porcentaje de textos en los que el estudiante falló todas las preguntas
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    10%
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Porcentaje de textos en los que el estudiante acertó todas las preguntas
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    20%
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </body>
</html>
