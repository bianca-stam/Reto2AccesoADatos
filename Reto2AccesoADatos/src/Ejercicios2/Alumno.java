/**
 *Alumno.java
 *@author Laura Lozano
 *@version 1.0
 */
package Ejercicios2;

// Clase que viene por defecto del .zip de ejercicios

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *  @descrition Clase que describe un Alumno para los ejercicios
 *	@author Laura
 *  @date 26/3/2015
 *  @version 1.0
 *  @license GPLv3
 */
public class Alumno {

	String nombre;
	String apellidos;
	Date anoNacimiento;
	Direccion direccion;

	/**
	 * Constructor con todos los par�metros
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param anoNacimiento
	 * @param calle
	 * @param numero
	 * 
	 * 
	 */
	
	public Alumno() {}
	public Alumno(String nombre, String apellidos, Date anoNacimiento,
			String calle, int numero) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = new Direccion(calle, numero);
		this.anoNacimiento = anoNacimiento;

	}

	/**
	 * Constructor copia
	 * 
	 * @param alumno
	 */
	public Alumno(Alumno alumno) {
		this.nombre = alumno.getNombre();
		this.apellidos = alumno.getApellidos();
		this.anoNacimiento = alumno.getAnoNacimiento();
		this.direccion = new Direccion(alumno.direccion);

	}

	

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 *
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 *
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	
	public String getNombre() {
		return nombre;
	}

	public Date getAnoNacimiento() {
		return anoNacimiento;
	}

	public void setAnoNacimiento(Date anoNacimiento) {
		this.anoNacimiento = anoNacimiento;
	}

	/**
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *
	 * @return
	 */
	public String toString() {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
                new Locale("es"));
		return "El alumno se llama:" + getNombre() + " " + getApellidos()
				+ "\tNaci� en el a�o:" + formatter.format(getAnoNacimiento())
				+ "\tVive en la calle:" + getDireccion().toString();

	}



	
}
