package java_vs_javascript.benchmark_tests;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BenchmarkTests {

    public static void main(String[] args) throws IOException {
        BenchmarkTests.IOIntensiveSample();
    }

    /**
     * JAVA wins
     * sum: 499999999500000000
     * Time: 353.422166 ms
     */
    public static void loopSample() {
        System.out.println("\n==> Loop Sample");
        long start = System.nanoTime();
        long sum = 0;
        for (long i = 0; i < 1_000_000_000; i++) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("sum: " + sum);
        System.out.println("Time: " + (end - start) / 1e6 + " ms");
    }

    /**
     * JAVA wins
     * Sum: 49999995000000
     * Time: 265.91675 ms
     */
    public static void memoryIntensiveSample() {
        System.out.println("\n==> Memory Intensive Sample");
        long start = System.nanoTime();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            numbers.add(i);
        }
        long sum = numbers.stream().mapToLong(Integer::longValue).sum();
        long end = System.nanoTime();
        System.out.println("Sum: " + sum);
        System.out.println("Time: " + (end - start) / 1e6 + " ms");
    }

    /**
     * Javascript wins
     * Time: 169.921708 ms
     */
    public static void IOIntensiveSample() throws IOException {
        System.out.println("\n==> IO Intensive Sample");
        File file = new File("largeFileJava.txt");
        long start = System.nanoTime();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 1_000_000; i++) {
                writer.write("This is a benchmark test.\n");
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
            }
        }

        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1e6 + " ms");

    }

}
