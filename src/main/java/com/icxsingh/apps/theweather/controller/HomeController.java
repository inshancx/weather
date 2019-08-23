package com.icxsingh.apps.theweather.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icxsingh.apps.theweather.model.CityWeather;
import com.icxsingh.apps.theweather.weatherservice.WeatherService;

@Controller
public class HomeController {
	
	Logger logger = Logger.getLogger("HomeController");

	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@GetMapping(value = "getWeather")
	public ModelAndView getWeather(HttpServletResponse response, HttpServletRequest request)
			throws IOException, InterruptedException {

		String c = request.getParameter("city");
		String[] cities = c.split(",");
		ArrayList<CityWeather> weatherList = new ArrayList<>();
		WeatherService ws = new WeatherService();

		try {
			weatherList = ws.callWeatherServiceByCities(cities);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("weather_results");
		modelAndView.addObject("results", weatherList);

		return modelAndView;
	}
	


}
