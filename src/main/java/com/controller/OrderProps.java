package com.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Data
@Validated
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "taco.order")
public class OrderProps {
    @Max(value = 25, message = "must be between 5 and 25")
    @Min(value = 5, message = "must be between 5 and 25")
    private int pageSize = 20;
}
