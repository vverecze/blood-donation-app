package com.reaktorlabs.model;

import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Viki
 */
public class UserTest {
    private Validator validator;
    
    @Before
    public void init() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }
    
    @Test
    public void testTajLength() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@test.com");
        user.setBirthDate(LocalDate.MIN);
        user.setBloodType(BloodType.B);
        user.setRhType(RhType.POSITIVE);
        user.setGender(GenderType.FEMALE);
        user.setName("Test Endre");
        user.setWeight(60);
        user.setPassword("alma");
        user.setTaj("123456789112");
        
        final Set<ConstraintViolation<User>> violations = this.validator.validate(user);
        assertEquals("It should have 1 violaton.", 1, violations.size());
    }
}
