package it.fabioformosa.lab.prodcons.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositiveIntegerSettingValidator.class)
@Documented
public @interface PositiveIntegerSetting {

	Class<?>[] groups() default {};

	String message() default "Ammessi solo valori positivi";

	Class<? extends Payload>[] payload() default {};

}
