package com.test.timesheet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee;

    @BeforeEach
    public void setup() {
        employee = new HourlyEmployee(1, "test");
    }

    @Test
    void TestWorkHourlyEmployee() throws Exception{
        employee.work(5);
        assertEquals(5, employee.getNoOfWorkingDays());
    }
    @Test
    void TestWorkHourlyEmployeeMaxWorkDays() throws Exception{
        employee.work(260);
        assertEquals(260, employee.getNoOfWorkingDays());
    }

    @Test
    void TestWorkHourlyEmployeeExceedsMaxWorkDaysWithVacationDays() throws Exception{
        employee.takeVacation(10);
        assertThrowsExactly(EmployeeException.class, () -> employee.work(251));
    }

    @Test
    void TestWorkHourlyEmployeeMaxWorkDaysWithVacationDays() throws Exception{
        employee.takeVacation(10);
        employee.work(250);
        assertEquals(250, employee.getNoOfWorkingDays());
    }

    @Test
    void TestWorkHourlyEmployeeExceedsMaxWorkDays() throws Exception{
        assertThrowsExactly(EmployeeException.class, () -> employee.work(261));
    }

    @Test
    void TestWorkHourlyEmployeeNegativeValue() throws Exception{
        assertThrowsExactly(EmployeeException.class, () -> employee.work(-1));
    }

    @Test
    void testTakeVacationNegativeValue() {
        assertThrowsExactly(EmployeeException.class, () -> employee.takeVacation(-1));
    }

    @Test
    void testTakeVacationMaxOut() {
        assertThrowsExactly(EmployeeException.class, () -> employee.takeVacation(16));
    }

    @Test
    void testTakeVacation() throws Exception{
        employee.takeVacation(5.5);
        assertEquals(5.5, employee.getNoOfVacationDays());
    }
    @Test
    void testTakeVacationMaxOutFloatingPoint() throws Exception{
        employee.takeVacation(5);
        assertThrowsExactly(EmployeeException.class, () -> employee.takeVacation(10.1));
    }

    @Test
    void TestWorkHourlyEmployeeMaxWorkDaysWithVacationDaysFloatingPointValue() throws Exception{
        employee.takeVacation(5.5);
        assertThrowsExactly(EmployeeException.class, () -> employee.work(255));
    }
}