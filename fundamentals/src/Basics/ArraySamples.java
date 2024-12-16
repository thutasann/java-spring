package Basics;

public class ArraySamples {
    public void SampleOne() {
        System.out.println("\n====> Array Sample One");
        String[] cars = {"Camaro", "Corvette", "Tesla"};
        cars[0] = "Mustang";
        System.out.println(cars[0]);
    }

    public void TwoDArrays() {
        System.out.println("\n====> TwoD Arrays");

        String[][] cars = {
            {"Camaro", "Corvette", "Silverado"}, 
            {"Mustang", "Ranger", "F-150"}
        };

        for (int i = 0; i < cars.length; i++) {
            System.out.println();
            for (int j = 0; j < cars[i].length; j++) {
                System.out.println(cars[i][j]+" ");
            }
        }
    }
}
