import Basics.ArraySamples;
import Basics.Basics;
import Basics.CopyingObjectsSample;
import Basics.DateTimeSamples;
import Basics.LambdaExamples;
import Basics.MethodReferenceSamples;
import Basics.NestedObject;
import MemorizingSamples.MemorizingSamples;
import OptimzationTechniques.OptimizationTechniques;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Fundamentals");

        Basics basics = new Basics();
        basics.SwapVariables();
        basics.ForLoop();

        ArraySamples arraySamples = new ArraySamples();
        arraySamples.SampleOne();
        arraySamples.TwoDArrays();

        DateTimeSamples dateTimeSamples = new DateTimeSamples();
        dateTimeSamples.SamplesOne();

        CopyingObjectsSample copyingObjectsSample = new CopyingObjectsSample();
        copyingObjectsSample.SampleOne();

        MethodReferenceSamples methodReferenceSamples = new MethodReferenceSamples();
        methodReferenceSamples.StaticMethodReference();
        methodReferenceSamples.InstanceMethodReference();
        methodReferenceSamples.ArbitraryObjectMethodReferenceExample();

        LambdaExamples lambdaExamples = new LambdaExamples();
        lambdaExamples.SampleOne();
        lambdaExamples.MultipleParams();
        lambdaExamples.LambdaInLoop();
        lambdaExamples.CustomFunctionInterface();

        MemorizingSamples memorizingSamples = new MemorizingSamples();
        memorizingSamples.InMemoryCacheSample();
        memorizingSamples.ObjectPoolSample();
        memorizingSamples.LRUCacheSample();
        memorizingSamples.ReferenceCounterSample();
        memorizingSamples.WeakReferenceExample();

        NestedObject nestedObject = new NestedObject();
        nestedObject.SampleOne();

        OptimizationTechniques optimizationTechniques = new OptimizationTechniques();
        optimizationTechniques.Techniques();
    }
}