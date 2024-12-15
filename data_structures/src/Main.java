import Stacks.StackSamples;
import Stacks.UndoRedoManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Data structures and algorithms");

        StackSamples stackSamples = new StackSamples();
        stackSamples.SampleOne();

        UndoRedoManager undoRedo = new UndoRedoManager();
        undoRedo.SampleUsage();
    }
}