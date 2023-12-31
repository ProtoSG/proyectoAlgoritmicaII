package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import logica.Estudiante;
import logica.Grupo;
import logica.Profesor;
import logica.Texto;

public class ControladoraPersistencia {
    EstudianteJpaController estudianteJPA = new EstudianteJpaController();
    GrupoJpaController grupoJPA = new GrupoJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    PreguntaJpaController preguntaJPA = new PreguntaJpaController();
    ProfesorJpaController profesorJPA = new ProfesorJpaController();
    TextoJpaController textoJPA = new TextoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    TextoLeidoJpaController textoLeidoJPA = new TextoLeidoJpaController();
    
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
    
    public void crearTexto(Texto texto){
        System.out.println(texto);
        textoJPA.create(texto);
    }
    
    public List<Usuario> getUsuarios(){
        return usuarioJPA.findUsuarioEntities();
    }
    
    public Usuario getUsuario(int id){
        return usuarioJPA.findUsuario(id);
    }
    
    public List<Estudiante> getEstudiantes(){
        return estudianteJPA.findEstudianteEntities();
    }
    
    public List<Profesor> getProfesores(){
        return profesorJPA.findProfesorEntities();
    }
    
    public Profesor getProfesor(int idProfesor){
        return profesorJPA.findProfesor(idProfesor);
    }
    
    public List<Grupo> getGrupos(){
        return grupoJPA.findGrupoEntities();
    }
    
    public Grupo getGrupo(int grupoId){
        return grupoJPA.findGrupo(grupoId);
    }
    
    public List<Texto> getTextos(){
        return textoJPA.findTextoEntities();
    }
    
    public Texto getTexto(int id){
        return textoJPA.findTexto(id);
    }
    
    public void editarProfesor(Profesor profesor){
        try {
            profesorJPA.edit(profesor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarEstudiante(Estudiante estudiante){
        try {
            estudianteJPA.edit(estudiante);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
