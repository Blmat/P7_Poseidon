package com.nnk.springboot.domain.dto;

import com.nnk.springboot.validation.IsDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class BidDto {

	// user interface functionality

	private Integer id;

	@NotBlank(message = "Account is mandatory")
	private String account;

	@NotBlank(message = "Type is mandatory")
	private String type;

	@IsDecimal
	private String bidQuantity;
}
