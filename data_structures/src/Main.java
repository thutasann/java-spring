import Algorithms.SearchAlgorithms.SearchAlgorithmsUsages;
import DataStructures.DynamicArrays.DynamicArraySamples;
import DataStructures.LinkedList.LinkedListSamples;
import DataStructures.Queues.PriorityQueueSamples;
import DataStructures.Queues.QueueSamples;
import DataStructures.Stacks.StackSamples;
import DataStructures.Stacks.UndoRedoManager;

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

        // ------- Search Algorithms
        SearchAlgorithmsUsages searchAlgorithmsUsages = new SearchAlgorithmsUsages();
        searchAlgorithmsUsages.linearSearchUsage();
        searchAlgorithmsUsages.binarySearchUsage();
        searchAlgorithmsUsages.interpolationSearchUsage();
    }
}