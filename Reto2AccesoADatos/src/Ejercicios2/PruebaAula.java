package Ejercicios2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PruebaAula {
	public static void main(String[] args) {
		XStream xstream1 = new XStream(new DomDriver());
		
		// Le damos los permisos para las dos clases
		xstream1.allowTypes(new Class[] { Alumno.class , Aula.class });
		
		// Direccion dir1 = new Direccion("calle alcala", 126); No sirve de nada
		
		Date date1 = new Date("08/05/2015");
		
		Alumno al1 = new Alumno("juan", "garcía", date1, "calle alcala", 126);
		Alumno al2 = new Alumno("pepe", "lopez", date1, "calle zamora", 13);
		
		//List<Alumno> listaAlumnos = new ArrayList<>();
		//listaAlumnos.add(al1);
		//listaAlumnos.add(al2);
		
		Aula aula1 = new Aula(2);
		aula1.add(al1);
		aula1.add(al2);
		//aula1.setAlumnos(listaAlumnos);
		aula1.setFechaCreacion(date1);
		
		xstream1.alias("aula", Aula.class); 
		xstream1.alias("alumno", Alumno.class);
		xstream1.alias("alumno", Alumno.class);
		
		xstream1.aliasField("aniversario", Alumno.class, "anoNacimiento");
		
		xstream1.aliasField("fecha", Aula.class, "fechaCreacion");
		//xstream1.useAttributeFor(Proveedor.class, "identificador");
		
		// Hacemos que los elementos de la lista se serialicen directamente
		// como hijos del nodo padre, sin el contenedor extra de <alumnos>
		xstream1.addImplicitCollection(Aula.class, "alumnos"); 
		
		String xml=xstream1.toXML(aula1);
  		
  		System.out.println("Objeto convertido a XML mediante toXML: \n" + xml);		
  		
  		//Reconstruimos un objeto Proveedor a partir del XML generado invocando el método fromXML
  		Aula aulaRecons = (Aula)xstream1.fromXML(xml);
  		
  		System.out.println("\nObjeto reconstruido de XML mediante fromXML: \n" 
  							+ aulaRecons.toString());		
	}
}
