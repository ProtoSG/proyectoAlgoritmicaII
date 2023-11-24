package logica;

import java.util.List;

public class Pregunta {
    private int idPregunta;
    private String enunciado;
    private List<String> alternativas;
    private int respuestaCorrecta;
    private String razonamiento;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String enunciado, List<String> alternativas, int respuestaCorrecta, String razonamiento) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respuestaCorrecta = respuestaCorrecta;
        this.razonamiento = razonamiento;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<String> alternativas) {
        this.alternativas = alternativas;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRazonamiento() {
        return razonamiento;
    }

    public void setRazonamiento(String razonamiento) {
        this.razonamiento = razonamiento;
    }

    
}
