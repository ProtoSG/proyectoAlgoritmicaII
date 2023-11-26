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
    
    
    public boolean comprobarIngreso(String userName, String contrasena){
        
        boolean ingreso = false;
        
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        listUsuario = controlPersis.getUsuarios();
        
        for(Usuario usu:listUsuario){
            if(usu.getNombreUsuario().equals(userName)){
                if(usu.getContrasena().equals(contrasena))
                    ingreso = true;
                else
                    ingreso = false;
            }
        }
        return ingreso;
    }
}
