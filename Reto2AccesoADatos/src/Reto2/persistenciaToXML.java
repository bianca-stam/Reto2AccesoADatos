package Reto2;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class persistenciaToXML {
	public static void main(String[] args) {
		
		XStream xstream1 = new XStream(new DomDriver());
		xstream1.allowTypes(new Class[] { Libro.class, Biblioteca.class });
		
		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
        Libro libro3 = new Libro();
		
		libro1.setTitulo("Cien Años de Soledad");
		libro1.setAutor("Gabriel García Márquez");
		libro1.setAño(1967);
		libro1.setVentas(50000000);
		
		libro2.setTitulo("1984");
		libro2.setAutor("George Orwell");
		libro2.setAño(1949);
		libro2.setVentas(30000000);
		
		libro3.setTitulo("El Señor de los Anillos");
		libro3.setAutor("J.R.R. Tolkien");
		libro3.setAño(1954);
		libro3.setVentas(150000000);
		
		nombreBiblioteca nb = new nombreBiblioteca();
		nb.setName("Biblioteca Nacional");
		
		Biblioteca b1 = new Biblioteca(nb);
		b1.add(libro1);
		b1.add(libro2);
		b1.add(libro3); 
       
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("."));
		XmlArrayList lista = new XmlArrayList(strategy);
		
		lista.add(b1);
		
	}
}
