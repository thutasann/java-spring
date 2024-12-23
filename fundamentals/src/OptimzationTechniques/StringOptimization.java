package OptimzationTechniques;

public class StringOptimization {
    /**
     * Using StringBuilder is more efficient than using + in loops because strings
     * are immutable.
     */
    public void StringBuilderUsage() {
        System.out.println("\n==> (Optimization) String Builder Usage");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append("Iteration ").append(i).append("\n");
        }
        System.out.println(builder.toString());
    }
}
