package persistencia;

import java.util.List;
import logica.Usuario;
import logica.Estudiante;

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
    
    public List<Usuario> getUsuarios(){
        return usuarioJPA.findUsuarioEntities();
    }
}
