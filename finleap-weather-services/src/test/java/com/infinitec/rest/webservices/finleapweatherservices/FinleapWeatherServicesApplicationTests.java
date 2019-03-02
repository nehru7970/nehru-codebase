package com.infinitec.rest.webservices.finleapweatherservices;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.infinitec.rest.webservices.finleapweatherservices.business.ForecastWeather;
import com.infinitec.rest.webservices.finleapweatherservices.gatewayapi.Main;
import com.infinitec.rest.webservices.finleapweatherservices.gatewayapi.OpenWeatherMapGateway;
import com.infinitec.rest.webservices.finleapweatherservices.gatewayapi.WeatherTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinleapWeatherServicesApplicationTests {

	@MockBean
	OpenWeatherMapGateway openWeatherMapGateway;

	@Autowired
	ForecastWeather forecastWeather;

	@Test
	public void contextLoads() {
		List<WeatherTemplate> list=new ArrayList<>();
		Main main=new Main();
		main.setTemp(303.15);
		main.setPressure(1000.90);
		WeatherTemplate  weatherTemplate=new WeatherTemplate();
		weatherTemplate.setMain(main);
		weatherTemplate.setDt("1550750400");
		weatherTemplate.setDt_txt("2019-02-22 15:00:00");
		list.add(weatherTemplate);
		
		Main main1=new Main();
		main1.setTemp(303.15);
		main1.setPressure(1000.90);
		WeatherTemplate  weatherTemplate1=new WeatherTemplate();
		weatherTemplate1.setMain(main);
		weatherTemplate1.setDt("1550750400");
		weatherTemplate1.setDt_txt("2019-02-24 15:00:00");
		list.add(weatherTemplate);
		Mockito.when(openWeatherMapGateway.extractWeatherInfromation("London")).thenReturn(list);
		
		assertEquals(30,(int) forecastWeather.calculateWeatherForecast("London").getDayTimeTemp());
	}
	
	@Test
	public void context() {
		
		List<WeatherTemplate> list=new ArrayList<>();
		Main main=new Main();
		main.setTemp(303.15);
		main.setPressure(1000.90);
		WeatherTemplate  weatherTemplate=new WeatherTemplate();
		weatherTemplate.setMain(main);
		weatherTemplate.setDt("1550750400");
		weatherTemplate.setDt_txt("2019-02-22 15:00:00");
		list.add(weatherTemplate);
		
		Main main1=new Main();
		main1.setTemp(303.15);
		main1.setPressure(1000.90);
		WeatherTemplate  weatherTemplate1=new WeatherTemplate();
		weatherTemplate1.setMain(main);
		weatherTemplate1.setDt("1550750400");
		weatherTemplate1.setDt_txt("2019-02-24 15:00:00");
		list.add(weatherTemplate);
		Mockito.when(openWeatherMapGateway.extractWeatherInfromation("London")).thenReturn(list);
		
		assertEquals("London", forecastWeather.calculateWeatherForecast("London").getCityName());
		
	}

}
