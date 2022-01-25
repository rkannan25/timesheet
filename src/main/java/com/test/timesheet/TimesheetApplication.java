package com.test.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;

@SpringBootApplication
public class TimesheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

	@Bean
	List<Employee> employees() {
		List<String> names = List.of("Liam", "Noah",  "Oliver",  "Elijah",  "William",  "James",  "Benjamin",  "Lucas",  "Henry",  "Alexander",  "Mason", "Michael",  "Ethan",  "Daniel",  "Jacob",  "Logan",  "Jackson",  "Levi",  "Sebastian",  "Mateo",  "Jack",  "Owen",  "Theodore",  "Aiden",  "Samuel",  "Joseph",  "John",  "David",  "Wyatt",  "Matthew");
		List<Employee> employees = new ArrayList<>();
		employees.addAll((IntStream.rangeClosed(1,10).mapToObj(id -> new HourlyEmployee(id, names.get(id-1))).collect(toList())));
		employees.addAll((IntStream.rangeClosed(11,20).mapToObj(id -> new SalariedEmployee(id, names.get(id-1))).collect(toList())));
		employees.addAll((IntStream.rangeClosed(21,30).mapToObj(id -> new ManagerEmployee(id, names.get(id-1))).collect(toList())));
		return employees;
	}
}
