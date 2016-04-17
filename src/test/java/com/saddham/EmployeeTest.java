package com.saddham;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by saddhamp on 8/3/16.
 */
public class EmployeeTest {
    private Validator validator;
    private Employee employee;
    Calendar calendar;

    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        employee = new Employee();
        employee.setFullName("Saddam Pathan");

        calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 3);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        employee.setLastWorkingDay(calendar);
    }

    @Test
    public void testFullNameLength(){
        employee.setFullName("");
        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee, EmployeeChecks.class);
        assertEquals (2, constraintViolations.size( ));
        Iterator<ConstraintViolation<Employee>> iterator = constraintViolations.iterator();
        String message = iterator.next().getMessage();
        System.out.println(message);
        message = iterator.next().getMessage();
        System.out.println(message);
    }

    @Test
    public void testValidEmployeeDetails(){
        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee, EmployeeChecks.class);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testLastWorkingDay(){
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        employee.setLastWorkingDay(calendar);
        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee, EmployeeChecks.class);
        assertEquals(1, constraintViolations.size());
        Iterator<ConstraintViolation<Employee>> iterator = constraintViolations.iterator();
        String message = iterator.next().getMessage();
        System.out.println(message);
    }

    @Test
    public void testContractor(){
        Contractor contractor = new Contractor();
        contractor.setFullName("Saad Pathan");
        contractor.setCompany("Pramati");
        Set<ConstraintViolation<Contractor>> constraintViolations = validator.validate(contractor);
        assertEquals(0, constraintViolations.size());
    }
}