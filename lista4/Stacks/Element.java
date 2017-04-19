package Stacks;

public class Element
{
    Object obiekt;
    Element next;
    Element(Object value){
        setValue(value);
    }

    void setValue(Object obiekt) {
        this.obiekt = obiekt;
    }

    Object getValue(){
        return this.obiekt;
    }
    Element getNext(){
        return this.next;
    }

    void setNext(Element next){
        this.next=next;
    }

    public String toString() {
        return String.format("%s", this.obiekt.toString());
    }
}