package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Profesor extends Persona{

    private String carreraProfesional;
    @OneToMany(mappedBy="profesor")
    private List<Grupo> listaGrupos;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;

    public Profesor() {
    }

    public Profesor(String carreraProfesional, List<Grupo> listaGrupos, Usuario usuario, int id, String nombre, String apellido, Date fechaNacimiento) {
        super(id, nombre, apellido, fechaNacimiento);
        this.carreraProfesional = carreraProfesional;
        this.listaGrupos = listaGrupos;
        this.usuario = usuario;
    }

    

    public String getCarreraProfesional() {
        return carreraProfesional;
    }

    public void setCarreraProfesional(String carreraProfesional) {
        this.carreraProfesional = carreraProfesional;
    }

    public List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(List<Grupo> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
