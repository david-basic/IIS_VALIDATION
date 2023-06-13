package hr.algebra.iis_validation.jaxb;

import javax.xml.transform.stream.StreamSource;

public interface JaxbFactory {
    String ValidateXsd(StreamSource xml);
}
