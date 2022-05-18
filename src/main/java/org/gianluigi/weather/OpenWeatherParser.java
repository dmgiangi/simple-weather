package org.gianluigi.weather;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class OpenWeatherParser {
    private static final Logger logger = Logger.getLogger(OpenWeatherParser.class);

    public Weather parse(InputStream inputStream) {
        Weather weather = null;
        logger.info("Creating XML Reader");
        SAXReader xmlReader = createXMLReader();
        try {
            Document document = xmlReader.read(inputStream);
            logger.info("Parsing XML Response");

            weather = new Weather();
            weather.setCity(
                    document.valueOf("current/city/@name")
            );
            weather.setCountry(
                    document.valueOf("current/city/country")
            );
            weather.setCondition(
                    document.valueOf("current/weather/@value")
            );
            weather.setTemp(
                    document.valueOf("current/temperature/@value")
            );
            weather.setChill(
                    document.valueOf("current/wind/speed/@name")
            );
            weather.setHumidity(
                    document.valueOf("current/humidity/@value")
            );
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("\n\nCannot parse the document Yahoo parser will return NULL.\n\n");
        }
        return weather;
    }

    private SAXReader createXMLReader() {
        return new SAXReader();
    }
}
