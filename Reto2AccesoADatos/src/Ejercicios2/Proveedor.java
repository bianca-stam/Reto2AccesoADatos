package Ejercicios2;

import java.util.ArrayList;
import java.util.List;

/**
 *  @descrition
 *	@author Laura
 *  @date 27/4/2015
 *  @version 1.0
 *  @license GPLv3
 */

public class Proveedor {
	private int identificador;
	private String nombre;
	private String calle;
	private String ciudad;
	private String pais;
	private int cp;
	private boolean esNacional;
	private List<Cafe> cafes;
	
		
	public Proveedor() {
		super();
		cafes=new ArrayList<Cafe>();
	}	
	public void addCafe(Cafe cafe){
		cafes.add(cafe);		
	}
	public boolean isEsNacional() {
		return esNacional;
	}
	public void setEsNacional(boolean esNacional) {
		this.esNacional = esNacional;
	}
	public List<Cafe> getCafes() {
		return cafes;
	}
	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	@Override
	public String toString() {
		return "Proveedor [identificador=" + identificador + ", nombre="
				+ nombre + ", calle=" + calle + ", ciudad=" + ciudad
				+ ", pais=" + pais + ", cp=" + cp + ", esNacional="
				+ esNacional + ", cafes=" + cafes.toString() + "]";
	}
	
	
	

}


