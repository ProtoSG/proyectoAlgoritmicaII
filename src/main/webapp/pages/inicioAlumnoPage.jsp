<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page import="logica.Texto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../components/header.jsp"%>
    <body class="h-screen bg-[url('../assets/fondo.png')]">
        <%@include file="../components/navBar.jsp"%>
        <div class="flex items-center">
        <div class="md:container md:mx-auto pb-10 mt-10 px-20 w-full bg-[#FFD6BE] rounded-2xl ">
            
                <div class="relative mt-10">
                    <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                        <svg class="w-4 h-4 text-black dark:text-black" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
                        </svg>
                    </div>
                    <input type="search" id="searchInput" class="text-xl block w-full p-4 ps-10 text-sm text-[#7A4A2F] border border-gray-300 rounded-lg bg-gray-50 focus:ring-[#7A4A2F] focus:border-[7A4A2F] dark:bg-[#FFD6BE] dark:border-gray-700 dark:placeholder-gray-900 dark:text-black dark:focus:ring-[#7A4A2F] dark:focus:border-[#7A4A2F]" placeholder="Buscar Texto..." required>
                    <button type="submit" class="text-xl text-white absolute end-2.5 bottom-2.5 bg-[#7A4A2F] hover:bg-[#7A4A2F] focus:ring-4 focus:outline-none focus:ring-[#7A4A2F] font-medium rounded-lg text-sm px-4 py-2 dark:bg-[#7A4A2F] dark:hover:bg-[#3B1B09] dark:focus:ring-blue-800">Search</button>
                </div>
                <div id="list">
                <%
                    List<Texto> listaTextos = (List)request.getSession().getAttribute("listaTexto"); 
                   
                    for(Texto texto:listaTextos){
   
                        String textoLimirado = texto.limitarPalabras(50);
                %>
                <form action="../SvObtenerTexto" method="POST"> 
                <input hidden name="id" value="<%=texto.getIdTexto()%>">
                <div style="display: none" id="contenText" class="mt-10 border-solid border-2 border-black p-2 rounded-2xl">
                    <div class=" text-2xl">
                        <p ><%=textoLimirado%> ...</p>
                    </div>
                    <div class="mt-4">
                        <button type="submit" class="w-40 h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">Abrir</button>
                    </div>
                </div>
                </form>
                   
                <%}%>
                </div>
        </div>
        
    </div>
                <script src="../scripts/busquedaTexto.js"></script>
    </body>
</html>

