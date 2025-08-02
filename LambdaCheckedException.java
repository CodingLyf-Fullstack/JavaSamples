package com.example.demo.streams;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Custom functional interface to allow throwing checked exceptions from lambdas
@FunctionalInterface
interface ThrowPredicate<T> {
    boolean test(T t) throws Exception;
}

public class LambdaCheckedException {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);

        // We're filtering the list using a lambda that calls a method which can throw IOException
        // Since Java lambdas don't allow checked exceptions directly, we wrap it using throwPredicateMapper
        System.out.println(
            integers.stream()
                .filter(throwPredicateMapper(i -> writeToFile(i)))  // wrapping checked-exception-throwing logic
                .collect(Collectors.toList()) // collect the filtered values into a list
        );
    }

    /**
     * Simulated method that throws IOException for specific input (i == 3)
     * Pretend this writes to a file and can fail
     */
    private static boolean writeToFile(Integer i) throws IOException {
        if (i == 3) {
            throw new IOException("Failed to write: " + i);
        }
        return true; // For all other numbers, "write" is successful
    }

    /**
     * This method wraps a ThrowPredicate (which can throw checked exceptions)
     * into a standard Predicate that handles exceptions internally.
     * Useful when working with streams that expect regular functional interfaces.
     */
    static <T> Predicate<T> throwPredicateMapper(ThrowPredicate<T> t) {
        return i -> {
            try {
                return t.test(i);  // Execute original logic
            } catch (Exception e) {
                // Catch checked exceptions and handle/log them here
                System.err.println("Exception occurred: " + e.getMessage());
                return false;  // If exception occurs, filter this element out
            }
        };
    }
}

