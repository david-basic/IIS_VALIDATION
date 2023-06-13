package hr.algebra.iis_validation.xmlRpc;

import hr.algebra.iis_validation.models.dhmz.City;
import hr.algebra.iis_validation.models.dhmz.DhmzCityData;

import java.util.List;

public interface XmlRpcFactory {
    List<City> getCities();
    List<DhmzCityData> getDhmzCity(String GradIme);
}
