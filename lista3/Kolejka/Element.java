package Kolejka;

public class Element
{
    public Object obiekt;
    Element next;

    public Element(Object obiekt){
        this.obiekt=obiekt;
        next=null;
    }
    public String toString() {
        return String.format("%s", this.obiekt.toString());
    }
}