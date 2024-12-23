package OptimzationTechniques;

import java.lang.ref.WeakReference;
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

    /**
     * - Reuse objects instead of creating new ones repeatedly, especially for
     * immutable objects like String. if not optimized, High heap memory usage due
     * to redundant object creation.
     */
    public void ObjectReuse() {
        System.out.println("\n==> (Optimization) Object Reuse");
        String constant = "Hello"; // Reused from String pool
        String reusedString = constant; // Avoid creating new objects
        System.out.println(reusedString);
    }

    /**
     * Use weak references for objects that can be garbage collected if memory is
     * tight. If Not Optimized, Prevent objects from being garbage collected even if
     * they are no longer needed. Memory leaks in caches or listeners.
     */
    public void WeakReferenceOptimization() {
        System.out.println("\n==> (Optimization) WeakReferenceOptimization");
        WeakReference<String> weakRef = new WeakReference<String>(new String("Weak Reference"));
        System.out.println("Before GC: " + weakRef.get());
        System.gc();
        System.out.println("After GC: " + weakRef.get());
    }
}
