package Ejercicios2;

//Clase que viene por defecto del .zip de ejercicios

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @descrition
 * @author Laura
 * @date 6/5/2015
 * @version 1.0
 * @license GPLv3
 */

public class CafeConverter implements Converter{

	//Definimos la clase que puede convertir
	public boolean canConvert(Class clazz) {
		return clazz.equals(Cafe.class);
	}

	
	/**
	 * Definimos como convertir un objeto Cafe a XML
	 * @param value
	 * @param writer donde escribir los datos de salida
	 * @param context nos permite aplicar otros convertidores cuando el objeto tiene atributos que a su vez 
	 * requieren un convertidor personalizado ver ComplexConverter en http://xstream.codehaus.org/converter-tutorial.html
	 */
	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Cafe cafe = (Cafe) value;
		writer.addAttribute("marca", cafe.getNombre());
		//Podemos abrir y cerrar nodos tantas veces como haga falta,pero sin olvidar siempre cerrarlo
		writer.startNode("total");
		writer.setValue(Integer.toString(cafe.getTotal()));
		writer.startNode("ventas");
		writer.setValue(Integer.toString(cafe.getVentas()));
		writer.endNode();
		writer.startNode("precio");
		writer.setValue(Float.toString(cafe.getPrecio()));
		
		writer.endNode();
		writer.endNode();
		
	}

	
	/**
	 * Definimos como restaurar un objeto Cafe a partir de un XML
	 * @param reader donde leer los datos de entrada
	 * @param context nos permite aplicar otros convertidores cuando el objeto tiene atributos que a su vez 
	 * requieren un convertidor personalizado ver ComplexConverter en http://xstream.codehaus.org/converter-tutorial.html
	 * @return
	 */
	public Object unmarshal(HierarchicalStreamReader reader,UnmarshallingContext context) {
		Cafe cafe = new Cafe();
		//Nos podemos mover abajo y arriba en el �rbol de nodos seg�n necesitemos
		cafe.setNombre(reader.getAttribute("marca"));
		reader.moveDown();
		//System.out.println(reader.getValue().trim());
		//Es necesario quitar los espacios en blanco antes y despu�s del valor para que no de excepcion al convertir cadenas a numeros
		cafe.setTotal(Integer.parseInt(reader.getValue().trim()));
		reader.moveDown();
		//System.out.println(reader.getValue().trim());
		cafe.setVentas(Integer.parseInt(reader.getValue().trim()));
		reader.moveUp();
		reader.moveDown();
		//System.out.println(reader.getValue().trim());
		cafe.setPrecio(Float.parseFloat(reader.getValue().trim()));
		return cafe;
	}

}
