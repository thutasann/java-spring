package OptimzationTechniques;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakOptimization {
    /**
     * Properly clean up resources, especially in collections with manual
     * management.
     */
    public void MemoryLeakAvoidance() {
        System.out.println("\n==> (Optimization) MemoryLeakAvoidance Sample");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Value " + i);
        }
        list.clear();
        System.out.println("list cleared --> " + list);
    }
}
