package com.test.timesheet;

public abstract class Employee {
    private static final Integer MAX_WORK_DAY_LIMIT = 260;
    private int noOfWorkingDays;
    private double noOfVacationDays = 0.0;
    private int empId;
    private String name;

    public Employee() {
    }

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract double getMaxVacationDaysLimit();
    public abstract EmployeeType getEmployeeType();

    public Employee work(int workDays) throws EmployeeException {
        if(workDays > 0 && workDays <= (MAX_WORK_DAY_LIMIT - noOfVacationDays - noOfWorkingDays)){
            noOfWorkingDays = noOfWorkingDays + workDays;
            return this;
        }
            else
                throw new EmployeeException("Invalid Workdays");
    }

    public Employee takeVacation(double vacationDays) throws EmployeeException {
        if(vacationDays > 0.0 && vacationDays <= getMaxVacationDaysLimit() - noOfVacationDays) {
            noOfVacationDays = noOfVacationDays + vacationDays;
            return this;
        }
        else
            throw new EmployeeException("Invalid Vacation Days");
    }

    public int getNoOfWorkingDays() {
        return noOfWorkingDays;
    }

    public double getNoOfVacationDays() {
        return noOfVacationDays;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
