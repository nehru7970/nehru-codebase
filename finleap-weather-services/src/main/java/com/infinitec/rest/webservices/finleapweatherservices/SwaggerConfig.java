package com.infinitec.rest.webservices.finleapweatherservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author Arun Nehru
 * This is the configuration class required for Swagger API documentation 
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Arun Nehru", "", "nehru7970@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new 
			ApiInfo("API that will retrieve weather metrics of a specific city", "Returns a JSON object that gives the averages of the\r\n" + 
					"following metrics:\r\n" + 
					" Average temperature (in Celsius) of the next 3 days from today’s date for Day\r\n" + 
					"time (06:00 – 18:00) and Night time (18:00 – 06:00) .\r\n" + 
					" Average of pressure for the next 3 days from today’s date", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json","application/xml"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}

}
