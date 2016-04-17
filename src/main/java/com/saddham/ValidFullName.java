package com.saddham;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

/**
 * Created by saddhamp on 9/3/16.
 */

@Pattern(
        regexp = "^[a-z\\s]+$",
        flags = Pattern.Flag.CASE_INSENSITIVE,
        message = "{com.saddham.invalid.characters.message}",
        groups = EmployeeChecks.class
)
@Size(
        min = 1,
        max = 20,
        message = "{com.saddham.invalid.name.message}",
        groups = EmployeeChecks.class
)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidFullName {
    String message() default "{Employee name must be of minimum {min} character or maximum of {max} characters}";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
