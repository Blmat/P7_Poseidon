package com.nnk.springboot.domain.dto;

import com.nnk.springboot.validation.IsDecimal;
import com.nnk.springboot.validation.IsInteger;
import lombok.Data;

@Data
public class CurvePointDto {

    // user interface functionality

    private Integer id;

    @IsInteger
    private String curveId;

    @IsDecimal
    private String term;

    @IsDecimal
    private String value;
}