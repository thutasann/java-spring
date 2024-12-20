import LinkedList.LinkedListSamples;
import Queues.PriorityQueueSamples;
import Queues.QueueSamples;
import Stacks.StackSamples;
import Stacks.UndoRedoManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Data structures and algorithms");

        StackSamples stackSamples = new StackSamples();
        stackSamples.SampleOne();

        UndoRedoManager undoRedo = new UndoRedoManager();
        undoRedo.SampleUsage();

        QueueSamples queueSamples = new QueueSamples();
        queueSamples.SampleOne();

        PriorityQueueSamples priorityQueueSamples = new PriorityQueueSamples();
        priorityQueueSamples.SampleOne();

        LinkedListSamples linkedListSamples = new LinkedListSamples();
        linkedListSamples.SinglyLinkedList();
        linkedListSamples.OfferPollSample();
        linkedListSamples.BrowserHistorySample();
    }
}