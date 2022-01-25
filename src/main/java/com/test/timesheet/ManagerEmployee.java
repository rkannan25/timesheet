package com.test.timesheet;

public class ManagerEmployee extends SalariedEmployee{
    public ManagerEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    double getMaxVacationDaysLimit() {
        return 30;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.MANAGER;
    }
}
