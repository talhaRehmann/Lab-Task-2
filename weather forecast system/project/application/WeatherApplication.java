package application;

import domain.Weather;
import domain.WeatherService;

public class WeatherApplication {
    private final WeatherService weatherService;

    public WeatherApplication(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Weather getWeatherForLocation(String location) {
        return weatherService.getCurrentWeather(location);
    }
}
