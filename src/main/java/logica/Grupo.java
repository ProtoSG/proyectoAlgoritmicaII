package logica;

import java.util.List;

public class Grupo {
    private int idGrupo;
    private String codigoGrupo;
    private String nombreGrupo;
    private List<Estudiante> listaEstudiantes;

    public Grupo() {
    }

    public Grupo(int idGrupo, String codigoGrupo, String nombreGrupo, List<Estudiante> listaEstudiantes) {
        this.idGrupo = idGrupo;
        this.codigoGrupo = codigoGrupo;
        this.nombreGrupo = nombreGrupo;
        this.listaEstudiantes = listaEstudiantes;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
    
    
}
