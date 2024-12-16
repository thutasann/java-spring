package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSamples {
    public void SampleOne() {
        System.out.println("\n===> Queue Sample One");
        Queue<String> queue = new LinkedList<String>(){};
        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("harold");
        System.out.println(queue.peek());

        queue.poll();

        System.out.println(queue);
    }
}