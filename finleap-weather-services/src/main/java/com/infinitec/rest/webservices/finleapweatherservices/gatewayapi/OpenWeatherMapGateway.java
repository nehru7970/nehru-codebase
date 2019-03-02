package com.infinitec.rest.webservices.finleapweatherservices.gatewayapi;

import java.util.List;
/**
 * Gateway Interface for OpenWeatherMap Rest Service
 * @author Arun Nehru
 *
 */
public interface OpenWeatherMapGateway {
	
	public List<WeatherTemplate> extractWeatherInfromation(String cityName);

}
