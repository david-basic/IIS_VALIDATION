package hr.algebra.iis_validation.jaxb;

import hr.algebra.iis_validation.models.jaxb.GeneratedMemes;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class JaxbValidator implements JaxbFactory {
    @Override
    public String ValidateXsd(StreamSource xml) {
        JAXBContext context = null;
        
        try {
            context = JAXBContext.newInstance(GeneratedMemes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("generatedMemes.xsd"));
            unmarshaller.setSchema(schema);
            JAXBElement<GeneratedMemes> generatedMemesJAXBElement = (JAXBElement<GeneratedMemes>) unmarshaller.unmarshal(xml);
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
            return "File is NOT valid!";
        }
        
        return "File is VALID!";
    }
}
