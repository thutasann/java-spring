package OptimzationTechniques;

import java.util.HashMap;
import java.util.Map;

public class CachingOptimization {
    private final Map<Integer, Integer> cache = new HashMap<>();

    private int factorial(int n) {
        if (n <= 1)
            return n;
        if (cache.containsKey(n))
            return cache.get(n);
        int result = n * factorial(n - 1);
        cache.put(n, result);
        return result;
    }

    public void FactorialSample() {
        System.out.println("\n==> (Optimization) FactorialSample");
        System.out.println(factorial(5));
        System.out.println(factorial(6));
        System.out.println(factorial(5));
    }
}
