package domain;

public class Weather {
    private String location;
    private double temperature;
    private String forecast;

    
    public Weather(String location, double temperature, String forecast) {
        this.location = location;
        this.temperature = temperature;
        this.forecast = forecast;
    }

    public Weather(String location2, double temperature2) {
        
    }

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getForecast() {
        return forecast;
    }
}
