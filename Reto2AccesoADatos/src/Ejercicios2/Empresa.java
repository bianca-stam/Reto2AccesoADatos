package Ejercicios2;

// Modificado para realizar el ejercicio 5

import java.net.URL;
import java.util.ArrayList;



/**
 * @descrition
 * @author Laura
 * @date 7/4/2015
 * @version 1.0
 * @license GPLv3
 */

public class Empresa{


	private int idEmpresa;
	private String nombreEmpresa;
	private String direccion;
	private int numEmpleados;
	private ArrayList<Empleado> empleados;
	private URL urle;
	private boolean esPYME;
	private Producto producto; // Añadido

	public Producto getProducto() { // Añadido
		return producto;
	}

	public void setProducto(Producto producto) { // Añadido
		this.producto = producto;
	}

	public Empresa() {
		super();
		empleados=new ArrayList<Empleado>();
	}

	// Añadimos un constructor vacío
	public Empresa(String string) {
	}


	public void addEmpleado(Empleado emp){
		empleados.add(emp);
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}

	
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	
	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}


	public URL getUrle() {
		return urle;
	}


	public void setUrle(URL urle) {
		this.urle = urle;
	}

	

	public boolean isEsPYME() {
		return esPYME;
	}


	public void setEsPYME(boolean esPYME) {
		this.esPYME = esPYME;
	}


	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nombreEmpresa="
				+ nombreEmpresa + ", direccion=" + direccion
				+ ", numEmpleados=" + numEmpleados + ", empleados=" + empleados.toString()
				+ ", urle=" + urle + ", esPYME=" + esPYME + "]";
	}


	
	
	
}
