package Ejercicios2;

//Ejercicio nr.8 del PDF "Ejercicios2"

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class TotalConvertidor implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return Cafe.class.equals(type);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Cafe cafe = (Cafe) source;

        // Atributo "marca" con el nombre (con null check)
        String nombre = cafe.getNombre();
        if (nombre == null) {
            nombre = "";
        }
        writer.addAttribute("marca", nombre);

        // Nodo <total>
        writer.startNode("total");

        // Nodo <ventas>
        writer.startNode("ventas");
        writer.setValue(String.valueOf(cafe.getVentas()));
        writer.endNode();

        // Nodo <precio>
        writer.startNode("precio");
        writer.setValue(String.valueOf(cafe.getPrecio()));
        writer.endNode();

        writer.endNode(); // cierra <total>
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Cafe cafe = new Cafe();

        // Obtener atributo "marca"
        cafe.setNombre(reader.getAttribute("marca"));

        // Movernos al nodo <total>
        reader.moveDown();

        while (reader.hasMoreChildren()) {
            reader.moveDown();

            String nodeName = reader.getNodeName();
            String value = reader.getValue();

            if ("ventas".equals(nodeName)) {
                cafe.setVentas(Integer.parseInt(value));
            } else if ("precio".equals(nodeName)) {
                cafe.setPrecio(Float.parseFloat(value));
            }

            reader.moveUp();
        }

        reader.moveUp(); // salir de <total>

        // Puedes dejar total como 0 o asignarle algún valor si quieres:
        cafe.setTotal(0);

        return cafe;
    }
}
