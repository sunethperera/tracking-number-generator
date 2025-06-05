package com.getrosoft.trackingnumbergenerator.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.Map;

@Slf4j
public class TrackingNumberGenerator {

    public static String generateTrackingNumber(Map<String, String> trackingDetails) {

        String generatedString = trackingDetails.get("origin_country_id") +
                removeSpecialCharactersAndCovertToUpperCase(trackingDetails.get("created_at")) +
                removeSpecialCharactersAndCovertToUpperCase(trackingDetails.get("customer_id")) +
                removeSpecialCharactersAndCovertToUpperCase(trackingDetails.get("weight")) +
                removeSpecialCharactersAndCovertToUpperCase(trackingDetails.get("customer_slug")) +
                trackingDetails.get("destination_country_id");
        log.info("Generated character series : {}", generatedString);

        SecureRandom sr = new SecureRandom();
        int randomNumberSize = sr.nextInt(1, 16);
        StringBuilder generatedTrackingNumber = new StringBuilder(randomNumberSize);
        for (int i = 0; i < randomNumberSize; i++) {
            int index = sr.nextInt(generatedString.length());
            generatedTrackingNumber.append(generatedString.charAt(index));
        }
        log.info("Generated tracking number : {}", generatedTrackingNumber.toString());
        return generatedTrackingNumber.toString();
    }

    private static String removeSpecialCharactersAndCovertToUpperCase(String trackingParameter) {
        return trackingParameter.replaceAll("[^a-zA-Z0-9\\s]", "").toUpperCase();
    }
}
