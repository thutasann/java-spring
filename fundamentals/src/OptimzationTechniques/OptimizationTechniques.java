package OptimzationTechniques;

import OptimzationTechniques.Techniques.CachingOptimization;
import OptimzationTechniques.Techniques.CollectionOptimization;
import OptimzationTechniques.Techniques.PrimitiveOptimization;
import OptimzationTechniques.Techniques.StringOptimization;

/**
 * JAVA Optimization Techniques
 */
public class OptimizationTechniques {
    public void Techniques() {

        System.out.println("\n=========> JAVA Optimization Techniques");

        StringOptimization stringOptimization = new StringOptimization();
        stringOptimization.StringBuilderUsage();

        PrimitiveOptimization primitiveOptimization = new PrimitiveOptimization();
        primitiveOptimization.intSample();

        CollectionOptimization collectionOptimization = new CollectionOptimization();
        collectionOptimization.ArrayListSample();

        CachingOptimization cachingOptimization = new CachingOptimization();
        cachingOptimization.FactorialSample();
    }
}
