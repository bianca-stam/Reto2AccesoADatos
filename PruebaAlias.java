package Reto2;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;

import com.thoughtworks.xstream.io.xml.DomDriver;

public class PruebaAlias {
	public static void main(String[] args) {
		Biblioteca BNE = new Biblioteca(
				new nombreBiblioteca("Biblioteca Nacional de España"));
		
		BNE.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, 50000000));
		
		XStream xstream1 = new XStream(new DomDriver());
		
		System.out.println("Antes: \n" + xstream1.toXML(BNE));
		
		xstream1.alias("biblioteca", Biblioteca.class);
		xstream1.alias("libro", Libro.class);
		
		//de nombreBiblio a nombreBiblioteca
		xstream1.aliasField("nombreBiblioteca", nombreBiblioteca.class, "nombreBiblio");
		
		System.out.println("\nDespués: \n" + xstream1.toXML(BNE));
		String xmlConAlias = xstream1.toXML(BNE);
		
		 File fichero = new File("librosConAlias.xml");
	        try (FileWriter fw = new FileWriter(fichero)){
				fw.write(xmlConAlias);
				
				System.out.println("XML guardado en fichero correctamente.");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
