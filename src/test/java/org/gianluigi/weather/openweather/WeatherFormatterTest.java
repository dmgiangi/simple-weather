package org.gianluigi.weather.openweather;

import org.apache.commons.io.IOUtils;
import junit.framework.TestCase;
import org.gianluigi.weather.OpenWeatherParser;
import org.gianluigi.weather.Weather;
import org.gianluigi.weather.WeatherFormatter;

import java.io.InputStream;

public class WeatherFormatterTest extends TestCase {
    public WeatherFormatterTest(String name) {
        super(name);
    }

    public void testFormatter() throws Exception {
        InputStream data = getClass().getClassLoader().getResourceAsStream("weather-data.xml");
        Weather weather = new OpenWeatherParser().parse(data);
        String formattedResult = new WeatherFormatter().format(weather);
        InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.dat");
        assertEquals(IOUtils.toString(expected).trim(), formattedResult.trim());
    }
}
