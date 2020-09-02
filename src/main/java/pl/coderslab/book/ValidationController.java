package pl.coderslab.book;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/book")
public class ValidationController {
    public final Validator validator;

    @RequestMapping("/validate")
    @ResponseBody
    public String validate() {
        Book book = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        }
        return "Walidacja formularza";
    }
}
