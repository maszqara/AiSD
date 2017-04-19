

public class LinkedList{

    private int size;
    private Element head;

    public LinkedList(){

        this.head= new Element(null);
        this.size=0;
    }

    public int size() {
        return this.size;
    }

    public int indexOf(Object value) {
        int index = 0;
        Element e = this.head.getNext();
        while(e != null) {
            if (e.getValue().equals(value))
                return index;
            e = e.getNext();
            index++;
        }
        return -1;
    }

    void remove(Object value) {
           if (indexOf(value) == 0) {
                    this.head.setNext(this.head.getNext().getNext());

                } else {
                    Element el = getElement(indexOf(value)-1);
                    el.setNext(el.getNext().getNext());
                }
        this.size--;
            }

    Element getElement(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        Element e = this.head.getNext();
        for (int i = 0; i < index; ++i)
            e = e.getNext();
        return e;
        }

    void addLast(Object value){
        if(this.size==0){
           Element tmp = new Element(value);
            tmp.setNext(this.head.getNext());
            this.head.setNext(tmp);
        }
        else{
        Element e = getElement(this.size()-1);
        Element tmp = new Element(value);
        tmp.setNext(e.getNext());
        e.setNext(tmp);}
        this.size++;
    }

    void addFirst(Object value){

        Element tmp = new Element(value);
        tmp.setNext(this.head.getNext());
        this.head.setNext(tmp);
        this.size++;

    }


    public String toString(){
        String s = "";
        Element e = this.head.getNext();
        for (int i = 0; i < this.size - 1; ++i) {
            s += e.getValue() + ", ";
            e = e.getNext();
        }
        if(e!=null){

            s+=e.getValue();
        }
        return s;
    }


}

class Element{

    private Object value;
    private Element next;


    Element(Object value){
        setValue(value);
    }

    private void setValue(Object value) {
        this.value = value;
    }


    Object getValue(){
        return this.value;
    }

    Element getNext(){
        return this.next;
    }

    void setNext(Element next){
        this.next=next;
    }

}


