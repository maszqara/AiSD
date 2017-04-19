package Kolejka;

public class Queue implements Kolejka {
    public int size = 0;
    private Element first,last;
    public void enqueue(Object obiekt) {
        Element nowy = new Element(obiekt);
        if (this.first == null) {
            this.first = nowy;
        }
        else{this.last.next = nowy;}
        this.last = nowy;
        size++;
    }

    public Object dequeue() throws EmptyQueueException {
        if(this.first == null){throw new EmptyQueueException();}
        Element temp = this.first;
        this.first= this.first.next;
        size--;
        return temp;
    }

    public void clear() {
        while (!this.isEmpty()){
            dequeue();
        }
        size=0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    public String toString () {
        String s = "";
        if (first != null) {
            Element current = this.first;
            while (current != null) {
                s +=String.format("%s ", current.obiekt.toString());
                current = current.next;
            }
        }
        return s;
    }

}
