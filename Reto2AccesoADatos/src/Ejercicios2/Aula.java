/**
 *Aula.java
 *@author Laura Lozano
 *@version 1.0
 */

package Ejercicios2;

//Clase que viene por defecto del .zip de ejercicios

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *  @descrition Clase que describe un Aula de Alumnos para los ejercicios
 *	@author Laura
 *  @date 26/3/2015
 *  @version 1.0
 *  @license GPLv3
 */
public class Aula {
    private List<Alumno> alumnos;
    private Date fechaCreacion;
    
    public Aula(){  }

    /**
     * Constructor del Almac�n con un determinado tamano
     * @param tamano
     */
    public Aula(int tamano){
        alumnos=new ArrayList<Alumno>(tamano);
    }
   
    /**
     * Anade un nuevo elemento al almac�n si hay sitio
     * @param valor a anadir al almac�n
     */
    public void add(Alumno alumno){        
            alumnos.add(alumno);            
    }
    /**
     * Elimina un elemento del almac�n si est� en el almacen
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno alumno){
    	return alumnos.remove(alumno);
        
    }
         
    public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
                new Locale("es"));
		return "Aula [alumnos=" + alumnos.toString() + ", fechaCreacion=" + formatter.format(fechaCreacion)
				+ "]";
	}

	
}
