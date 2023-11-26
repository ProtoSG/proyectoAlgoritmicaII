package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Estudiante extends Persona implements Serializable{
    
    @OneToMany(mappedBy="estudiante")
    private List<Texto> listaTexto;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="id_grupo")
    private Grupo grupo;
    
    public Estudiante() {
    }

    public Estudiante(List<Texto> listaTexto, Usuario usuario, Grupo grupo, int id, String nombre, String apellido, Date fechaNacimiento) {
        super(id, nombre, apellido, fechaNacimiento);
        this.listaTexto = listaTexto;
        this.usuario = usuario;
        this.grupo = grupo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
