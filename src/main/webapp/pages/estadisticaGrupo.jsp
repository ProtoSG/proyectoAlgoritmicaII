<%@page import="logica.Estudiante"%>
<%@page import="logica.Grupo"%>
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
    <%Grupo grupo = (Grupo)request.getSession().getAttribute("grupo"); %>
    
        <%@include file="../components/navBarProfesor.jsp"%>
        <section class="py-8mt-10 flex items-center justify-center">
        <div class="max-w-screen-xl rounded-2xl py-10 mx-10 px-4 sm:px-6 lg:px-8 bg-[#FFD6BE] mt-10">
            <div class="lg:text-center">
                <p class="mt-2 text-3xl leading-8 font-extrabold tracking-tight text-black sm:text-4xl">
                    Estadísticas de <%=grupo.getNombreGrupo()%>
                </p>
            </div>

            <div class="mt-10">
                <div class="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Cantidad de textos resueltos por todos los alumnos
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    <%=grupo.cantidadTextosResueltos()%>
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Porcentaje de preguntas correctamente respondidas por alumno
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    <%=grupo.preguntasCorrectasAlumno()%>
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Porcentaje promedio de preguntas correctamente respondidas por texto por alumno
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    <%=grupo.preguntasCorrectasTextoAlmuno()%>
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Textos más leídos
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    <%=grupo.textoMasLeidos()%>
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Textos más fáciles de resolver por sus alumnos
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    <%=grupo.textoMasFacilesResolver()%>
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="px-4 py-5 sm:p-6">
                            <dl>
                                <dt class="text-base font-normal text-gray-900">
                                    Textos más difíciles de resolver por sus alumnos
                                </dt>
                                <dd class="mt-1 text-3xl font-semibold text-gray-700">
                                    
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
