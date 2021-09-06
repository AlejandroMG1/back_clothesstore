package com.example.clothesstore.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DiscountValidator.class)
@Documented
public @interface DiscountConstrain {

    String message() default "discount invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
