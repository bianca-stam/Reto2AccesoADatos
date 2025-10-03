package Ejercicios2;

import com.thoughtworks.xstream.converters.SingleValueConverter;

/**
 *  @descrition Definici�n de convertidor para clase Telefono
 *	@author Laura
 *  @date 6/5/2015
 *  @version 1.0
 *  @license GPLv3
 */

public class DireccionConverter implements SingleValueConverter {

    //Indicamos al convertidor como convertir a String un objeto Direccion
	public String toString(Object obj) {
		    Direccion dir=(Direccion) obj;
			String aux=dir.getCalle() +"," +dir.getNumero();
            return aux;
    }

    //Indicamos al convertidor como obtener un objeto Producto a partir de un String
	public Object fromString(String representacion) {
		    String[] partes=representacion.split(",");
    	    Direccion dir=new Direccion(partes[0],Integer.parseInt(partes[1]));    	    
            return dir;
    }

    //Indicamos al convertidor que tipos puede convertir
    public boolean canConvert(Class type) {
            return type.equals(Direccion.class);
    }

}




