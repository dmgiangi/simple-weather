package org.gianluigi.weather;

/**
 * The type Weather.
 */
public class Weather {
    private String city;
    private String region;
    private String country;
    private String condition;
    private String temp;
    private String chill;
    private String humidity;

    /**
     * Instantiates a new Weather.
     *
     * @param city      the city
     * @param region    the region
     * @param country   the country
     * @param condition the condition
     * @param temp      the temp
     * @param chill     the chill
     * @param humidity  the humidity
     */
    public Weather(String city, String region, String country, String condition, String temp, String chill, String humidity) {
        this.city = city;
        this.country = country;
        this.condition = condition;
        this.temp = temp;
        this.chill = chill;
        this.humidity = humidity;
    }

    /**
     * Instantiates a new Weather.
     */
    public Weather() {
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets condition.
     *
     * @param condition the condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Sets temp.
     *
     * @param temp the temp
     */
    public void setTemp(String temp) {
        this.temp = temp;
    }

    /**
     * Sets chill.
     *
     * @param chill the chill
     */
    public void setChill(String chill) {
        this.chill = chill;
    }

    /**
     * Sets humidity.
     *
     * @param humidity the humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets condition.
     *
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Gets temp.
     *
     * @return the temp
     */
    public String getTemp() {
        return temp;
    }

    /**
     * Gets chill.
     *
     * @return the chill
     */
    public String getChill() {
        return chill;
    }

    /**
     * Gets humidity.
     *
     * @return the humidity
     */
    public String getHumidity() {
        return humidity;
    }
}
