package logica;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario{
    private String carreraProfesional;
    private List<Grupo> grupos;

    public Profesor(String carreraProfesional, String nombreUsuario, String contraseña, String nombres, String apellidos, String fechaNacimiento) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimiento);
        this.carreraProfesional = carreraProfesional;
        this.grupos = new ArrayList<>();
    }

    public String getCarreraProfesional() {
        return carreraProfesional;
    }

    public void setCarreraProfesional(String carreraProfesional) {
        this.carreraProfesional = carreraProfesional;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    
}
