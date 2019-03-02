package com.infinitec.rest.webservices.finleapweatherservices.resource;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This object which gives the information of "
		+ "Average temperature (in Celsius) of the next 3 days from today’s date for Day\r\n" + 
		"time (06:00 – 18:00) and Night time (18:00 – 06:00) .\r\n" + 
		"Average of pressure for the next 3 days from today’s date")
public class Weather {

	@ApiModelProperty(notes = "Average temperature (in Celsius) of the next 3 days from today’s date for Day")
	private double dayTimeTemp;
	@ApiModelProperty(notes = "Average temperature (in Celsius) of the next 3 days from today’s date for "
			+ "Night")
	private double nightTimeTemp;
	@ApiModelProperty(notes = "Average pressure of the next 3 days from today’s date")
	private double pressure;
	 @NotNull(message = "City Name cannot be null")
	private String cityName;

	public Weather() {
	}

	protected Weather(double dayTimeTemp, double nightTimeTemp, double pressure, String cityName) {
		super();
		this.dayTimeTemp = dayTimeTemp;
		this.nightTimeTemp = nightTimeTemp;
		this.pressure = pressure;
		this.cityName = cityName;
	}

	public double getDayTimeTemp() {
		return dayTimeTemp;
	}

	public void setDayTimeTemp(double dayTimeTemp) {
		this.dayTimeTemp = dayTimeTemp;
	}

	public double getNightTimeTemp() {
		return nightTimeTemp;
	}

	public void setNightTimeTemp(double nightTimeTemp) {
		this.nightTimeTemp = nightTimeTemp;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
