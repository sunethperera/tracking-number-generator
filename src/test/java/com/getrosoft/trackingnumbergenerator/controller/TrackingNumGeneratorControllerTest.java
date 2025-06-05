package com.getrosoft.trackingnumbergenerator.controller;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TrackingNumGeneratorController.class)
public class TrackingNumGeneratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNextTrackingNumber_Success_Test() throws Exception {
        String url = "/next-tracking-number?" +
                "origin_country_id=MY" +
                "&destination_country_id=SL" +
                "&weight=1.234" +
                "&created_at=2018-11-20T19:28:32+08:00" +
                "&customer_id=de619854-b59b-425e-9db4-943979e1bd49" +
                "&customer_name=RedBox Logistics" +
                "&customer_slug=redbox-logistics";

        RequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    void getNextTrackingNumber_InvalidCountryId_Test() throws Exception {
        String url = "/next-tracking-number?" +
                "origin_country_id=Y" +
                "&destination_country_id=SL" +
                "&weight=1.234" +
                "&created_at=2018-11-20T19:28:32+08:00" +
                "&customer_id=de619854-b59b-425e-9db4-943979e1bd49" +
                "&customer_name=RedBox Logistics" +
                "&customer_slug=redbox-logistics";

        RequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(400, result.getResponse().getStatus());
    }
}
