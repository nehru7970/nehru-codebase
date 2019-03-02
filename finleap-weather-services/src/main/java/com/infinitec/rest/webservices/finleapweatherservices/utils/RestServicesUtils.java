package com.infinitec.rest.webservices.finleapweatherservices.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import com.infinitec.rest.webservices.finleapweatherservices.gatewayapi.WeatherTemplate;

public class RestServicesUtils {

	public static String dateComparor() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(RestServiceConstants.UTCFORMATDATE);
		Date currentDate = new Date();
		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusDays(2).withHour(22).withMinute(0).withSecond(0);
		return dateFormat.format(localDateTime);
	}

	public static LocalDateTime dateConverter(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
		return dateTime;
	}

	public static Predicate<WeatherTemplate> isBefore() {
		return weatherData -> dateConverter(weatherData.getDt_txt()).isBefore(dateConverter(dateComparor()));
	}

 }
