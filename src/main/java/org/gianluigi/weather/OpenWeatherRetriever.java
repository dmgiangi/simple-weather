package org.gianluigi.weather;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownServiceException;

public class OpenWeatherRetriever {
    private static final Logger logger = Logger.getLogger(OpenWeatherRetriever.class);

    public InputStream retrieve(String latitude, String longitude) {
        logger.info("Retrieving Weather Data");
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "lat=" + latitude + "&" +
                "lon=" + longitude + "&" +
                "appid=0e8ba2975cf97b324188b74d9a7b4df3&" +
                "mode=xml&" +
                "units=metric";
        try {
            URLConnection connection = new URL(url).openConnection();
            return connection.getInputStream();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (UnknownServiceException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
