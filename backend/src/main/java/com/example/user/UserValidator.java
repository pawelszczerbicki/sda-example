package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.example.config.Keys.*;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", LOGIN_EMPTY);
        User u = (User) target;

        if (!isEmpty(u.getUsername()) && userService.userExistsByUsername(u.getUsername()))
            errors.rejectValue("username", LOGIN_EXISTS);

        if (u.getPassword() != null && u.getPassword().length() <= 3)
            errors.reject(PASSWORD_TOO_SHORT);

    }
}
