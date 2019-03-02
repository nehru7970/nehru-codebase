package com.infinitec.rest.webservices.finleapweatherservices.gatewayapi;

import java.util.List;

public class OpenWeatherResponse {

	private List<WeatherTemplate> list;

	public List<WeatherTemplate> getList() {
		return list;
	}

	public void setList(List<WeatherTemplate> list) {
		this.list = list;
	}

}
