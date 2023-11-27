package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class procesadorArchivo {
     Controladora control = new Controladora();

    public static void main(String[] args) {
        String nombreArchivo = "ruta/del/archivo.txt";
        List<String> lineas = leerArchivo(nombreArchivo);

        if (lineas != null) {
            procesarInformacion(lineas);
        }
    }

    private static List<String> leerArchivo(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return lineas;
    }

    private static void procesarInformacion(List<String> lineas) {
        // Variables para almacenar información temporal
        int id = -1;
        String texto = "";
        List<Pregunta> preguntas = new ArrayList<>();
        List<String> alternativas = new ArrayList<>();
        int respuestaCorrecta = 0;

        // Iterar sobre las líneas del archivo
        for (String linea : lineas) {
            // Identificar bloques y procesar la información dentro de cada bloque
            if (linea.startsWith("ID: ")) {
                id = Integer.parseInt(linea.substring(4).trim());
            } else if (linea.startsWith("===========================TEXTO====================================")) {
                // Iniciar la lectura del texto
                texto = "";
            } else if (linea.startsWith("===========================PREGUNTA")) {
                // Almacenar la pregunta actual y preparar para la siguiente
                if (!alternativas.isEmpty()) {
                    // Crear una nueva instancia de Pregunta
                    Pregunta pregunta = new Pregunta();
                    pregunta.setEnunciado(texto);
                    pregunta.setAlternativas(alternativas);
                    pregunta.setRespuestaCorrecta(respuestaCorrecta);

                    // Agregar la pregunta a la lista
                    preguntas.add(pregunta);

                    // Limpiar alternativas para la siguiente pregunta
                    alternativas.clear();
                }
            } else if (linea.startsWith("===========================ALTERNATIVAS====================================")) {
                // Iniciar la lectura de alternativas
            } else if (linea.startsWith("===========================ALTERNATIVA CORRECTA")) {
                // Almacenar la alternativa correcta
                respuestaCorrecta = Integer.parseInt(linea.substring(39).trim());
            } else if (linea.startsWith("===========================")) {
                // Fin del bloque actual, continuar con la siguiente línea
            } else if (!linea.isEmpty()) {
                // Agregar alternativas a la lista
                alternativas.add(linea.substring(2).trim());
            } else {
                // Fin del bloque de alternativas, guardar pregunta en la BD
                if (!alternativas.isEmpty()) {
                    // Crear una nueva instancia de Pregunta
                    Pregunta pregunta = new Pregunta();
                    pregunta.setEnunciado(texto);
                    pregunta.setAlternativas(alternativas);
                    pregunta.setRespuestaCorrecta(respuestaCorrecta);

                    // Agregar la pregunta a la lista
                    preguntas.add(pregunta);

                    // Limpiar alternativas para la siguiente pregunta
                    alternativas.clear();
                }

                // Guardar el texto y las preguntas en la BD
                //control.crearTexto(texto, preguntas);

                // Limpiar preguntas para el siguiente bloque
                preguntas.clear();
                respuestaCorrecta = 0;
            }

            // Almacenar el contenido del texto
            if (!linea.startsWith("=")) {
                texto += linea + "\n";
            }
        }
    }
}