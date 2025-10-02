package Ejercicios2;

/**
 *  @descrition Clase simple para un producto
 *	@author Laura
 *  @date 6/5/2015
 *  @version 1.0
 *  @license GPLv3
 */

public class Producto {
	private int id;
	private String nombre;
	private float precio;
	
	
	public Producto(int id, String nombre, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio="
				+ precio + "]";
	}
	


}


