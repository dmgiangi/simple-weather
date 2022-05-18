package org.gianluigi.weather;

import org.apache.log4j.PropertyConfigurator;
import java.io.InputStream;

public class Main {
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

    private final String latitude;
    private final String longitude;

    public Main(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void start(){
        InputStream dataIn = new OpenWeatherRetriever().retrieve(latitude, longitude);

        Weather weather = new OpenWeatherParser().parse(dataIn);

        System.out.print(new WeatherFormatter().format(weather));
    }
}
