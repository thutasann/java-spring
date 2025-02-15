package DataStructures.LinkedList;

import java.util.LinkedList;

/**
 * Browser History
 * 
 * @description
 *              - Stores the URLs visited. You can go back and forth using a
 *              doubly linked list.
 */
public class BrowserHistory {
    private LinkedList<String> history = new LinkedList<String>();
    private int currentIndex = -1;

    public void visit(String url) {
        while (history.size() > currentIndex + 1) {
            history.removeLast();
        }
        history.add(url);
        currentIndex++;
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (currentIndex > 0) {
            currentIndex--;
            System.out.println("Back to : " + history.get(currentIndex));
        } else {
            System.out.println("No previous page");
        }
    }

    public void forward() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            System.out.println("Forward to: " + history.get(currentIndex));
        } else {
            System.out.println("No next page");
        }
    }
}
