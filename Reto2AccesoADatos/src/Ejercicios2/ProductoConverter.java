package Ejercicios2;

import com.thoughtworks.xstream.converters.SingleValueConverter;

/**
 *  @descrition Definici�n de convertidor para clase Telefono
 *	@author Laura
 *  @date 6/5/2015
 *  @version 1.0
 *  @license GPLv3
 */

public class ProductoConverter implements SingleValueConverter {

    //Indicamos al convertidor como convertir a String un objeto Producto
	public String toString(Object obj) {
		    Producto prod=(Producto) obj;
			String aux=prod.getId() +":" +prod.getNombre()+":" + prod.getPrecio();
            return aux;
    }

    //Indicamos al convertidor como obtener un objeto Producto a partir de un String
	public Object fromString(String representacion) {
		    String[] partes=representacion.split(":");
    	    Producto prod=new Producto(new Integer(partes[0]),partes[1],new Float(partes[2]));    	    
            return prod;
    }

    //Indicamos al convertidor que tipos puede convertir
    public boolean canConvert(Class type) {
            return type.equals(Producto.class);
    }

}




