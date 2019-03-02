package com.infinitec.rest.webservices.finleapweatherservices.gatewayapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherTemplate {

	private String dt;
	private String dt_txt;
	private Main main;

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return String.format("WeatherTemplate [dt=%s, dt_txt=%s, main=%s]", dt, dt_txt, main);
	}

}
