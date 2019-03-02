package com.infinitec.rest.webservices.finleapweatherservices.gatewayapi;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.infinitec.rest.webservices.finleapweatherservices.utils.RestServiceConstants;
/**
 * 
 * @author Arun Nehru
 * 
 * This class invokes the rest API data from OpenWeatherMap
 *
 */
@Component
public class OpenWeatherMapGatewayImpl implements OpenWeatherMapGateway {

	@Override
	public List<WeatherTemplate> extractWeatherInfromation(String cityName) {
		RestTemplate restTemplate = new RestTemplate();

		OpenWeatherResponse responseObject = restTemplate.getForObject(RestServiceConstants.OPENWEATHERURL + cityName,
				OpenWeatherResponse.class);
	/*	System.out.println("Before filter");
		responseObject.getList().forEach(System.out::println);*/
		return responseObject.getList();
	}

}
