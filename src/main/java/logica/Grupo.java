package logica;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Grupo implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idGrupo;
    private String codigoGrupo;
    private String nombreGrupo;
    @OneToMany(mappedBy="grupo")
    private List<Estudiante> listaEstudiantes;
    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor profesor;

    public Grupo() {
    }

    public Grupo(int idGrupo, String codigoGrupo, String nombreGrupo, List<Estudiante> listaEstudiantes) {
        this.idGrupo = idGrupo;
        this.codigoGrupo = codigoGrupo;
        this.nombreGrupo = nombreGrupo;
        this.listaEstudiantes = listaEstudiantes;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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
    
    public int cantidadTextosResueltos(){
        int cont = 0;
        for(Estudiante estudiante:listaEstudiantes){
            cont += estudiante.getListaTextosLeidos().size();
        }
        return cont;
    }
    
    public double preguntasCorrectasAlumno(){
        double porcentajeTotal = 0.0;
        double promedio = 0.0;
        for(Estudiante estudiante: listaEstudiantes){
            porcentajeTotal += estudiante.preguntasCorrectasTotal();
        }
        if(porcentajeTotal!=0){
        promedio = ((double)porcentajeTotal / listaEstudiantes.size());
        }
        return promedio;
    }
    
    
    public double preguntasCorrectasTextoAlmuno(){
        double porcentajeTotal = 0.0;
        double promedio = 0.0;
        for(Estudiante estudiante: listaEstudiantes){
            porcentajeTotal += estudiante.promedioPreguntasCorrectasTexto();
        }
        
        if(porcentajeTotal!=0){
        promedio = ((double)porcentajeTotal / listaEstudiantes.size());
        }
        return promedio;
    }

    public int textoMasLeidos() {
        if (listaEstudiantes.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> conteoTextos = new HashMap<>();

        for (Estudiante estudiante : listaEstudiantes) {
            List<TextoLeido> textosLeidos = estudiante.getListaTextosLeidos();

            for (TextoLeido textoLeido : textosLeidos) {
                int idTexto = textoLeido.getTexto().getIdTexto();
                conteoTextos.put(idTexto, conteoTextos.getOrDefault(idTexto, 0) + 1);
            }
        }

        int maxVecesLeido = 0;
        int idTextoMasLeido = 0;

        for (Map.Entry<Integer, Integer> entry : conteoTextos.entrySet()) {
            int idTexto = entry.getKey();
            int vecesLeido = entry.getValue();

            if (vecesLeido > maxVecesLeido) {
                maxVecesLeido = vecesLeido;
                idTextoMasLeido = idTexto;
            }
        }

        return idTextoMasLeido;
    }
    
    public int textoMasResolver(boolean encontrarFacil) {
        if (listaEstudiantes.isEmpty()) {
            return 0;
        }

        double extremoPorcentaje = encontrarFacil ? 0.0 : 100.0;
        int idTextoExtremo = 0;

        for (Estudiante estudiante : listaEstudiantes) {
            List<TextoLeido> textosLeidos = estudiante.getListaTextosLeidos();

            for (TextoLeido textoLeido : textosLeidos) {
                int idTexto = textoLeido.getTexto().getIdTexto();
                int preguntasTotales = textoLeido.getTexto().getListaPreguntas().size();
                int respuestasCorrectas = textoLeido.getRespuestasCorrectas();

                if (preguntasTotales > 0) {
                    double porcentajeTexto = ((double) respuestasCorrectas / preguntasTotales) * 100;

                    if ((encontrarFacil && porcentajeTexto > extremoPorcentaje) ||
                        (!encontrarFacil && porcentajeTexto < extremoPorcentaje)) {
                        extremoPorcentaje = porcentajeTexto;
                        idTextoExtremo = idTexto;
                    }
                }
            }
        }

        return idTextoExtremo;
    }

    public int textoMasFacilesResolver() {
        return textoMasResolver(true);
    }

    public int textoMasDificilesResolver() {
        return textoMasResolver(false);
    }
    
    
}
