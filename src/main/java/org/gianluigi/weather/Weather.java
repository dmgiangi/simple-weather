package org.gianluigi.weather;

public class Weather {
    private String city;
    private String region;
    private String country;
    private String condition;
    private String temp;
    private String chill;
    private String humidity;

    public Weather(String city, String region, String country, String condition, String temp, String chill, String humidity) {
        this.city = city;
        this.country = country;
        this.condition = condition;
        this.temp = temp;
        this.chill = chill;
        this.humidity = humidity;
    }

    public Weather() {
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCondition() {
        return condition;
    }

    public String getTemp() {
        return temp;
    }

    public String getChill() {
        return chill;
    }

    public String getHumidity() {
        return humidity;
    }
}
