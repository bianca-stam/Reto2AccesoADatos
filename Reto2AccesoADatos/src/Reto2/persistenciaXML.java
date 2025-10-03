package Reto2;

// Apartado 1 - Punto 3 (Persistencia a fichero)

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class persistenciaXML {
	public static void main(String[] args) {
		
		XStream xstream1 = new XStream(new DomDriver());
		xstream1.allowTypes(new Class[] { Libro.class, Biblioteca.class, nombreBiblioteca.class });
		xstream1.addPermission(AnyTypePermission.ANY);
		
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
       
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("."), xstream1);
		XmlArrayList lista = new XmlArrayList(strategy);
		
		// Guardar la biblioteca
		lista.add(b1);
		
        System.out.println("Biblioteca guardada en persistencia.");
        
        // --- Recuperación de la biblioteca ---
        XmlArrayList listaRecuperar = new XmlArrayList(strategy);
        System.out.println("Recuperando objetos persistidos:");
        
        for (Object obj : listaRecuperar) {
            if (obj instanceof Biblioteca) {
                Biblioteca bRecuperada = (Biblioteca) obj;
                
                // Imprimir nombre de la biblioteca
                System.out.println("Biblioteca recuperada: " + bRecuperada.getNombreBiblio().getName());
                
                // Imprimir libros
                System.out.println("Libros:");
                bRecuperada.getContent().forEach(libro -> 
                    System.out.println("- " + libro.getTitulo() + " de " + libro.getAutor() +
                                       " (" + libro.getAño() + "), ventas: " + libro.getVentas())
                );
            }
        }
		
	}
}
