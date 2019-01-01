package com.epam.cdp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.epam.cdp.beans.Department;
import com.epam.cdp.beans.Employee;

public class Main5 {

	public static void main(String[] args) {
		Predicate<Integer> isPrime = number -> isEven(number);
		System.out.println("IsEven(2): " + isPrime.test(2));
		System.out.println("IsEven(3): " + isPrime.test(3));

		Consumer<String> messageVerification = 
				message -> System.out.println("Message length: " + message.length());
		messageVerification.accept("word");
		
		Function<String, Department> depConstructor = name -> new Department(name);
		Function<String, Department> depConstructor2 = Department::new;
		System.out.println(depConstructor.apply("New Dep"));

		System.out.println(depConstructor2.apply("New Dep2"));
		
		Supplier<Boolean> rand = () -> ThreadLocalRandom.current().nextBoolean();
		System.out.println("Random Boolean: " + rand.get());
		
		Function<Integer, Integer> addTwo = number -> number + 2;
		Arrays.asList(1,2,3,4,5,6,7).stream().map(addTwo).filter(isPrime).forEach(System.out::println);

		Function<Integer,Integer> multipleTen = e -> e * 10;
		List<Integer> fibonachiNumbers = Arrays.asList(1,1,2,3,5,8,13);
		fibonachiNumbers.stream().map(addTwo.andThen(multipleTen)).forEach(System.out::println);

		fibonachiNumbers.stream().map(multipleTen.compose(addTwo)).forEach(System.out::println);
		
		fibonachiNumbers.stream().map(customCompose(addTwo, multipleTen)).forEach(System.out::println);
		
		BiFunction<String, CharSequence, Boolean> contains = String::contains;
		System.out.println("Ya-ya contains ya: " + contains.apply("Ya-ya", "ya"));
		
		final DoubleUnaryOperator doubleU = Math::abs;
		System.out.println(doubleU.applyAsDouble(-3.3));
		
		Function<Department,String> getName = Department::getName;
		System.out.println(getName.apply(depConstructor.apply("New Dep3")));
		
		List<Employee> employees = hireEmployees();

		employees.stream().filter(e -> e.getLevel() > 2).map(Employee::getDepartment).distinct()
				.sorted(Comparator.comparing(Department::getName)).map(Department::getName)
				.forEach(System.out::println);

		System.out.println("Average age is " + employees.stream().mapToInt(Employee::getAge).average().getAsDouble());
		System.out.println("Summary statistics: " + employees.stream().mapToInt(Employee::getAge).summaryStatistics());
	}

	private static Function<Integer, Integer> customCompose(Function<Integer, Integer> addTwo, Function<Integer, Integer> multipleTen) {		
		return addTwo.andThen(multipleTen);
	}

	private static boolean isEven(Integer number) {
		boolean result = false;
		if (number % 2 == 0) {
			result = true;
		}
		return result;
	}

	static List<Employee> hireEmployees() {
		Department financialDepartment = new Department("Financial department");
		Department backendDepartment = new Department("Backend department");

		return Arrays.asList(new Employee(19, "Vasja", "Java", 1, financialDepartment),
				new Employee(38, "Johann", "Delphi", 3, backendDepartment),
				new Employee(20, "Petja", "Net", 3, financialDepartment),
				new Employee(45, "Sergey", "Java", 2, backendDepartment));
	}
}
