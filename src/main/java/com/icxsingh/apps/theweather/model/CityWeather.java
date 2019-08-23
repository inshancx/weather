package com.icxsingh.apps.theweather.model;

public class CityWeather {
	private String cityName;
	private String weatherData;
	private float humidity;
	private float temp;
	private String country;


	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the weatherData
	 */
	public String getWeatherData() {
		return weatherData;
	}

	/**
	 * @param weatherData
	 *            the weatherData to set
	 */
	public void setWeatherData(String weatherData) {
		this.weatherData = weatherData;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
