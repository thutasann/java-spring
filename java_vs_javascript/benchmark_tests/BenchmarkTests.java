package java_vs_javascript.benchmark_tests;

public class BenchmarkTests {

    public static void main(String[] args) {
        BenchmarkTests.loopSample();
    }

    private static void loopSample() {
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
}
