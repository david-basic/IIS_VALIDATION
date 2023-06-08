package hr.algebra.iis_validation.repositories;

import javax.xml.transform.stream.StreamSource;

public interface XsdFactory {
    String ValidateXsd(StreamSource xml);
}
