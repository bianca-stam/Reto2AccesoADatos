package Reto2;

import java.io.File;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class recuperaLibro {
	public static void main(String[] args) {
		
		XStream xstream1 = new XStream(new DomDriver());
		xstream1.allowTypes(new Class[] { Libro.class, Biblioteca.class });
		
		File arhivoALeer = new File("libros.xml");
		
		try (FileReader fr = new FileReader(arhivoALeer)){
			Biblioteca biblioRecons = (Biblioteca)xstream1.fromXML(fr);
			
			for (Libro libro : biblioRecons.getContent()) {
				System.out.println("Título: " + libro.getTitulo() + 
								"\nAutor: " + libro.getAutor() +
								"\nAño: " + libro.getAño() +
								"\nVentas: " + libro.getVentas());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
