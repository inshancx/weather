package com.icxsingh.apps.theweather.weatherservice;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.icxsingh.apps.theweather.model.CityWeather;
import com.icxsingh.apps.theweather.model.CityWeatherData;

public class WeatherService {
	
	Logger logger = Logger.getLogger("WeatherService");
	public static final String WEATHER_URI_CITIES = "https://api.openweathermap.org/data/2.5/weather?q=";
	public static final String API_KEY = "d22ebd123bf7cee2250b6ee2952e91c7";

	
	public ArrayList<CityWeather> callWeatherServiceByCities(String[] cities) throws InterruptedException, ParseException {
		
		ArrayList<CityWeather> weatherList = new ArrayList<>();
		CityWeather cityWeather;		
		RestTemplate restTemplate = new RestTemplate();
		
		CityWeatherData weatherData = null;
		if (cities != null) {
			int numberOfCities = cities.length;
			logger.info(String.format("--- Total Cities: %s ---", numberOfCities));
			System.out.println(String.format("--- Total Cities: %s ---", numberOfCities));
			if (cities.length > 0) {

				for (String cityName : cities) {				
					if (!StringUtils.isEmpty(cityName)) {
						cityWeather = new CityWeather();
						weatherData = restTemplate.getForObject(
								WEATHER_URI_CITIES+cityName+"&APPID="+API_KEY, CityWeatherData.class);
						cityWeather.setCityName(cityName.toUpperCase());
						cityWeather.setHumidity(weatherData.getMain().getHumidity());
						cityWeather.setCountry(weatherData.getSys().getCountry());
						cityWeather.setTemp(convertKtoF(weatherData.getMain().getTemp()));
						weatherList.add(cityWeather);

					}

					logger.debug("Weather Data: " + weatherData + " for " + cityName);
				}
			}
		}
		
		
		return weatherList;
	}
	
	private float convertKtoF(float kelvinTemp) {
		float temp = (float) (kelvinTemp - 273.15) * 9/5 + 32f;
		
		return Math.round(temp);
	}

}
