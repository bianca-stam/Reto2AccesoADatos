package Ejercicios2;

/**
 * @descrition
 * @author Laura
 * @date 5/5/2015
 * @version 1.0
 * @license GPLv3
 */

public class Direccion {

	String calle;
	int numero;
	
	public Direccion() {}

	public Direccion(String calle, int numero) {
		this.calle = calle;
		this.numero = numero;
	}

	public Direccion(Direccion direccion) {
		this.calle = direccion.getCalle();
		this.numero = direccion.getNumero();
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + "]";
	}
	
}
