package Ejercicios2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PruebaEmpresa {
	public static void main(String[] args) {
		XStream xstream1 = new XStream(new DomDriver());
		
		// Le damos los permisos para las dos clases
		xstream1.allowTypes(new Class[] { Empresa.class , Empleado.class });
		
		Empleado e1 = new Empleado();
		
		e1.setId(12);
		e1.setNombre("Juan");
		e1.setTitulo("Analista");
		e1.setActivo(false);
		Date fecha1 = new Date("08/05/2015");
		e1.setFechaAlta(fecha1);
		
		
        Empleado e2 = new Empleado();
		
		e2.setId(14);
		e2.setNombre("Pedro");
		e2.setTitulo("Programador");
		e2.setActivo(true);
		e2.setFechaAlta(fecha1);
        
		
		
        Empresa emp1 = new Empresa();
        
        URL nuevaURL;
		try {
			nuevaURL = new URL("http://www.miempresa.es");
			emp1.setUrle(nuevaURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        emp1.setEsPYME(true);
        
        emp1.addEmpleado(e1);
        emp1.addEmpleado(e2);
        
        xstream1.alias("empleado", Empleado.class);
		xstream1.alias("empresa", Empresa.class);
        
        //Convertimos el objeto persona a xml invocando el método toXML
  		String xml=xstream1.toXML(emp1);
  		
  		System.out.println("Objeto convertido a XML mediante toXML: \n" + xml);		
  		
  		//Reconstruimos un objeto Proveedor a partir del XML generado invocando el método fromXML
  		Empresa empRecons=(Empresa)xstream1.fromXML(xml);
  		
  		System.out.println("\nObjeto reconstruido de XML mediante fromXML: \n" 
  							+ empRecons.toString());
       
	    }
}
