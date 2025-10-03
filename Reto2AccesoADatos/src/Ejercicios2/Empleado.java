package Ejercicios2;

//Clase que viene por defecto del .zip de ejercicios

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *  @descrition
 *	@author Laura
 *  @date 7/4/2015
 *  @version 1.0
 *  @license GPLv3
 */


public class Empleado{
 
    private int id;
    private String nombre;
    private String titulo;
    private boolean activo=false;
    private Integer numeroEmpl;
    private Date fechaAlta;
 
    public int getId() {
        return id;
    }
 
    
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getTitulo() {
        return titulo;
    }
 
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public boolean isActivo() {
        return activo;
    }
 
   
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
    public Integer getNumeroEmpl() {
        return numeroEmpl;
    }
 
    
    public void setNumeroEmpl(Integer numeroEmpl) {
        this.numeroEmpl = numeroEmpl;
    }
 
    public Date getFechaAlta() {
        return fechaAlta;
    }
 
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


	@Override
	public String toString() {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
                new Locale("es"));
		return "Empleado [id=" + id + ", nombre=" + nombre + ", titulo="
				+ titulo + ", activo=" + activo + ", numeroEmpl=" + numeroEmpl
				+ ", fechaAlta=" + formatter.format(fechaAlta) + "]";
	}
    
    
 
}

