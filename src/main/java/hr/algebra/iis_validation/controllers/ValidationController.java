package hr.algebra.iis_validation.controllers;

import hr.algebra.iis_validation.models.ValidationResult;
import hr.algebra.iis_validation.repositories.XsdFactory;
import hr.algebra.iis_validation.repositories.XsdRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.stream.StreamSource;

import java.io.FileNotFoundException;

import static org.springframework.util.ResourceUtils.getFile;

@RestController
@RequestMapping("/validators")
public class ValidationController {
    private XsdFactory xsdFactory = new XsdRepository();

    @GetMapping(value = "/xsdValidation", produces = "application/json")
    public ValidationResult xsdValid(){
        try {
            return new ValidationResult(xsdFactory.ValidateXsd(new StreamSource(getFile("generatedMemes.xml"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
