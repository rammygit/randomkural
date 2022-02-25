package com.thiru.thirukural.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
	 * {
          "number": 1,
          "sect_tam": "அறத்துப்பால்",
          "chapgrp_tam": "பாயிரவியல்",
          "chap_tam": "கடவுள் வாழ்த்து",
          "line1": "அகர முதல எழுத்தெல்லாம் ஆதி",
          "line2": "பகவன் முதற்றே உலகு.",
          "tam_exp": "அகரம் எழுத்துக்களுக்கு முதன்மை; ஆதிபகவன், உலகில் வாழும் உயிர்களுக்கு முதன்மை",
          "sect_eng": "Virtue",
          "chapgrp_eng": "Prologue",
          "chap_eng": "The Praise of God",
          "eng": "'A' leads letters; the Ancient Lord Leads and lords the entire world",
          "eng_exp": "As the letter A is the first of all letters, so the eternal God is first in the world"
          }
	 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thirukural {

    private String sect_tam;
    private String line1;
    private String line2;
    private String tam_exp;
    private String eng_exp;


    
    

    
}
