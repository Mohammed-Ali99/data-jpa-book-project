package com.spring.book.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IpAddressImpl.class}
)
public @interface IpAddress {
    String message() default "{validation.constraints.ip-address.should be entered an valid ip address}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
