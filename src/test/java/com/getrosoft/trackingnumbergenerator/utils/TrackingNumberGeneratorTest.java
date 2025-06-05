package com.getrosoft.trackingnumbergenerator.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrackingNumberGeneratorTest {

    @Mock
    private Map<String, String> trackingDetailsMockMap;

    @Test
    void generateTrackingNumberTest() {
        when(trackingDetailsMockMap.get("origin_country_id")).thenReturn("MY");
        when(trackingDetailsMockMap.get("created_at")).thenReturn("2018-11-20T19:29:32+08:00");
        when(trackingDetailsMockMap.get("customer_id")).thenReturn("de619854-b59b-425e-9db4-943979e1bd49");
        when(trackingDetailsMockMap.get("weight")).thenReturn("1.234");
        when(trackingDetailsMockMap.get("customer_slug")).thenReturn("redbox-logistics");
        when(trackingDetailsMockMap.get("destination_country_id")).thenReturn("ID");

        String trackingNumber = TrackingNumberGenerator.generateTrackingNumber(trackingDetailsMockMap);
        assertNotNull(trackingNumber);
        assertTrue(trackingNumber.matches("^[A-Z0-9]{1,16}$"));
    }
}
