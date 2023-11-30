package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TextoLeido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Texto texto;
    private int respuestasCorrectas;
    
    @JoinColumn(name="id_estudiante")
    private Estudiante estudiante;
    
    public TextoLeido() {
    }

    public TextoLeido(int id, Texto texto, int respuestasCorrectas) {
        this.id = id;
        this.texto = texto;
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }

    public int getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public void setRespuestasCorrectas(int respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }
    
    
    
}
