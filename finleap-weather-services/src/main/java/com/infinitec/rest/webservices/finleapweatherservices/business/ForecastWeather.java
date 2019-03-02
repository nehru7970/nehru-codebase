package com.infinitec.rest.webservices.finleapweatherservices.business;

import com.infinitec.rest.webservices.finleapweatherservices.resource.Weather;
/**
 * 
 * @author Arun Nehru
 *
 */
public interface ForecastWeather {

	public Weather calculateWeatherForecast(String cityName);
}
