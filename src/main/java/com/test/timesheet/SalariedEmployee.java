package com.test.timesheet;

public class SalariedEmployee extends Employee{
    public SalariedEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    double getMaxVacationDaysLimit() {
        return 15;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.SALARIED;
    }
}
