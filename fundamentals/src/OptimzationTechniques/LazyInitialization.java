package OptimzationTechniques;

public class LazyInitialization {
    private class ExpensiveResource {
        public ExpensiveResource() {
            System.out.println("Expensive resource created!");
        }
    }

    private ExpensiveResource resource;

    private ExpensiveResource getResource() {
        if (resource == null) {
            resource = new ExpensiveResource();
        }
        return resource;
    }

    /**
     * Defer object creation until it’s actually needed.
     */
    public void LazyInitializationSampleOne() {
        System.out.println("\n==> LazyInitialization Before accessing resource");
        getResource();
    }
}
