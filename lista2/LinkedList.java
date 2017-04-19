

public class LinkedList implements List {
    int size;
    Element head;

    public LinkedList(){
        clear();
    }

    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException(); }

    public int size() {
        return this.size;
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if(this.size==0){
            this.head= new Element(value);
        }
        else if(index==0){
            Element tmp = new Element(value);
            tmp.setNext(this.head);
            this.head=tmp;
        }
        else{
            Element e = getElement(index-1);
            Element tmp = new Element(value);
            tmp.setNext(e.getNext());
            e.setNext(tmp);

        }

        this.size++;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
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

    public boolean remove(Object value) {
        if(contains(value)){
        delete(indexOf(value));
        return true;}
        else return false;
    }
    Element getElement(int index)throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
      Element e = this.head;
        for (int i = 0; i < index; ++i)
            e = e.getNext();
        return e;

    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
       return getElement(index).getValue();
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element e = getElement(index);
        Object oldValue = e.getValue();
        e.setValue(value);
        return oldValue;
    }

    public void add(Object value) {insert(this.size(),value);
    }

    public boolean contains(Object value) {

        Element e = head;
        while(e != null) {
            if (e.getValue().equals(value))
                return true;
            e = e.getNext();
        }
        return false;
    }

    public int indexOf(Object value) {
        int index = 0;
        Element e = head;
        while(e != null) {
            if (e.getValue().equals(value))
                return index;
            e = e.getNext();
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public void clear() {
        this.head=null;
        this.size=0;
    }


    public String toString(){
        String s = "";
        Element e = this.head;
        for (int i = 0; i < this.size - 1; ++i) {
            s += e.getValue() + ", ";
            e = e.getNext();
        }
        if (e != null) {
            s += e.getValue();
        }
        return s;
    }
}
