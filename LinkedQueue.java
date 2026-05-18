import java.util.*;

public class LinkedQueue<E> implements QueueInterface<E> {
    private DoublyLinkedList<E> list;
    public LinkedQueue() {
        this.list = new DoublyLinkedList<>();
    }
    public void enqueue(E e) {
        if (e == null) {
            throw new NullPointerException();
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
            throw new NoSuchElementException();
        } else {
            E item = list.get(index);
            list.remove(item);
            return item;
        }
    }
    public E peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int size() {
        return list.getLength();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void removeAll() {
        this.list = new DoublyLinkedList<>();
    }
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
