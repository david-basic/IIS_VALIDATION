package hr.algebra.iis_validation.repositories;

import com.thaiopensource.validate.SchemaReader;
import com.thaiopensource.validate.ValidationDriver;
import com.thaiopensource.validate.auto.AutoSchemaReader;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Repository
@Data
@NoArgsConstructor
public class RngRepository implements RngFactory {

    String resultMessage;

    @Override
    public String ValidateRng(File xml) {
        try {
            SchemaReader reader = new AutoSchemaReader();
            ValidationDriver driver = new ValidationDriver(reader);
            InputSource rngInput = ValidationDriver.fileInputSource(new File("generatedMemesRng.xml"));
            driver.loadSchema(rngInput);

            InputSource xmlInput = ValidationDriver.fileInputSource(xml);
            boolean fileValid = driver.validate(xmlInput);

            if (fileValid) {
                setResultMessage("File is VALID!");
            } else {
                setResultMessage("File is NOT valid!");
            }
        } catch (IOException | SAXException e) {
            setResultMessage(Arrays.toString(e.getStackTrace()));
        }

        return resultMessage;
    }
}
