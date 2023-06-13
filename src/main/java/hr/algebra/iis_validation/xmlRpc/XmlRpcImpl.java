package hr.algebra.iis_validation.xmlRpc;

import hr.algebra.iis_validation.models.dhmz.City;
import hr.algebra.iis_validation.models.dhmz.DhmzCityData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class XmlRpcImpl implements XmlRpcFactory {
    
    private List<DhmzCityData> getDataFromDhmzServer() {
        try {
            URL url = new URL("https://vrijeme.hr/hrvatska_n.xml");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return null;
            }
            
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(url.openStream());
            
            List<DhmzCityData> dhmzCityDataList = new ArrayList<>();
            NodeList gradovi = document.getElementsByTagName("Grad");
            
            for (int i = 0; i < gradovi.getLength(); i++) {
                Element grad = (Element) gradovi.item(i);
                String gradIme = grad.getElementsByTagName("GradIme").item(0).getTextContent();
                String temp = grad.getElementsByTagName("Temp").item(0).getTextContent();
                
                dhmzCityDataList.add(new DhmzCityData(gradIme, temp));
            }
            
            return dhmzCityDataList;
            
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        for (var city : Objects.requireNonNull(getDataFromDhmzServer())) {
            cities.add(new City(city.getGradIme()));
        }
        return cities;
    }
    
    @Override
    public List<DhmzCityData> getDhmzCity(String grad) {
        List<DhmzCityData> cityData = new ArrayList<>();
        for (var city : Objects.requireNonNull(getDataFromDhmzServer())) {
            if (Objects.equals(city.getGradIme(), grad)) {
                cityData.add(new DhmzCityData(city.getGradIme().trim(), city.getTemp().trim()));
            }
        }
        return cityData;
    }
}
