package ScannerSamples;

import java.util.Scanner;

public class ScannerSamples {
    public static void main(String[] args) {
        System.out.println("====> Scanner Samples");

        // ScannerSamples.WhileLoop();
        ScannerSamples.NestedLoop();
    }

    public static void WhileLoop() {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = "";

            while (name.isEmpty()) {
                System.out.println("Enter your name: ");
                name = scanner.nextLine();
            }

            System.out.println("Hello : " + name);
        }
    }

    public static void NestedLoop() {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows;
            int columns;
            String symbol = "";

            System.out.println("Enter # of rows : ");
            rows = scanner.nextInt();

            System.out.println("Enter # of columns: ");
            columns = scanner.nextInt();

            System.out.println("Enter symbol to use : ");
            symbol = scanner.next();

            for (int i = 1; i <= rows; i++) {
                System.out.println();
                for (int j = 1; j <= columns; j++) {
                    System.out.print(symbol);
                }
                System.out.println();
            }
        }
    }
}


