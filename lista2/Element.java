/**
 * Created by magdalenamazur on 16.03.2017.
 */
class Element {
    private Object value;
    private Element next,previous;
    //previous używane tylko dla listy podwójnie wiązanej

    Element(Object value){
        setValue(value);
    }

    void setValue(Object value) {
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

    //dla listy podwójnie wiązanej

    Element getPrevious() { return this.previous;}

    void dSetPrevious(Element previous) {
        assert previous != null : "Wskaźnik na element poprzedni nie może być pusty";
        this.previous = previous;
    }

    void dSetNext(Element next){
        assert next != null : "Wskaźnik na element poprzedni nie może być pusty";
        this.next = next;
    }

    void attachBefore(Element next) {
        Element previous = next.getPrevious();
        dSetNext(next);
        dSetPrevious(previous);
        next.dSetPrevious(this);
        previous.dSetNext(this);
    }
    void detach() {
        this.previous.dSetNext(this.next);
        this.next.dSetPrevious(this.previous);
    }
    public String toString() {
        return String.format("%s", this.value.toString());
    }
}


