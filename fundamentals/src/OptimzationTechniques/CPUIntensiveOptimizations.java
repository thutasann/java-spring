package OptimzationTechniques;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class CPUIntensiveOptimizations {
    /**
     * For CPU-intensive tasks, leverage multi-core processors with parallel
     * streams.
     */
    public void ParallelStreamOptimization() {
        System.out.println("\n==> (Optimization) ParallelStreamOptimization Sample");
        long sum = IntStream.range(1, 1_000_000).parallel().sum();
        System.out.println("Sum : " + sum);
    }

    /**
     * Avoid unnecessary synchronization in multithreaded code by using concurrent
     * collections.
     */
    public void ConcurrentCollectionOptimization() {
        System.out.println("\n==> (Optimization) ConcurrentCollectionOptimization Sample");
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key", "value");
        System.out.println(map.get("key"));
    }
}
