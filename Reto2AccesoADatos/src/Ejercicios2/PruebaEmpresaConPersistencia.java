package Ejercicios2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class PruebaEmpresaConPersistencia {
    public static void main(String[] args) {
        // --- CONFIGURACIÓN DE XSTREAM ---
        XStream xstream1 = new XStream(new DomDriver());
        xstream1.addPermission(AnyTypePermission.ANY); // permite cualquier clase
        xstream1.alias("empleado", Empleado.class);
        xstream1.alias("empresa", Empresa.class);

        xstream1.aliasField("cif", Empresa.class, "idEmpresa");
		xstream1.useAttributeFor(Empresa.class, "idEmpresa");
		
		
		xstream1.aliasField("nre", Empleado.class, "id");
		xstream1.useAttributeFor(Empleado.class, "id");
		
		xstream1.aliasField("cargo", Empleado.class, "titulo");
		xstream1.aliasField("alta", Empleado.class, "fechaAlta");
		
		xstream1.aliasField("web", Empleado.class, "urle");
		xstream1.aliasField("tipo", Empleado.class, "esPYME");
		
        
        // --- CREACIÓN DE EMPLEADOS ---
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

        // --- CREACIÓN DE LA EMPRESA ---
        Empresa emp1 = new Empresa();
        try {
            emp1.setUrle(new URL("http://www.miempresa.es"));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        emp1.setEsPYME(true);
        emp1.addEmpleado(e1);
        emp1.addEmpleado(e2);

        // --- PERSISTENCIA ---
        PersistenceStrategy strategy = new FilePersistenceStrategy(new File("."), xstream);
        XmlArrayList listaGuardar = new XmlArrayList(strategy);

        // Guardamos la empresa
        listaGuardar.add(emp1);

        // --- RECUPERACIÓN ---
        XmlArrayList listaRecuperar = new XmlArrayList(strategy);
        System.out.println("Recuperando objetos persistidos:");
        for (Object obj : listaRecuperar) {
            if (obj instanceof Empresa) {
                Empresa empRec = (Empresa) obj;
                System.out.println("Empresa recuperada: " + empRec);
                for (Empleado emp : empRec.getEmpleados()) {
                    System.out.println("Empleado: " + emp.getNombre() + ", Título: " + emp.getTitulo());
                }
            }
        }
    }
}
