import java.util.*;

public class Container {

    private Node head;

    public Container() {
        head = new Node();
    }

    // O(1)
    // cannot check in constant time if a container is already connected
    // if I connect an already connected Container the circular list will be
    // separated
    public void connectTo(Container other) {
        other.head.prev.next = head;
        head.prev.next = other.head;
        other.head.prev = head.prev;
        head.prev = other.head.prev;
    }

    // O(1)
    public void addWater(double amount) {
        head.amount += amount;
    }

    // O(n)
    public double getAmount() {
        double total = head.amount;
        int size = 1;

        for (Node iter = head.next; iter != head; iter = iter.next) {
            total += iter.amount;
            size++;
        }

        return total / size;
    }

    private static class Node {
        Node next;
        Node prev;
        double amount;

        Node() {
            next = this;
            prev = this;
            amount = 0;
        }
    }

}
