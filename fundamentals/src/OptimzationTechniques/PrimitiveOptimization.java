package OptimzationTechniques;

public class PrimitiveOptimization {
    /**
     * Using primitive types like `int` instead of `Integer` reduces memory overhead
     * and avoids unnecessary boxing and unboxing.
     */
    public void intSample() {
        System.out.println("\n==> (Optimization) PrimitiveOptimization int");
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println("sum -> " + sum);
    }
}
