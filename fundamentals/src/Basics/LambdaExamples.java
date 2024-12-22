package Basics;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
interface Greeting {
    void SayHello(String message);
}

public class LambdaExamples {
    public void SampleOne() {
        System.out.println("\n==> Lambda Example One");
        Consumer<String> printMessage = message -> System.out.println(message);
        printMessage.accept("Hello, Lambda!");
    }

    public void MultipleParams() {
        System.out.println("==> Lambda Multiple params");
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(10, 20));
    }

    public void NoParams() {
        System.out.println("==> Lambda No params");
        Supplier<String> greet = () -> "Hello No Param";
        System.out.println("No param --> " + greet.get());
    }

    public void LambdaInLoop() {
        System.out.println("==> Lambda In Loop");
        Arrays.asList("apple", "banana", "cherry").forEach(item -> System.out.println(item));
    }

    public void CustomFunctionInterface() {
        System.out.println("==> Lambda Custom Function Interface");
        Greeting greet = name -> System.out.println("Hello, " + name);
        greet.SayHello("Thuta Sann");
    }
}
