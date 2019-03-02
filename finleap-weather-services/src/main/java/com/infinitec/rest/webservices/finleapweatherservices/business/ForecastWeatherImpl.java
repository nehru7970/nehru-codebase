package com.infinitec.rest.webservices.finleapweatherservices.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infinitec.rest.webservices.finleapweatherservices.gatewayapi.OpenWeatherMapGateway;
import com.infinitec.rest.webservices.finleapweatherservices.gatewayapi.WeatherTemplate;
import com.infinitec.rest.webservices.finleapweatherservices.resource.Weather;
import com.infinitec.rest.webservices.finleapweatherservices.utils.RestServiceConstants;
import com.infinitec.rest.webservices.finleapweatherservices.utils.RestServicesUtils;
/**
 * 
 * @author Arun Nehru
 * 
 * This class filters and calculates the data as per the requirement which
 *  was consumed from openweathermap rest service
 *
 */
@Component
public class ForecastWeatherImpl implements ForecastWeather {

	@Autowired
	OpenWeatherMapGateway openWeatherMapGateway;

	@Override
	public Weather calculateWeatherForecast(String cityName) {
		//Extracts the data for 5 days
		List<WeatherTemplate> extractedWeatherData = openWeatherMapGateway.extractWeatherInfromation(cityName);
		
		
		// Filters List for 3 days using stream and Predicate isBefore
				List<WeatherTemplate> filteredData = new ArrayList<>();
		filteredData = extractedWeatherData.stream().filter(RestServicesUtils.isBefore())
				.collect(Collectors.<WeatherTemplate>toList());

		//Creating the response object
		Weather weather = new Weather();
		
		/*BiFunction<List<WeatherTemplate>, Predicate<WeatherTemplate>, Double>
		Which will return the average by taking two inputs the list and predicate 
		gives back the average of day time temperature for a period of 3 days.*/

		weather.setDayTimeTemp(calculateCelsius(calculateAverageTemperature.apply(filteredData, isDaytime())));
		weather.setNightTimeTemp(calculateCelsius(calculateAverageTemperature.apply(filteredData, isDaytime().negate())));
		weather.setPressure(caluculateAveragePressure.apply(filteredData));
		weather.setCityName(cityName);

		return weather;
	}

	//BiFunction to calculate the average of temperature using predicate
	public BiFunction<List<WeatherTemplate>, Predicate<WeatherTemplate>, Double> calculateAverageTemperature =

			(weatherTemplate, predicate) -> {
				Double temperatue = 0.00;
				int count = 0;
				for (WeatherTemplate weatherData : weatherTemplate)
					if (predicate.test(weatherData)) {
						temperatue += ((WeatherTemplate) weatherData).getMain().getTemp();
						count++;
					}
				return temperatue / count;
			};

	public Predicate<WeatherTemplate> isDaytime() {
		return weatherData -> Arrays.asList(RestServiceConstants.dayTime)
				.contains(((WeatherTemplate) weatherData).getDt_txt().substring(11));
	}
	
	//Function to calculate the average by taking input as filtered list
	public Function<List<WeatherTemplate>, Double> caluculateAveragePressure = weatherTemplate -> {
		Double pressure = 0.00;
		int count = 0;
		for (WeatherTemplate weatherData : weatherTemplate) {
			pressure += ((WeatherTemplate) weatherData).getMain().getPressure();
			count++;
		}
		return pressure / count;
	};

	//Converting Kelvin to Celsius
	public float calculateCelsius(double kelvin) {
		float celsius = (float) (kelvin - 273.15F);
		return celsius;
	}
}
