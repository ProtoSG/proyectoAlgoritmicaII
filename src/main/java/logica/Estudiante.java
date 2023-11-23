package logica;

import java.util.List;

public class Estudiante extends Usuario{
    private Grupo grupo;
    private final List<Texto> textosLeidos;
    private int textosResueltos;
    private int preguntasCorrectas;

    public Estudiante(Grupo grupo, List<Texto> textosLeidos, int textosResueltos, int preguntasCorrectas, String nombreUsuario, String contraseña, String nombres, String apellidos, String fechaNacimiento) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimiento);
        this.grupo = grupo;
        this.textosLeidos = textosLeidos;
        this.textosResueltos = textosResueltos;
        this.preguntasCorrectas = preguntasCorrectas;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getTextosResueltos() {
        return textosResueltos;
    }

    public void setTextosResueltos(int textosResueltos) {
        this.textosResueltos = textosResueltos;
    }

    public int getPreguntasCorrectas() {
        return preguntasCorrectas;
    }

    public void setPreguntasCorrectas(int preguntasCorrectas) {
        this.preguntasCorrectas = preguntasCorrectas;
    }
    
    
}
