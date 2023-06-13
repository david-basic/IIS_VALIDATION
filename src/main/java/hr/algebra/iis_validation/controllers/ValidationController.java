package hr.algebra.iis_validation.controllers;

import hr.algebra.iis_validation.jaxb.JaxbFactory;
import hr.algebra.iis_validation.jaxb.JaxbValidator;
import hr.algebra.iis_validation.models.ValidationResult;
import hr.algebra.iis_validation.repositories.RngFactory;
import hr.algebra.iis_validation.repositories.RngRepository;
import hr.algebra.iis_validation.repositories.XsdFactory;
import hr.algebra.iis_validation.repositories.XsdRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.springframework.util.ResourceUtils.getFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/validators")
public class ValidationController {
    private XsdFactory xsdFactory = new XsdRepository();

    @GetMapping(value = "/xsdValidation", produces = "application/json")
    public ValidationResult xsdValid() {
        try {
            return new ValidationResult(xsdFactory.ValidateXsd(new StreamSource(getFile("generatedMemes.xml"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private RngFactory rngFactory = new RngRepository();

    @GetMapping(value = "/rngValidation", produces = "application/json")
    public ValidationResult rngValid() {
        return new ValidationResult(rngFactory.ValidateRng(new File("generatedMemes.xml")));
    }

    @PostMapping(value = "/fileUpload", produces = "application/json", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ValidationResult uploadFile(@ModelAttribute MultipartFile uploadedXml) {
        if (uploadedXml == null) {
            return new ValidationResult("No file uploaded.");
        } else if (!uploadedXml.getOriginalFilename().endsWith("xml")) {
            return new ValidationResult("Wrong file type uploaded.");
        }

        try (FileOutputStream fos = new FileOutputStream("generatedMemes.xml")) {
            byte[] dataInBytes = uploadedXml.getBytes();
            fos.write(dataInBytes);
            return new ValidationResult("File successfully uploaded!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JaxbFactory jaxbValidator = new JaxbValidator();
    @GetMapping(value = "/jaxbValidation", produces = "application/json")
    public ValidationResult jaxbValid() {
        try {
            return new ValidationResult(jaxbValidator.ValidateXsd(new StreamSource(getFile("generatedMemes.xml"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
