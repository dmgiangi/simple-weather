package org.gianluigi.weather;

import org.apache.log4j.PropertyConfigurator;
import java.io.InputStream;

/**
 * This class is the entry-point of the software read the args then if the args are valid retrieve weather data and show it on
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the main method accept only two argument:
     *             first argument is a latitude (minimum -90.0 ~ maximun 90.0
     *             second argument is a longitude (minimun -180.0 ~ maximun 180.0)
     */
    public static void main(String[] args) {
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
        float latitude, longitude;
        if(args.length != 2){
            System.out.println("only two argument is accepted.");
            return;
        }
        try{
            latitude = Float.parseFloat(args[0]);
            longitude = Float.parseFloat(args[1]);
        } catch (NumberFormatException ex){
            System.out.println("the arguments must be two decimal number");
            System.out.println("Arguments must be Latitude(-90.0 ~ +90.0) and Longitude (-180.0 ~ +180.0)");
            return;
        }

        if(latitude < -90.0f || latitude > 90.0f){
            System.out.println("Latitude must be a decimal number between -90.0 and +90.0");
            return;
        }
        if(longitude < -180.0f || longitude > 180.0f){
            System.out.println("Latitude must be a decimal number between -180.0 and +180.0");
            return;
        }

        new Main(args[0], args[1]).start();
    }
    /*
     * latitude is the latitude of the place
     */
    private final String latitude;
    /*
     * longitude is the longitude of the place
     */
    private final String longitude;

    /**
     * Instantiates a new Main.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    public Main(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Start call the object that retrieve, parse and format the weather data.
     */
    public void start(){
        InputStream dataIn = new OpenWeatherRetriever().retrieve(latitude, longitude);

        Weather weather = new OpenWeatherParser().parse(dataIn);

        System.out.print(new WeatherFormatter().format(weather));
    }
}
