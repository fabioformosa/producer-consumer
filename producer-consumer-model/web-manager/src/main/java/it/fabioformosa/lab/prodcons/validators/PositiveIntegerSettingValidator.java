package it.fabioformosa.lab.prodcons.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class PositiveIntegerSettingValidator implements
		ConstraintValidator<PositiveIntegerSetting, Integer> {

	@Override
	public void initialize(PositiveIntegerSetting constraintAnnotation) {

	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value == null)
			return false;

		return value > 0;
	}

}
