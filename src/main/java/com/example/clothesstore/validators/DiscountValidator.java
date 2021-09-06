package com.example.clothesstore.validators;

import com.example.clothesstore.models.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DiscountValidator implements ConstraintValidator<DiscountConstrain, Product> {

    public void initialize(DiscountConstrain constraint) {
    }

    @Override
    public boolean isValid(Product value, ConstraintValidatorContext context){
        Double discount = value.getDiscount();
        String country = value.getCountry();
        String[] countries = new String[]{"Chile","Peru","Colombia","Mexico"};
        int index = -1;
        for (int i=0;i<countries.length;i++) {
            if (countries[i].equals(country)) {
                index = i;
                break;
            }
        }
        if(discount !=null){
            if(index <2){
                return discount < 30;
            }else {
                return discount < 50;
            }
        }
        return true;
    }

}
