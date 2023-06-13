package hr.algebra.iis_validation.controllers;

import hr.algebra.iis_validation.models.dhmz.City;
import hr.algebra.iis_validation.models.dhmz.DhmzCityData;
import hr.algebra.iis_validation.xmlRpc.XmlRpcFactory;
import hr.algebra.iis_validation.xmlRpc.XmlRpcImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dhmz")
@CrossOrigin(origins = "*")
public class DhmzController {
    private XmlRpcFactory cityFactory = new XmlRpcImpl();
    
    @GetMapping(value = "/getCities", produces = "application/json")
    public List<City> getCities() {
        return cityFactory.getCities();
    }
    
    @GetMapping(value = "/getCity", produces = "application/json")
    public List<DhmzCityData> getDhmzCityData(@RequestParam(name = "grad") String GradIme) {
        return cityFactory.getDhmzCity(GradIme);
    }
}
