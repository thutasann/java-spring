package LinkedList;
import java.util.LinkedList;

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
}
