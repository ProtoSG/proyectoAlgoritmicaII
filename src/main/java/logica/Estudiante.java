package logica;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Estudiante extends Persona implements Serializable{
    
    @OneToMany(mappedBy="estudiante")
    private List<TextoLeido> listaTextosLeidos;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="id_grupo")
    private Grupo grupo;
    
    public Estudiante() {
    }

    public Estudiante(List<TextoLeido> listaTextosLeidos, Usuario usuario, Grupo grupo, int id, String nombre, String apellido, Date fechaNacimiento) {
        super(id, nombre, apellido, fechaNacimiento);
        this.listaTextosLeidos = new List() {
            @Override
            public int size() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Iterator iterator() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Object[] toArray(Object[] a) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean add(Object e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean containsAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean addAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean addAll(int index, Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean removeAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean retainAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Object get(int index) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Object set(int index, Object element) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void add(int index, Object element) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Object remove(int index) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public int indexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public int lastIndexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public ListIterator listIterator() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public ListIterator listIterator(int index) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        this.usuario = usuario;
        this.grupo = grupo;
    }
    
    
    public void agregarTextoLeido(TextoLeido textoLeido){
        listaTextosLeidos.add(textoLeido);
    }
    
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<TextoLeido> getListaTextosLeidos() {
        return listaTextosLeidos;
    }

    public void setListaTextosLeidos(List<TextoLeido> listaTextosLeidos) {
        this.listaTextosLeidos = listaTextosLeidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public int cantidadTextosLeidos(){
        return listaTextosLeidos.size();
    }
    
    public double preguntasCorrectasTotal() {
        int preguntasTotales = 0;
        int respuestasCorrectas = 0;

        for (TextoLeido textoLeido : listaTextosLeidos) {
            preguntasTotales += textoLeido.getTexto().getListaPreguntas().size();
            respuestasCorrectas += textoLeido.getRespuestasCorrectas();
        }
    
        double porcentajeCorrectas = 0.0;

        if (preguntasTotales != 0) {
            porcentajeCorrectas = ((double) respuestasCorrectas / preguntasTotales) * 100;
        }
    
        DecimalFormat df = new DecimalFormat("#.##");
        double resultadoFormateado = Double.parseDouble(df.format(porcentajeCorrectas));

        return resultadoFormateado;
    }
    
    public double promedioPreguntasCorrectasTexto(){
        int preguntasTotales = 0;
        int respuestasCorrectas = 0;
        double porcentajeTexto = 0.0;

        for (TextoLeido textoLeido : listaTextosLeidos) {
            preguntasTotales = textoLeido.getTexto().getListaPreguntas().size();
            respuestasCorrectas = textoLeido.getRespuestasCorrectas();
            porcentajeTexto += ((double) respuestasCorrectas/preguntasTotales) * 100;
        }
        
        double porcentajePromedio = ((Double) porcentajeTexto/listaTextosLeidos.size());
        
        DecimalFormat df = new DecimalFormat("#.##");
        double resultadoFormateado = Double.parseDouble(df.format(porcentajePromedio));
        
        return resultadoFormateado;
    }
    
    public double textosFalloTodo(){
        int respuestasCorrectas = 0;
        int textosFaliidos = 0;
        for (TextoLeido textoLeido : listaTextosLeidos) {
            respuestasCorrectas = textoLeido.getRespuestasCorrectas();
            if(respuestasCorrectas == 0){
                textosFaliidos++;
            }
        }
        
        double porcentajeTextosFallidos = 0.0;
                
        if(textosFaliidos != 0){
            porcentajeTextosFallidos = ((double)textosFaliidos/listaTextosLeidos.size()) * 100;
        }
        
        DecimalFormat df = new DecimalFormat("#.##");
        double resultadoFormateado = Double.parseDouble(df.format(porcentajeTextosFallidos));
        
        return resultadoFormateado;
    }
    
    public double textoAcertoTodo(){
        int preguntasTotales = 0;
        int respuestasCorrectas = 0;
        int textosAcertados = 0;
        for (TextoLeido textoLeido : listaTextosLeidos) {
            preguntasTotales += textoLeido.getTexto().getListaPreguntas().size();
            respuestasCorrectas += textoLeido.getRespuestasCorrectas();
            if(respuestasCorrectas == preguntasTotales){
                textosAcertados++;
            }
        }
        
        double porcentajeTextosAcertados = 0.0;
                
        if(textosAcertados != 0){
            porcentajeTextosAcertados = ((double)textosAcertados/listaTextosLeidos.size()) * 100;
        }
        
         DecimalFormat df = new DecimalFormat("#.##");
        double resultadoFormateado = Double.parseDouble(df.format(porcentajeTextosAcertados));
        
        return resultadoFormateado;
    }
}
