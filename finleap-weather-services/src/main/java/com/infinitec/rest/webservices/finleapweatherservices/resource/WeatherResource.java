package com.infinitec.rest.webservices.finleapweatherservices.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infinitec.rest.webservices.finleapweatherservices.business.ForecastWeather;
import com.infinitec.rest.webservices.finleapweatherservices.exception.CityNotFoundException;
/**
 * 
 * @author Arun Nehru
 *RestController which exposes the uri and invokes the business layer
 */
@RestController
public class WeatherResource {

	@Autowired
	ForecastWeather forecastWeather;

	@GetMapping("/data/{cityName}")
	public Weather retriveWeather(@PathVariable String cityName) {

		if (cityName == null || (cityName.equals("")) || !(cityName.chars().allMatch(Character::isLetter)))
			throw new CityNotFoundException("Invalid City Name : " + cityName);

		return forecastWeather.calculateWeatherForecast(cityName);

	}

}
