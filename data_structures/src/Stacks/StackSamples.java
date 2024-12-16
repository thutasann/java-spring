package Stacks;

import java.util.Stack;

public class StackSamples {
    /**
     * Stack Sample One
     * @apiNote - This is stack sample usage one
     */
    public void SampleOne() {
        System.out.println("\n===> Stack Sample One");
        Stack<String> stack = new Stack<String>();

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Borderlands");

        String myFavGame = stack.pop();

        System.out.println(stack);

        System.out.println("My Fav Game --> " + myFavGame);

        System.out.println(stack.peek());

        System.out.println("Search value --> " + stack.search("Skyrim"));

        for (int i = 0; i < 10000; i++) {
            stack.push("Fallout76");
        }
    }
}