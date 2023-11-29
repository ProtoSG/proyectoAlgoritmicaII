package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario( String nombreUsuario, String contrasena, String rol){
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasena(contrasena);
        usu.setRol(rol);
        controlPersis.crearUsuario(usu);
    }
    
    public void crearEstudiante(Usuario usuario, String nombre, String apellido, Date fechaNacimiento){
        Estudiante estudiante = new Estudiante();
        estudiante.setUsuario(usuario);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setFechaNacimiento(fechaNacimiento);
        controlPersis.crearEstudiante(estudiante);
    }
    
    public void crearProfesor(Usuario usuario, String nombre, String apellido, Date fechaNacimiento, String carreraProfesional){
        Profesor profesor = new Profesor();
        profesor.setUsuario(usuario);
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setFechaNacimiento(fechaNacimiento);
        profesor.setCarreraProfesional(carreraProfesional);
        controlPersis.crearProfesor(profesor);
    }
    
    public void crearGrupo(String name, String codigo, HttpSession misession ){
        Grupo grupo = new Grupo();
        grupo.setNombreGrupo(name);
        grupo.setCodigoGrupo(codigo);
        
        Profesor profesor = (Profesor) misession.getAttribute("profesor");
        profesor.agregarGrupo(grupo);
        
        grupo.setProfesor(profesor);
        
        controlPersis.editarProfesor(profesor);
    }
    
    public void crearTexto(String texto, List<Pregunta> preguntas){
        Texto newTexto = new Texto();
        newTexto.setTexto(texto);
        newTexto.setListaPreguntas(preguntas);
        
        for(Pregunta pregunta:preguntas){
            pregunta.setTexto(newTexto);
        }
        
        System.out.println(texto);
        
        controlPersis.crearTexto(newTexto);
    }
    
    public boolean comprobarIngreso(String userName, String contrasena){        
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        listUsuario = controlPersis.getUsuarios();
        
        boolean ingreso = false;
        
        for(Usuario usu:listUsuario){
            if(usu.getNombreUsuario().equals(userName)){
                if(usu.getContrasena().equals(contrasena)){
                    ingreso = true;
                }
            }
        }
        return ingreso;
    }
    
    public boolean comprobarUsuario(String userName){
        
        boolean ingreso = false;
        
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        listUsuario = controlPersis.getUsuarios();
        
        for(Usuario usu:listUsuario){
            if(usu.getNombreUsuario().equals(userName)){

                    ingreso = true;
            }else
                    ingreso = false;
        }
        return ingreso;
    }
    
    public Usuario getUsuario(String userName){
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        listUsuario = controlPersis.getUsuarios();
        
        for(Usuario usu:listUsuario){
            if(usu.getNombreUsuario().equals(userName)){
                    return usu;
            }
        }
        return null;
    }
    
    public Estudiante getEstudiante(int idUsuario) {
        List<Estudiante> listEstudiante = controlPersis.getEstudiantes();

        for (Estudiante estudiante : listEstudiante) {
            Usuario usuario = estudiante.getUsuario();
            if(usuario != null && usuario.getIdUsuario() == idUsuario) {
                return estudiante;
            }
        }
        return null;
    }
    
    public Profesor getProfesor(int idUsuario) {
        List<Profesor> listProfesore = controlPersis.getProfesores();

        for (Profesor profesor : listProfesore) {
            Usuario usuario = profesor.getUsuario();
            if(usuario != null && usuario.getIdUsuario() == idUsuario) {
                return profesor;
            }
        }
        return null;
    }
    
    public List<Grupo> getGrupos(){
        return controlPersis.getGrupos();
    }
    
    public Grupo getGrupo(int grupoId){
        return controlPersis.getGrupo(grupoId);
    }
    
    public List<Texto> getTextos(){
        return controlPersis.getTextos();
    }
    
    public Texto getTexto(int id){
        return controlPersis.getTexto(id);
    }
    
    public void actualizarEstudiante(Estudiante estudiante){
        controlPersis.actualizarEstudiante(estudiante);
    }
}
