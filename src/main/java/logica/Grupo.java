package logica;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String codigoGrupo;
    private String nombreGrupo;
    private List<Estudiante> estudiantes;

    public Grupo(String codigoGrupo, String nombreGrupo) {
        this.codigoGrupo = codigoGrupo;
        this.nombreGrupo = nombreGrupo;
        this.estudiantes = new ArrayList<>();
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
       
    
}
