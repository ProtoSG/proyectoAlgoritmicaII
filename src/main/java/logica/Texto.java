package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Texto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTexto;
    @Column(length = 5000)
    private String texto;
    @OneToMany(mappedBy="texto", cascade = CascadeType.PERSIST)
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
    
    public String limitarPalabras(int limite){
        List<String> palabras = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(texto);

        while(tokenizer.hasMoreTokens()){
        palabras.add(tokenizer.nextToken());
        }

        palabras = palabras.subList(0, Math.min(limite, palabras.size()));
        StringBuilder resultado = new StringBuilder();
                Iterator<String> iterator = palabras.iterator();
                while (iterator.hasNext()) {
                    resultado.append(iterator.next());
                    if (iterator.hasNext()) {
                        resultado.append(" ");
                    }
                }

        return resultado.toString();
        }
}
