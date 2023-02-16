
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {

    public static void main(String [] args) {
        try {
            Conexion con = new Conexion();
            Statement st = con.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * from socios ORDER BY id DESC LIMIT 5;");
            ArrayList<Socios> socios = new ArrayList<>();

            while (rs.next()){
                socios.add(new Socios(rs.getInt("id"),rs.getString("dni"), rs.getString("nombre"), rs.getString("primerApellido"), rs.getString("segundoApellido"), rs.getString("correo"), rs.getString("fechaNacimiento"), rs.getString("telefono")));
            }


            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("socios");
            doc.appendChild(rootElement);



            //Primer Socio
            Element socio1 = doc.createElement("socio");
            rootElement.appendChild(socio1);

            Attr attr = doc.createAttribute("id");
            socio1.setAttributeNode(attr);
            attr.setValue(String.valueOf(socios.get(0).getId()));

            Element elementoNombre1 = doc.createElement("Nombre");
            elementoNombre1.setTextContent(socios.get(0).getNombre());
            socio1.appendChild(elementoNombre1);

            Element elementoPrimAp1 = doc.createElement("primerApellido");
            elementoPrimAp1.setTextContent(socios.get(0).getPrimerApellido());
            socio1.appendChild(elementoPrimAp1);

            Element elementoSegAp1 = doc.createElement("segundoApellido");
            elementoSegAp1.setTextContent(socios.get(0).getSegundoApellido());
            socio1.appendChild(elementoSegAp1);

            Element elementoCorreo = doc.createElement("correo");
            elementoCorreo.setTextContent(socios.get(0).getCorreo());
            socio1.appendChild(elementoCorreo);

            Element elementoTelf = doc.createElement("telefono");
            elementoTelf.setTextContent(socios.get(0).getTelefono());
            socio1.appendChild(elementoTelf);

            Element elementoFecha = doc.createElement("fechaNacimiento");
            elementoFecha.setTextContent(socios.get(0).getFechaNacimiento());
            socio1.appendChild(elementoFecha);


            //Segundo Socio
            Element socio2 = doc.createElement("socio");
            rootElement.appendChild(socio2);

            Attr attr1 = doc.createAttribute("id");
            socio2.setAttributeNode(attr1);
            attr1.setValue(String.valueOf(socios.get(1).getId()));

            Element elementoNombre2 = doc.createElement("Nombre");
            elementoNombre2.setTextContent(socios.get(1).getNombre());
            socio2.appendChild(elementoNombre2);

            Element elementoPrimAp2 = doc.createElement("primerApellido");
            elementoPrimAp2.setTextContent(socios.get(1).getPrimerApellido());
            socio2.appendChild(elementoPrimAp2);

            Element elementoSegAp2 = doc.createElement("segundoApellido");
            elementoSegAp2.setTextContent(socios.get(1).getSegundoApellido());
            socio2.appendChild(elementoSegAp2);

            Element elementoCorreo2 = doc.createElement("correo");
            elementoCorreo2.setTextContent(socios.get(1).getCorreo());
            socio2.appendChild(elementoCorreo2);

            Element elementoTelf2 = doc.createElement("telefono");
            elementoTelf2.setTextContent(socios.get(1).getTelefono());
            socio2.appendChild(elementoTelf2);

            Element elementoFecha2 = doc.createElement("fechaNacimiento");
            elementoFecha2.setTextContent(socios.get(1).getFechaNacimiento());
            socio2.appendChild(elementoFecha2);


            //Tercer Socio
            Element socio3 = doc.createElement("socio");
            rootElement.appendChild(socio3);

            Attr attr2 = doc.createAttribute("id");
            socio3.setAttributeNode(attr2);
            attr2.setValue(String.valueOf(socios.get(2).getId()));

            Element elementoNombre3 = doc.createElement("Nombre");
            elementoNombre3.setTextContent(socios.get(2).getNombre());
            socio3.appendChild(elementoNombre3);

            Element elementoPrimAp3 = doc.createElement("primerApellido");
            elementoPrimAp3.setTextContent(socios.get(2).getPrimerApellido());
            socio3.appendChild(elementoPrimAp3);

            Element elementoSegAp3 = doc.createElement("segundoApellido");
            elementoSegAp3.setTextContent(socios.get(2).getSegundoApellido());
            socio3.appendChild(elementoSegAp3);

            Element elementoCorreo3 = doc.createElement("correo");
            elementoCorreo3.setTextContent(socios.get(2).getCorreo());
            socio3.appendChild(elementoCorreo3);

            Element elementoTelf3 = doc.createElement("telefono");
            elementoTelf3.setTextContent(socios.get(2).getTelefono());
            socio3.appendChild(elementoTelf3);

            Element elementoFecha3 = doc.createElement("fechaNacimiento");
            elementoFecha3.setTextContent(socios.get(2).getFechaNacimiento());
            socio3.appendChild(elementoFecha3);


            //Cuarto Socio
            Element socio4 = doc.createElement("socio");
            rootElement.appendChild(socio4);

            Attr attr3 = doc.createAttribute("id");
            socio4.setAttributeNode(attr3);
            attr3.setValue(String.valueOf(socios.get(3).getId()));

            Element elementoNombre4 = doc.createElement("Nombre");
            elementoNombre4.setTextContent(socios.get(3).getNombre());
            socio4.appendChild(elementoNombre4);

            Element elementoPrimAp4 = doc.createElement("primerApellido");
            elementoPrimAp4.setTextContent(socios.get(3).getPrimerApellido());
            socio4.appendChild(elementoPrimAp4);

            Element elementoSegAp4 = doc.createElement("segundoApellido");
            elementoSegAp4.setTextContent(socios.get(3).getSegundoApellido());
            socio4.appendChild(elementoSegAp4);

            Element elementoCorreo4 = doc.createElement("correo");
            elementoCorreo4.setTextContent(socios.get(3).getCorreo());
            socio4.appendChild(elementoCorreo4);

            Element elementoTelf4 = doc.createElement("telefono");
            elementoTelf4.setTextContent(socios.get(3).getTelefono());
            socio4.appendChild(elementoTelf4);

            Element elementoFecha4 = doc.createElement("fechaNacimiento");
            elementoFecha4.setTextContent(socios.get(3).getFechaNacimiento());
            socio4.appendChild(elementoFecha4);


            //Quinto Socio
            Element socio5 = doc.createElement("socio");
            rootElement.appendChild(socio5);

            Attr attr4 = doc.createAttribute("id");
            socio5.setAttributeNode(attr4);
            attr4.setValue(String.valueOf(socios.get(4).getId()));

            Element elementoNombre5 = doc.createElement("Nombre");
            elementoNombre5.setTextContent(socios.get(4).getNombre());
            socio5.appendChild(elementoNombre5);

            Element elementoPrimAp5 = doc.createElement("primerApelliod");
            elementoPrimAp5.setTextContent(socios.get(4).getPrimerApellido());
            socio5.appendChild(elementoPrimAp5);

            Element elementoSegAp5 = doc.createElement("segundoApellido");
            elementoSegAp2.setTextContent(socios.get(4).getSegundoApellido());
            socio5.appendChild(elementoSegAp5);

            Element elementoCorreo5 = doc.createElement("correo");
            elementoCorreo5.setTextContent(socios.get(4).getCorreo());
            socio5.appendChild(elementoCorreo5);

            Element elementoTelf5 = doc.createElement("telefono");
            elementoTelf5.setTextContent(socios.get(4).getTelefono());
            socio5.appendChild(elementoTelf5);

            Element elementoFecha5 = doc.createElement("fechaNacimiento");
            elementoFecha5.setTextContent(socios.get(4).getFechaNacimiento());
            socio5.appendChild(elementoFecha5);


            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            String xmlString = writer.toString();
            System.out.println(xmlString);
            File newXMLFile = new File("C:\\Users\\Diego\\Desktop\\DatosSocios.xml");
            StreamResult fileResult = new StreamResult(new FileOutputStream(newXMLFile));
            transformer.transform(source, fileResult);


            //Visualizar en pantalla

            //System.out.println(writer.toString());



        } catch (ParserConfigurationException | TransformerException | SQLException pce) {
            pce.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
