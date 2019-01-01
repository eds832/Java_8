package com.epam.cdp;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main6 {

	public static void main(String[] args) {
		CalculatePerDiem machine = new CalculatePerDiem();
		Function<Integer,Double> curriedFirstArgument = machine.curryFirstArgument(56.16);
		System.out.println("For ten days: " + curriedFirstArgument.apply(10));
		
		Function<Double,Double> curriedSecondArgument = machine.currySecondArgument(5);
		System.out.println("For 30.77Rub course: " + curriedSecondArgument.apply(30.77));
	}	
}
@FunctionalInterface
/**
 * Каррирование — преобразование функции от многих аргументов в набор функций,
 * каждая из которых является функцией от одного аргумента
 */
interface curriedBiFunction<T, U, R> extends BiFunction<T, U, R> {
	default Function<U,R> curryFirstArgument(T t) {
		return u -> apply(t,u);
	}
	
	default Function<T,R> currySecondArgument(U u) {
		return t -> apply(t,u);
	}
}
class CalculatePerDiem implements curriedBiFunction<Double,Integer,Double> {
	private static final double perDiemRate = 10.15;
	@Override
	public Double apply(Double dollarExchangeRate, Integer amountOfDays) {		
		return dollarExchangeRate * amountOfDays * perDiemRate;
	}
	
}
