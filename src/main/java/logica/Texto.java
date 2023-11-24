package logica;

import java.util.List;

public class Texto {
    private int idTexto;
    private String texto;
    private List<Pregunta> listaPreguntas;

    public Texto() {
    }

    public Texto(int idTexto, String texto, List<Pregunta> listaPreguntas) {
        this.idTexto = idTexto;
        this.texto = texto;
        this.listaPreguntas = listaPreguntas;
    }

    public int getIdTexto() {
        return idTexto;
    }

    public void setIdTexto(int idTexto) {
        this.idTexto = idTexto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    
    
}
