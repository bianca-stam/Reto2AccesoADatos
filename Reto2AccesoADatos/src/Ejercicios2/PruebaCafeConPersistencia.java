package Ejercicios2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PruebaCafeConPersistencia {
	public static void main(String[] args) {
		XStream xstream1 = new XStream(new DomDriver());
		
		xstream1.allowTypes(new Class[] { Cafe.class , Proveedor.class });
		
		//Construimos el objeto  a convertir despu�s en XML
		Cafe cafe1 = new Cafe();
		cafe1.setNombre("CafeIESCE");
		cafe1.setPrecio((float)5.3);
		cafe1.setVentas(43);	
		
		Cafe cafe2 = new Cafe();
		cafe1.setNombre("CafeIESSanFer");
		cafe1.setPrecio((float)6.8);
		cafe1.setVentas(43);	
		
		Proveedor proveedor1 = new Proveedor();
		proveedor1.setIdentificador(150);
		proveedor1.setNombre("Mi Proveedor");
		proveedor1.setCalle("mi calle");
		proveedor1.setCiudad("madrid");
		proveedor1.setPais("españa");
		proveedor1.setCp(28050);
		proveedor1.setEsNacional(false);
		
		proveedor1.addCafe(cafe1);
		proveedor1.addCafe(cafe2);
		
		// Le ponemos alias
		xstream1.alias("cafe", Cafe.class); // Aparece 'cafe' en vez de 'Ejercicios2.Cafe'
		xstream1.alias("proveedor", Proveedor.class); // Aparece 'proveedor' en vez de 'Ejercicios2.Proveedor'		
		xstream1.aliasField("cif", Proveedor.class, "identificador");
		xstream1.useAttributeFor(Proveedor.class, "identificador");
		xstream1.aliasField("empresa", Proveedor.class, "nombre");
		xstream1.useAttributeFor(Proveedor.class, "nombre");
		
		xstream1.aliasField("marca", Cafe.class, "nombre");
		
		 try (FileOutputStream fos = new FileOutputStream("proveedor.xml")) {
             xstream1.toXML(proveedor1, fos);
             System.out.println("Objeto Proveedor guardado en proveedor.xml");
             
         } catch (Exception e) {
        	 e.printStackTrace();
         }
		 
		 Proveedor proveedorRecons;
         try (FileInputStream fis = new FileInputStream("proveedor.xml")) {
             proveedorRecons = (Proveedor) xstream1.fromXML(fis);
             System.out.println("Objeto Proveedor restaurado desde archivo:");
             System.out.println(proveedorRecons);
             
         } catch (Exception e) {
        	 e.printStackTrace();
         }
		 
	}
}
