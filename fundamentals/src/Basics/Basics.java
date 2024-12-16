package Basics;

import java.util.Random;

public class Basics {
    public void SwapVariables() {
        System.out.println("\n==> Swap Variables");

        String x = "water";
        String y = "Kool-aid";
        String temp;

        temp = x;
        x = y;
        y = temp;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }

    public void RandomNumber() {
        System.out.println("\n==> Random Number");

        Random random = new Random();
        int x = random.nextInt();
        System.out.println(x);
    }

    public void ForLoop() {
        System.out.println("\n==> For Loop ");

        for (int i = 5; i >= 0; i--) {
            System.out.println(i);
        }

        System.out.println("Happy New Year....");
    }
}
