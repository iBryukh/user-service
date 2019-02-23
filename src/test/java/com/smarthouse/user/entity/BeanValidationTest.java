package com.smarthouse.user.entity;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import static junit.framework.TestCase.assertEquals;

public class BeanValidationTest {

    private static final long id = 0;

    private static final String NAME = "name";
    private static final String correctName = "Name";
    private static final String incorrectName = "..BadName";

    private static final String USER_EMAIL = "email";
    private static final String correctEmail = "myEmail@domain.com";
    private static final String incorrectEmail = "incorrectEmail";

    private static final String USER_PHONE_NUMBER = "phoneNumber";
    private static final String correctPhoneNumber = "3349329";
    private static final String incorrectPhoneNumber = "";

    private static final String USER_PASSWORD = "password";
    private static final String correctPassword = "1234567890";
    private static final String incorrectPassword = "12345";

    private static final String ROLE_ACCESS_LEVEL = "accessLevel";
    private static final Integer correctAccessLevel = 0;
    private static final Integer incorrectAccessLevel = 10;


    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private static final Role correctRole = new Role(id, correctName, correctAccessLevel);
    private static final Role incorrectRole = new Role(id, incorrectName, incorrectAccessLevel);

    private static final Customer INCORRECT_CUSTOMER = new Customer(id, incorrectName, incorrectEmail, incorrectPhoneNumber, incorrectPassword, incorrectRole);
    private static final Customer CORRECT_CUSTOMER = new Customer(id, correctName, correctEmail, correctPhoneNumber, correctPassword, correctRole);

    // User validation

    @Test
    public void correctUserNameValidation() {
        assertEquals(
                0,
                validator.validate(CORRECT_CUSTOMER).stream()
                        .filter(it -> it.getPropertyPath().toString().equals(NAME))
                        .count()
        );
    }

    @Test
    public void incorrectUserNameValidation() {
        validator.validate(INCORRECT_CUSTOMER).stream()
                .filter(it -> it.getPropertyPath().toString().equals(NAME))
                .map(it -> it.getInvalidValue().toString())
                .forEach(name -> assertEquals(name, incorrectName));
    }

    @Test
    public void correctEmailValidation() {
        assertEquals(
                0,
                validator.validate(CORRECT_CUSTOMER).stream()
                        .filter(it -> it.getPropertyPath().toString().equals(USER_EMAIL))
                        .count()
        );
    }

    @Test
    public void incorrectEmailValidation() {
        validator.validate(INCORRECT_CUSTOMER).stream()
                .filter(it -> it.getPropertyPath().toString().equals(USER_EMAIL))
                .map(it -> it.getInvalidValue().toString())
                .forEach(name -> assertEquals(name, incorrectEmail));
    }

    @Test
    public void correctPhoneNumberValidation() {
        assertEquals(
                0,
                validator.validate(CORRECT_CUSTOMER).stream()
                        .filter(it -> it.getPropertyPath().toString().equals(USER_PHONE_NUMBER))
                        .count()
        );
    }

    @Test
    public void incorrectPhoneNumberValidation() {
        validator.validate(INCORRECT_CUSTOMER).stream()
                .filter(it -> it.getPropertyPath().toString().equals(USER_PHONE_NUMBER))
                .map(it -> it.getInvalidValue().toString())
                .forEach(name -> assertEquals(name, incorrectPhoneNumber));
    }

    @Test
    public void correctPasswordValidation() {
        assertEquals(
                0,
                validator.validate(CORRECT_CUSTOMER).stream()
                        .filter(it -> it.getPropertyPath().toString().equals(USER_PASSWORD))
                        .count()
        );
    }

    @Test
    public void incorrectPasswordValidation() {
        validator.validate(INCORRECT_CUSTOMER).stream()
                .filter(it -> it.getPropertyPath().toString().equals(USER_PASSWORD))
                .map(it -> it.getInvalidValue().toString())
                .forEach(name -> assertEquals(name, incorrectPassword));

    }

    // Role validation

    @Test
    public void correctRoleNameValidation() {
        assertEquals(
                0,
                validator.validate(correctRole).stream()
                        .filter(it -> it.getPropertyPath().toString().equals(NAME))
                        .count()
        );
    }

    @Test
    public void incorrectRoleNameValidation() {
        validator.validate(incorrectRole).stream()
                .filter(it -> it.getPropertyPath().toString().equals(NAME))
                .map(it -> it.getInvalidValue().toString())
                .forEach(name -> assertEquals(name, incorrectName));
    }

    @Test
    public void correctRoleAccessLevelValidation() {
        assertEquals(
                0,
                validator.validate(correctRole).stream()
                        .filter(it -> it.getPropertyPath().toString().equals(ROLE_ACCESS_LEVEL))
                        .count()
        );
    }

    @Test
    public void incorrectRoleAccessLevelValidation() {
        validator.validate(incorrectRole).stream()
                .filter(it -> it.getPropertyPath().toString().equals(ROLE_ACCESS_LEVEL))
                .map(ConstraintViolation::getInvalidValue)
                .forEach(value -> assertEquals(incorrectAccessLevel, value));
    }


}