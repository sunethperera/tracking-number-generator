package com.getrosoft.trackingnumbergenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrackingNumberDetailsDto {

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("created_at")
    private String createdDate;

}
