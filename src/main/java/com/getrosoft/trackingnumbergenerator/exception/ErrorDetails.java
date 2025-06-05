package com.getrosoft.trackingnumbergenerator.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime date;
    private String message;
    private String description;
}

