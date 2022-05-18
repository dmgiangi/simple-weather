package org.gianluigi.weather.openweather;

import junit.framework.TestCase;
import org.apache.log4j.net.TelnetAppender;
import org.gianluigi.weather.OpenWeatherParser;
import org.gianluigi.weather.Weather;

import java.io.InputStream;

public class OpenWeatherParserTest extends TestCase {
    public OpenWeatherParserTest(String name) {
        super(name);
    }

    public void testParser() {
        InputStream nyData = getClass().getClassLoader().getResourceAsStream("weather-data.xml");
        Weather weather = new OpenWeatherParser().parse(nyData);
        assertEquals("Titeşti", weather.getCity());
        assertEquals("RO", weather.getCountry());
        assertEquals("11.91", weather.getTemp());
        assertEquals("broken clouds", weather.getCondition());
        assertEquals("Light breeze", weather.getChill());
        assertEquals("70", weather.getHumidity());
    }
}