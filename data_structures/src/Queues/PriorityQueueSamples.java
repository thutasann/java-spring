package Queues;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 * - FIFO Data Structure that serves elements with the highest priorities first
 * - before elements with lower priority
 */
public class PriorityQueueSamples {
    public void SampleOne() {
        System.out.println("\n===> Priority Queue Sample One");

        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
