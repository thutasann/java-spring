package Basics;

public class OverloadedMethods {

    public void SampleOne() {
        int x = add(1, 2);
        System.out.println("x result " + x);
    }

    static int add(int a, int b){
        System.out.println("this is the overloaded method #1");
        return a + b;
    }

    static int add(int a, int b, int c){
        System.out.println("this is the overloaded method #2");
        return a + b + c;
    }

}
