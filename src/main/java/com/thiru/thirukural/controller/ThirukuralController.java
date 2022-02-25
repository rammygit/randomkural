package com.thiru.thirukural.controller;

import java.util.Collections;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thiru.thirukural.model.Thirukural;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;

/**
 * quick POC 
 * @author Ram
 */
@RestController
@Log
public class ThirukuralController {

    @Autowired
    private RestTemplate restTemplate;

    
    @GetMapping("/thirukural/{num}")
    Thirukural getRandomOne(@PathVariable int num) {
       
        return getThirukural(num);
    }
   

    @PostMapping("/thirukural")
    Thirukural newEmployee(@RequestBody Integer number) {
        if(number==null) 
            return new Thirukural();
        return getThirukural(number.intValue());
    }


    private Thirukural getThirukural(int num) {

        if (num <= 0)
            num = getRand(1, 1331);

        HttpHeaders headers = new HttpHeaders();
        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity request = new HttpEntity(headers);

        // make an HTTP GET request with headers
        ResponseEntity < Thirukural > response = restTemplate.exchange(
            "https://api-thirukkural.vercel.app/api?num={num}",
            HttpMethod.GET,
            request,
            Thirukural.class,
            num
        );

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            log.info("success message on response");
            log.info(response.getBody().toString());
            
            return response.getBody();
        } else {
            log.info("Request Failed");

            log.info(response.getStatusCode().toString());

            return new Thirukural();
        }

    }

    private int getRand(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
            .findFirst()
            .getAsInt();
    }

}