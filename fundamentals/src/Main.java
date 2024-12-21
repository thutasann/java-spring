import Basics.ArraySamples;
import Basics.Basics;
import Basics.CopyingObjectsSample;
import Basics.DateTimeSamples;

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
    }
}