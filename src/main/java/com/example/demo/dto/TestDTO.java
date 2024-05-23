package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestDTO {

    @Min(value = 0, message = "code must be greater than 0")
    @Max(value = 100, message = "code must not be greater than 100")
    @NotNull(message = "code must not be null")
    private Long code;

    @NotEmpty(message = "detail must not be null nor empty")
    private String detail;

}