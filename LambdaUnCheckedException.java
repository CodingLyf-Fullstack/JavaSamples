package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaUnCheckedException {

	public static void main(String[] args) {
		// Sample list of integers
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);

		// We are trying to square each number and dividing with same number (To
		// generate exception) in the list using a lambda.
		// The lambda is passed through a wrapper that handles unchecked exceptions.
		// This helps prevent the stream from breaking if an ArithmeticException occurs.
		System.err.println(integers.stream().map(lambdaWrapper(a -> a * a)) // wrap the lambda with error handling
				.collect(Collectors.toList())); // collect the squared results into a list
	}

	/**
	 * This method wraps a lambda with a try-catch block to catch unchecked
	 * exceptions like ArithmeticException during stream processing.
	 *
	 * @param function the original lambda function that may throw an exception
	 * @return a safe version of the function that handles exceptions internally
	 */
	static Function<Integer, Integer> lambdaWrapper(Function<Integer, Integer> function) {
		return i -> {
			try {
				return function.apply(i); // apply the original lambda logic
			} catch (ArithmeticException e) {
				// Handle the unchecked exception gracefully
				System.err.println("Arithmetic Exception occurred: " + e.getMessage());
				return -1; // return a default value if exception occurs
			}
		};
	}
}
