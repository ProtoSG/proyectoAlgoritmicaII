<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
    <%@include file="../components/header.jsp"%>
    <body class="h-screen bg-[url('../assets/fondo.png')]">
        <%@include file="../components/navBarProfesor.jsp"%>
        <section class=" py-8mt-10 flex items-center justify-center">
        <div class="w-1/2 max-w-screen-xl  rounded-2xl py-10 mx-10 px-4 sm:px-6 lg:px-8 bg-[#FFD6BE] mt-10">
            <div class="lg:text-center">
                <p class="mt-2 text-3xl leading-8 font-extrabold tracking-tight text-black sm:text-4xl">
                    Nuevo Texto
                </p>
            </div>
            <form class="user" action="../SvTexto" method="POST">
                <div class=" mt-10">
                    <label for="texto" class="text-2xl block text-sm font-medium leading-6 text-gray-900">Texto</label>
                    <div class="relative mt-2 rounded-md shadow-sm">
                      <textarea required type="text" name="texto" id="texto" class="h-12 block w-full rounded-md border-0 py-1.5 pl-2 pr-20 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="Texto Nuevo"></textarea>
                     </div>
                </div>
                
                <div class="mt-5" id="questions-container">
                </div>
                
                <input hidden name="cantidadPreguntas" id="cantidadPreguntas" value="">
                
                <button type="button" id="add-question" class="mt-4 h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09] rounded-lg px-4 py-2">Agregar Pregunta</button>
                
                <div class="mt-10 flex justify-center">
                    <button type="submit" class=" h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">Crear Texto</button>
                </div>
                
            </form>
        </div>
    </section>
        <script src="../scripts/agregarTexto.js"></script>
    </body>
</html>

