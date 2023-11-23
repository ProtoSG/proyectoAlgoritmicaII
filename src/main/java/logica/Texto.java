package logica;

import java.util.List;

public class Texto {
    private int id;
    private String texto;
    private List<Pregunta> preguntas;

    public Texto(String texto, List<Pregunta> preguntas) {
        this.texto = texto;
        this.preguntas = preguntas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
