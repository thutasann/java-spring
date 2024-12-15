package Stacks;

import java.util.Stack;

public class UndoRedoManager {
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public UndoRedoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Perform a new action
    private void performAction(String action) {
        System.out.println("Performing: " + action);
        undoStack.push(action);
        redoStack.clear(); // Clear redo stack when a new action is performed
    }

    // Undo the last action
    private void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        String action = undoStack.pop();
        redoStack.push(action);
        System.out.println("Undone: " + action);
    }

    // Redo the last undone action
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }
        String action = redoStack.pop();
        undoStack.push(action);
        System.out.println("Redone: " + action);
    }

    /**
     * Undo Redo Sample Usage
     */
    public void SampleUsage() {
        System.out.println("\n===> Undo Redo Manager Sample Usage");
        UndoRedoManager manager = new UndoRedoManager();

        // Perform actions
        manager.performAction("Action 1");
        manager.performAction("Action 2");
        manager.performAction("Action 3");

        // Undo actions
        manager.undo();
        manager.undo();

        // Redo actions
        manager.redo();

        // Undo another action
        manager.undo();

        // Try redo
        manager.redo();
    }
}