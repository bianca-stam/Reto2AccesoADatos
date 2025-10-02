package Ejercicios2;

import java.net.URL;
import java.util.ArrayList;



/**
 * @descrition
 * @author Laura
 * @date 7/4/2015
 * @version 1.0
 * @license GPLv3
 */

public class Empresa5{


	private int idEmpresa;
	private String nombreEmpresa;
	private String direccion;
	private int numEmpleados;
	private ArrayList<Empleado> empleados;
	private URL urle;
	private boolean esPYME;
	private Producto producto;
	
	

	public Empresa5() {
		super();
		empleados=new ArrayList<Empleado>();
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


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "Empresa5 [idEmpresa=" + idEmpresa + ", nombreEmpresa="
				+ nombreEmpresa + ", direccion=" + direccion
				+ ", numEmpleados=" + numEmpleados + ", empleados=" + empleados.toString()
				+ ", urle=" + urle + ", esPYME=" + esPYME + ", producto="
				+ producto + "]";
	}


	

	
	
	
}
