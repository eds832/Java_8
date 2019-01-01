package com.epam.cdp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.epam.cdp.beans.Department;
import com.epam.cdp.beans.Employee;
import com.epam.cdp.domain.Developer;

public class Main7 {

	public static void main(String[] args) {
		Map<String, Integer> backenderSkills = new HashMap<>();
		backenderSkills.put("Java", 4);
		backenderSkills.put("Scala", 3);
		backenderSkills.put("Kotlin", 1);
		Developer backender = new Developer("Petja", backenderSkills);

		Map<String, Integer> frontenderSkills = new HashMap<>();
		frontenderSkills.put("React", 90);
		frontenderSkills.put("Angular", 80);
		frontenderSkills.put("Kotlin", 4);
		Developer front = new Developer("Vasja", frontenderSkills);

		ArrayList<Developer> projectTeam = new ArrayList<>();
		projectTeam.add(backender);
		projectTeam.add(front);

		List<String> result = projectTeam.stream().map(Developer::getSkillMatrix).map(Map<String, Integer>::entrySet)
				.flatMap(set -> set.stream()).peek(System.out::println).filter(item -> item.getValue() > 3)
				.map(Map.Entry<String, Integer>::getKey).distinct().collect(Collectors.toList());
		System.out.println(result);

		Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7);
		// System.out.println("Sum = " + ints.mapToInt(i -> i).sum());
		// System.out.println("Sum = " + ints.reduce(0, Integer::sum));
		System.out.println("Sum = " + ints.collect(Collectors.summingInt(Integer::intValue)));

		List<Employee> employees = Main5.hireEmployees();
		Map<String, Department> resultMap = employees.stream().filter(e -> e.getAge() > 30)
				.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
		System.out.println(resultMap);
		String delimetedNames = employees.stream().map(Employee::getName).collect(Collectors.joining(",\n"));
		System.out.println(delimetedNames);

		System.out.println(employees.stream().map(Employee::getDepartment)
				.collect(Collectors.maxBy(Comparator.comparing(Department::getName))));

		Map<Department, Long> res = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(res);
		Map<Department, String> rest = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment,
				Collectors.mapping(Employee::getSkill, Collectors.joining(" & "))));
		
		System.out.println(rest);
	}

}
