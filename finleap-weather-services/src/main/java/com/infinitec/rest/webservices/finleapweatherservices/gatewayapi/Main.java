package com.infinitec.rest.webservices.finleapweatherservices.gatewayapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author asriramo
 * Pojo for intercepting the data from RestService Response
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

	private double temp;
	private double pressure;

	public Main() {
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	@Override
	public String toString() {
		return String.format("Main [temp=%s, pressure=%s]", temp, pressure);
	}

}
