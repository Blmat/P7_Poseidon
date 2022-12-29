package com.nnk.springboot.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = IsIntegerValidator.class)
public @interface IsInteger {

	String message() default "Please enter an Integer";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
