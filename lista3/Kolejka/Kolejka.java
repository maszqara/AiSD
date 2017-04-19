package Kolejka;

public interface Kolejka
{

    void enqueue(Object obiekt);
    Object dequeue() throws EmptyQueueException;
    void clear();
    int size();
    boolean isEmpty();

}

