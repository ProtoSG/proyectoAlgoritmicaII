package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    public void crearGrupo(String name, String codigo){
        Grupo grupo = new Grupo();
        grupo.setNombreGrupo(name);
        grupo.setCodigoGrupo(codigo);
        controlPersis.crearGrupo(grupo);
    }
    
    public Usuario comprobarIngreso(String userName, String contrasena){
                
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        listUsuario = controlPersis.getUsuarios();
        
        for(Usuario usu:listUsuario){
            if(usu.getNombreUsuario().equals(userName)){
                if(usu.getContrasena().equals(contrasena)){
                    return usu;
                }
            }
        }
        return null;
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
    
    public List<Grupo> getGrupos(){
        return controlPersis.getGrupos();
    }
}
