package Stacks;


public class StosList implements Stos {
    private int size = 0;
    private Element head;

    public void push(Object value) {
        if(this.size==0){
            this.head= new Element(value);
        }
        else{
            Element e = getElement(this.size()-1);
            Element tmp = new Element(value);
            tmp.setNext(e.getNext());
            e.setNext(tmp);}
        this.size++;
    }
    Element getElement(int index)throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Element e = this.head;
        for (int i = 0; i < index; ++i)
            e = e.getNext();
        return e;

    }
    public Object delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Object ret;
        if (index == 0) {
            ret = this.head.getValue();
            this.head = this.head.getNext();
        } else {
            Element el = getElement(index-1);
            ret = el.getNext().getValue();
            el.setNext(el.getNext().getNext());
        }
        this.size--;
        return ret;
    }

    public Object pop() throws EmptyStackException {
        return delete(size()-1);

    }


    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public void clear() {
        while (!this.isEmpty()) {
            pop();
        }
        size = 0;
    }

    public String toString() {
        String s = "";
        if (head != null) {
            Element current = this.head;
            while (current != null) {
                s += String.format("%s ", current.obiekt.toString());
                current = current.next;
            }
        }
        return s;
    }
}
