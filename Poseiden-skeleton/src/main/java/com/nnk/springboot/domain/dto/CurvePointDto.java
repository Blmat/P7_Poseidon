package com.nnk.springboot.domain.dto;

import com.nnk.springboot.validation.IsDecimal;
import com.nnk.springboot.validation.IsInteger;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CurvePointDto {

    // user interface functionality
    private Integer id;

    @IsInteger
    @NotNull(message = "must not be null")
    private String curveId;

    @IsDecimal
    private String term;

    @IsDecimal
    private String value;
}