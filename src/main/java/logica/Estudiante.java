package logica;

import java.util.Date;
import java.util.List;

public class Estudiante extends Persona{
    private int idEstudiante;
    private List<Texto> listaTexto;
    private Usuario usuario;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, List<Texto> listaTexto, Usuario usuario, String nombre, String apellido, Date fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        this.idEstudiante = idEstudiante;
        this.listaTexto = listaTexto;
        this.usuario = usuario;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
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
