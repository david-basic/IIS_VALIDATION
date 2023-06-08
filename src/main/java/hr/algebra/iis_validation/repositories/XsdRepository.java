package hr.algebra.iis_validation.repositories;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.util.Arrays;

@Repository
@NoArgsConstructor
public class XsdRepository implements XsdFactory {
    @Override
    public String ValidateXsd(StreamSource xml) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaFile = new StreamSource("generatedMemes.xsd");
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xml);
            return "File validated. File is VALID!";
        } catch (SAXException | IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return e.getMessage();
        }
    }
}
