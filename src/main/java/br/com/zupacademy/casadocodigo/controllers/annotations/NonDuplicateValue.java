package br.com.zupacademy.casadocodigo.controllers.annotations;

import br.com.zupacademy.casadocodigo.controllers.annotations.validatorImpl.NonDuplicateValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {NonDuplicateValueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface NonDuplicateValue {

    String message() default "O valor informado já existe!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();


}
