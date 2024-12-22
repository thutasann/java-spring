import DynamicArrays.DynamicArraySamples;
import LinkedList.LinkedListSamples;
import Queues.PriorityQueueSamples;
import Queues.QueueSamples;
import Stacks.StackSamples;
import Stacks.UndoRedoManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Data structures and algorithms");

        // ------- Stacks
        StackSamples stackSamples = new StackSamples();
        stackSamples.SampleOne();
        UndoRedoManager undoRedo = new UndoRedoManager();
        undoRedo.SampleUsage();

        // ------- Queue / Priority Queue
        QueueSamples queueSamples = new QueueSamples();
        queueSamples.SampleOne();
        PriorityQueueSamples priorityQueueSamples = new PriorityQueueSamples();
        priorityQueueSamples.SampleOne();

        // ------- LinkedList
        LinkedListSamples linkedListSamples = new LinkedListSamples();
        linkedListSamples.SinglyLinkedList();
        linkedListSamples.OfferPollSample();
        linkedListSamples.BrowserHistorySample();
        linkedListSamples.TaskSchedulerSample();
        linkedListSamples.PlayListManager();
        linkedListSamples.RealTimeDequeImplementation();

        // ------- Dynamic Arrays
        DynamicArraySamples dynamicArraySamples = new DynamicArraySamples();
        dynamicArraySamples.SampleOne();
    }
}