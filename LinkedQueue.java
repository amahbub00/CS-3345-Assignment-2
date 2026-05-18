import java.util.*;

public class LinkedQueue<E> implements QueueInterface<E> {    // Based on the previous DoublyLinkedList.java file made in Assignment 1
    private DoublyLinkedList<E> list;
    public LinkedQueue() {
        this.list = new DoublyLinkedList<>();
    }
    public void enqueue(E e) {
        if (e == null) {
            throw new NullPointerException();    // Throws an exception if the program enqueues a null value
        } else {
            list.addLast(e);
        }
    }
    public E dequeue() {
        if (list.isEmpty()) {
            return null;
        } else {
            E item = list.get(0);
            list.remove(item);
            return item;
        }
        }
    public E dequeue(int index) {
        if (index < 0 || index >= size()) {
            throw new NoSuchElementException();    // Exception thrown in case the index dequeues out of bound
        } else {
            E item = list.get(index);
            list.remove(item);
            return item;
        }
    }
    public E peek() {    // Returns a specific index without removing or adding
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int size() {    // Returns length of the list
        return list.getLength();
    }
    public boolean isEmpty() {    // Checks if the list is empty or not
        return list.isEmpty();
    }
    public void removeAll() {    // Erases previous values with a fresh new list
        this.list = new DoublyLinkedList<>();
    }
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
