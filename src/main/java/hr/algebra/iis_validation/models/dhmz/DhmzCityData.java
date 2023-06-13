package hr.algebra.iis_validation.models.dhmz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DhmzCityData extends City implements Serializable {
    private String Temp;
    
    public DhmzCityData(String GradIme, String temp) {
        super(GradIme);
        Temp = temp;
    }
}
