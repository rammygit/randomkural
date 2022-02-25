package com.thiru.thirukural;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.thiru.thirukural.model.Thirukural;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class ThirukuralApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirukuralApplication.class, args);
	}


	//https://api-thirukkural.vercel.app/api?num=1

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate template = builder.build();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM,MediaType.TEXT_HTML));
		// ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
		// return builder.build();
		template.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		return template;
	}

	@Bean
	public CommandLineRunner run() throws Exception{
		// int num = getRand(1,1331);
		// log.info("print num "
		// +num);


		return args -> {

			log.info("********** App run Initialized! Welcome to Thirukural App ************");
			
		// 	HttpHeaders headers = new HttpHeaders();
		// 	// set `Content-Type` and `Accept` headers
		// 	headers.setContentType(MediaType.APPLICATION_JSON);
		// 	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// 	HttpEntity request = new HttpEntity(headers);

		// 	// make an HTTP GET request with headers
		// 	ResponseEntity<Thirukural> response = restTemplate.exchange(
		// 		"https://api-thirukkural.vercel.app/api?num={num}",
		// 			HttpMethod.GET,
		// 			request,
		// 			Thirukural.class,
		// 			num
		// 	);

		// 	// check response
		// 	if (response.getStatusCode() == HttpStatus.OK) {
		// 		log.info("success message on response");
		// 		log.info(response.getBody().toString());
		// 	} else {
		// 		log.info("Request Failed");
		// 		log.info(response.getStatusCode().toString());
		// 	}
		};
	}




	private int getRand(int min, int max) {
		Random random = new Random();
		return random.ints(min, max)
		  .findFirst()
		  .getAsInt();
	}



}
