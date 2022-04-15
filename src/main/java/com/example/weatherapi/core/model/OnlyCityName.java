package com.example.weatherapi.core.model;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD,METHOD ,PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = { OnlyCityNameValidator.class })
public @interface OnlyCityName {

    String message() default "Şehir isimleri arasında bulunamadı";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
