package com.test.timesheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private List<Employee> employees;

    @Autowired
    public EmployeeController(List<Employee> employees) {
        this.employees = employees;
    }

    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping(value = "/employee/{id}/work", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateWorkDays(@PathVariable("id") int id, @RequestParam("days") int days) {
        return employees.stream().filter(employee -> employee.getEmpId() == id)
                .findFirst().map(employee -> employee.work(days))
                .orElseThrow(() -> new EmployeeException(id + " not found"));
    }
    @GetMapping(value = "/employee/{id}/vacation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateVacationDays(@PathVariable("id") int id, @RequestParam("days") int days) {
        return employees.stream().filter(employee -> employee.getEmpId() == id)
                .findFirst().map(employee -> employee.takeVacation(days))
                .orElseThrow(() -> new EmployeeException(id + " not found"));
    }

}
