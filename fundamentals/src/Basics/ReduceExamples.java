package Basics;

import java.util.Arrays;
import java.util.List;

class CartItem {
    String name;
    double price;

    public CartItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

/**
 * Reduce Method Examples
 */
public class ReduceExamples {
    public static void main(String[] args) {
        SumSample();
        StringConcatExample();
        MaxValueSample();
        GetTotalPriceFromCart();
        CharacterCount();
    }

    public static void SumSample() {
        System.out.println("\n==> Reduce Sample One");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum --> " + sum);
    }

    public static void StringConcatExample() {
        System.out.println("\n==> String Concat Sample One");
        List<String> words = Arrays.asList("Java", "is", "fun");
        String result = words.stream().reduce("", (a, b) -> a + " " + b);
        System.out.println("result --> " + result);
    }

    public static void MaxValueSample() {
        System.out.println("\n==> Maximum value sample");
        List<Integer> numbers = Arrays.asList(5, 12, 18, 19, 2, 22, 3, 88, 3);
        int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("max --> " + max);
    }

    public static void GetTotalPriceFromCart() {
        System.out.println("\n==> Get Total Price from Cart");
        List<CartItem> cart = Arrays.asList(
                new CartItem("Book", 12.99),
                new CartItem("Pen", 1.50),
                new CartItem("Notebook", 4.99));

        double totalPrice = cart
                .stream()
                .map(item -> item.price)
                .reduce(0.0, Double::sum);
        System.out.println("total price --> " + totalPrice);
    }

    public static void CharacterCount() {
        System.out.println("\n==> CharacterCount");
        String text = "hello world";
        char target = 'l';

        long count = text.chars().mapToObj(c -> (char) c).filter(c -> c == target).count();
        System.out.println("Occurrences of '" + target + "': " + count);
    }

}
