package persistencia;

import java.util.List;
import logica.Usuario;
import logica.Estudiante;
import logica.Grupo;
import logica.Profesor;

public class ControladoraPersistencia {
    EstudianteJpaController estudianteJPA = new EstudianteJpaController();
    GrupoJpaController grupoJPA = new GrupoJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    PreguntaJpaController preguntaJPA = new PreguntaJpaController();
    ProfesorJpaController profesorJPA = new ProfesorJpaController();
    TextoJpaController textoJPA = new TextoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    
    public void crearUsuario(Usuario usu){
        usuarioJPA.create(usu);
    }
    
    public void crearEstudiante(Estudiante estudiante){
       estudianteJPA.create(estudiante);
    }
    
    public void crearProfesor(Profesor profesor){
        profesorJPA.create(profesor);
    }
    
    public void crearGrupo(Grupo grupo){
        grupoJPA.create(grupo);
    }
    
    public List<Usuario> getUsuarios(){
        return usuarioJPA.findUsuarioEntities();
    }
    
    public List<Estudiante> getEstudiantes(){
        return estudianteJPA.findEstudianteEntities();
    }
    
    public List<Grupo> getGrupos(){
        return grupoJPA.findGrupoEntities();
    }
}
