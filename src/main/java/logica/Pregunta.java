package logica;

public class Pregunta {
    private String enunciado;
    private String[] alternativas;
    private int respuestaCorrecta;
    private String razonamiento;

    public Pregunta(String enunciado, String[] alternativas, int respuestaCorrecta, String razonamiento) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respuestaCorrecta = respuestaCorrecta;
        this.razonamiento = razonamiento;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
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
