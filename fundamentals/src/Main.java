import Basics.ArraySamples;
import Basics.Basics;
import Basics.CopyingObjectsSample;
import Basics.DateTimeSamples;
import Basics.LambdaExamples;
import Basics.MethodReferenceSamples;

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
    }
}