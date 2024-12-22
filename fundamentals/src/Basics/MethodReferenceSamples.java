package Basics;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceSamples {
    public void StaticMethodReference() {
        System.out.println("\n==> Static Method Reference");
        BiFunction<Integer, Integer, Integer> maxFunction = Math::max;
        int result = maxFunction.apply(10, 20);
        System.out.println("Max --> " + result);
    }

    public void InstanceMethodReference() {
        System.out.println("==> Instance Method Reference");
        Function<String, String> toLowerCaseFunction = String::toLowerCase;
        System.out.println("to Lower Caes --> " + toLowerCaseFunction.apply("JAVA"));
    }

    public void ArbitraryObjectMethodReferenceExample() {
        System.out.println("==> Arbitary Object Method Reference");
        String[] words = { "cherry", "apple", "banana", };
        Arrays.sort(words, String::compareToIgnoreCase);
        System.out.println("sorted array --> " + Arrays.toString(words));
    }
}
