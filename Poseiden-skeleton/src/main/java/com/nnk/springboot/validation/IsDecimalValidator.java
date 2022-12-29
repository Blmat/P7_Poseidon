package com.nnk.springboot.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IsDecimalValidator implements ConstraintValidator<IsDecimal, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}

		Pattern numberPattern = Pattern.compile("-?[0-9][0-9\\.\\,]*");
		String numberValue = String.valueOf(value);
		return numberPattern.matcher(numberValue).matches();
	}

}