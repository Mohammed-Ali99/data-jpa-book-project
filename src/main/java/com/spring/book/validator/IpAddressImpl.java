package com.spring.book.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressImpl implements ConstraintValidator<IpAddress , String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.isEmpty() || s == null) {
            return true;
        }

        Pattern pattern = Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
        Matcher matcher = pattern.matcher(s);
        try {
            if(!matcher.matches()) {
                return false;
            } else {
                for(int i = 0 ; i <= 4 ; ++i) {
                    int octet = Integer.valueOf(matcher.group(i));
                    if(octet > 255) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
