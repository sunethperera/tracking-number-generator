package com.getrosoft.trackingnumbergenerator.controller;

import com.getrosoft.trackingnumbergenerator.dto.TrackingNumberDetailsDto;
import com.getrosoft.trackingnumbergenerator.utils.TrackingNumberGenerator;
import com.getrosoft.trackingnumbergenerator.utils.annotations.ISO31661Alpha2;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@Validated
@Slf4j
public class TrackingNumGeneratorController {

    //Logger log = LoggerFactory.getLogger(TrackingNumGeneratorController.class);

    @GetMapping("/next-tracking-number")
    public ResponseEntity<TrackingNumberDetailsDto> getNextTrackingNumber(@RequestParam("origin_country_id") @Valid @ISO31661Alpha2 String originCountryId,
                                                                          @RequestParam("destination_country_id") @Valid @ISO31661Alpha2 String destinationCountryId,
                                                                          @RequestParam("weight") Double weight,
                                                                          @RequestParam("created_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime createdDateTime,
                                                                          @RequestParam("customer_id") String customerId,
                                                                          @RequestParam("customer_name") String customerName,
                                                                          @RequestParam("customer_slug") String customerSlug) {

        Map<String, String> trackingDetails = new HashMap<>();
        trackingDetails.put("origin_country_id", originCountryId);
        trackingDetails.put("destination_country_id", destinationCountryId);
        trackingDetails.put("weight", weight.toString());
        trackingDetails.put("created_at", createdDateTime.toString());
        trackingDetails.put("customer_id", customerId);
        trackingDetails.put("customer_name", customerName);
        trackingDetails.put("customer_slug", customerSlug);

        TrackingNumberDetailsDto trackingNumberDetailsDto = new TrackingNumberDetailsDto();
        trackingNumberDetailsDto.setTrackingNumber(TrackingNumberGenerator.generateTrackingNumber(trackingDetails));
        trackingNumberDetailsDto.setCreatedDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date()));
        log.info("Generated tracking number response for customer {} for the order created at {} : {}",
                customerName, createdDateTime.toString(), trackingNumberDetailsDto);
        return ResponseEntity.ok(trackingNumberDetailsDto);
    }
}
