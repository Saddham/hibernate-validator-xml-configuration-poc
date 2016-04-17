package com.saddham;

import java.util.Calendar;

/**
 * Created by saddhamp on 8/3/16.
 */
public class Employee {
    private Calendar lastWorkingDay;

    private String fullName;

    public Employee() {
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Calendar getLastWorkingDay() {
        return lastWorkingDay;
    }

    public void setLastWorkingDay(Calendar lastWorkingDay) {
        this.lastWorkingDay = lastWorkingDay;
    }

}
