package OptimzationTechniques;

import java.util.ArrayList;
import java.util.List;

public class CollectionOptimization {
    /**
     * Use the most appropriate collection type. For example, `ArrayList` is better
     * for sequential access, while `LinkedList` is better for frequent
     * insertions/removals.
     */
    public void ArrayListSample() {
        System.out.println("\n==> (Optimization) CollectionOptimization ArrayList");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("First Element : " + numbers.get(0));
    }
}
