package com.test.timesheet;

public class HourlyEmployee extends Employee{

    public HourlyEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    double getMaxVacationDaysLimit() {
        return 10;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.HOURLY;
    }
}
