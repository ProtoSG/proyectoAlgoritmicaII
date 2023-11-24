package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Estudiante extends Persona{
    
    @OneToMany(mappedBy="estudiante")
    private List<Texto> listaTexto;
    @OneToOne
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="id_Estudiante")
    private Grupo grupo;
    
    public Estudiante() {
    }

    public Estudiante(List<Texto> listaTexto, Usuario usuario, String nombre, String apellido, Date fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        this.listaTexto = listaTexto;
        this.usuario = usuario;
    }

    public List<Texto> getListaTexto() {
        return listaTexto;
    }

    public void setListaTexto(List<Texto> listaTexto) {
        this.listaTexto = listaTexto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
