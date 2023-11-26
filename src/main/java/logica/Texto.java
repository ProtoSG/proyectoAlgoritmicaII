package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Texto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTexto;
    private String texto;
    @OneToMany(mappedBy="texto")
    private List<Pregunta> listaPreguntas;
    @ManyToOne
    @JoinColumn(name="id_estudiante")
    private Estudiante estudiante;
    
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
