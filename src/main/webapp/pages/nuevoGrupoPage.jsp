<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../components/header.jsp"%>
    <body class="h-screen bg-[url('../assets/fondo.png')]">
        <%@include file="../components/navBarProfesor.jsp"%>
        
        <section class=" py-8mt-10 flex items-center justify-center">
            <div class="w-1/2 max-w-screen-xl  rounded-2xl py-10 mx-10 px-4 sm:px-6 lg:px-8 bg-[#FFD6BE] mt-10">
                <div class="lg:text-center">
                    <p class="mt-2 text-3xl leading-8 font-extrabold tracking-tight text-black sm:text-4xl">
                        Nuevo Grupo
                    </p>
                </div>
                <form class="user" action="../SvGrupo" method="POST">
                    <div class=" mt-10">
                        <label for="price" class="text-2xl block text-sm font-medium leading-6 text-gray-900">Nombre</label>
                        <div class="relative mt-2 rounded-md shadow-sm">
                          <input required type="text" name="name" id="name" class="h-12 block w-full rounded-md border-0 py-1.5 pl-2 pr-20 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="Nombre del nuevo grupo">
                        </div>
                      </div>
                    <div class=" mt-10">
                        <label for="price" class="text-2xl block text-sm font-medium leading-6 text-gray-900">Codigo</label>
                        <div class="relative mt-2 rounded-md shadow-sm">
                          <input required type="text" name="codigo" id="codigo" class="h-12 block w-full rounded-md border-0 py-1.5 pl-2 pr-20 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="Codigo del nuevo grupo">
                        </div>
                      </div>
                    <div class="mt-10 flex justify-center">
                        <button type="submit" class=" h-14 text-2xl  text-white bg-[#7A4A2F] hover:bg-[#3B1B09]  rounded-lg px-4 py-2">Crear Grupo</button>
                    </div>
                </form>
            </div>
        </section>
    </body>
</html>
