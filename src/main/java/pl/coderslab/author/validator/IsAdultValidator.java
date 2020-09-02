package pl.coderslab.author.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsAdultValidator implements ConstraintValidator<IsAdult, Integer> {
    @Override
    public void initialize(IsAdult constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().getYear() - 18 >= integer && integer != 0;
    }
}
