package DataStructures.LinkedList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListSamples {
    public void SinglyLinkedList() {
        System.out.println("\n===> Singly Linked List");
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("F");
        linkedList.pop();

        System.out.println(linkedList);
    }

    public void OfferPollSample() {
        System.out.println("\n===> Offer Poll Sample");
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");
        linkedList.add(4, "E");
        System.out.println("Peek First --> " + linkedList.peekFirst());
        System.out.println("Index of F --> " + linkedList.indexOf("F"));
        System.out.println(linkedList);
    }

    public void BrowserHistorySample() {
        System.out.println("\n===> Browser History Sample");

        BrowserHistory browser = new BrowserHistory();
        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.back();
        browser.back();
        browser.forward();
    }

    public void TaskSchedulerSample() {
        System.out.println("\n===> TaskScheduler Sample");
        Queue<String> taskQueue = new LinkedList<>(); // FIFO

        taskQueue.offer("Task 1: Email Report");
        taskQueue.offer("Task 2: Generate Invoice");
        taskQueue.offer("Task 3: Backup Database");

        // proceeding tasks
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();
            System.out.println("Processing: " + task);
        }
    }

    public void PlayListManager() {
        System.out.println("\n===> Music Playlist Manager Sample");

        LinkedList<String> playlist = new LinkedList<>();

        playlist.add("Song 1: Imagine");
        playlist.add("Song 2: Let It Be");
        playlist.add("Song 3: Bohemian Rhapsody");

        for (String song : playlist) {
            System.out.println("now playing " + song);
        }

        playlist.addFirst("Song 0: Stairway to Heaven");
        System.out.println("Updated Playlist: " + playlist);

        playlist.removeLast();
        System.out.println("After removing Last song : " + playlist);
    }

    public void RealTimeDequeImplementation() {
        System.out.println("\n===> Real time Deque Sample");
        Deque<String> messages = new LinkedList<>();

        messages.addLast("User1: Hi there!");
        messages.addLast("User2: Hello!");
        messages.addLast("User1: How are you?");

        System.out.println("Chat History:");
        for (String message : messages) {
            System.out.println(message);
        }

        messages.removeFirst();
        System.out.println("After Removing Oldest Message: " + messages);
    }
}
