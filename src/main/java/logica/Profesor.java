package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profesor extends Persona{
    private int idProfesor;
    private String carreraProfesional;
    private List<Grupo> listaGrupos;
    private Usuario usuario;

    public Profesor() {
    }

    public Profesor(int idProfesor, String carreraProfesional, List<Grupo> listaGrupos, Usuario usuario, String nombre, String apellido, Date fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        this.idProfesor = idProfesor;
        this.carreraProfesional = carreraProfesional;
        this.listaGrupos = listaGrupos;
        this.usuario = usuario;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
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
