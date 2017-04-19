/**
 * Created by magdalenamazur on 25.03.2017.
 */
public class DoubleLinked implements List {
    private int size;
     Element sentinel = new Element(null);//wartownik

    public DoubleLinked(){
        clear();
    }


    public int size() {
        return this.size;
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if (index<0 || index>this.size) throw new IndexOutOfBoundsException();
        Element e= new Element(value);
        e.attachBefore(getElement(index));
        ++this.size;

    }
    private Element getElement(int index) {
        return index< this.size/2 ? getElementForwards(index) : getElementBackwards(index);
    }
    private Element getElementForwards(int index) {// dojście do podanego indexu "w przód"
        Element e = this.sentinel.getNext();
        for (int i = index; i > 0; --i)
            e = e.getNext();
        return e;
    }
    private Element getElementBackwards(int index) {// dojście do podanego indexu "do tyłu"
        Element e = this.sentinel;
        for (int i = this.size - index; i > 0; --i)
            e = e.getPrevious();
        return e;
    }

    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException(); }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element e = getElement(index);
        e.detach();
        --this.size;
        return e.getValue();
    }

    public boolean remove(Object value) {
        if(contains(value)){
            delete(indexOf(value));
            return true;}
        else return false;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element e = getElement(index);
        Object oldValue = e.getValue();
        e.setValue(value); return oldValue;
    }

    public void add(Object value) {

        insert(this.size(),value);

    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public int indexOf(Object value) {
        int index = 0;
        Element e = this.sentinel.getNext();
        while( e != this.sentinel && !value.equals(e.getValue()))
        { e = e.getNext(); ++index; }
        return e!=this.sentinel ? index : -1;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public void clear() {
        this.sentinel.dSetPrevious(this.sentinel);
        this.sentinel.dSetNext(this.sentinel);
        this.size = 0;
    }
    public String toString(){
        String s = "";
        Element e = this.sentinel.getNext();
        for (int i = 0; i < this.size - 1; ++i) {
            s += e.getValue() + ", ";
            e = e.getNext();
        }
        if (e != null) {
            s += e.getValue();
        }
        return s;
    }
    //każda lista może zostać wstawiona do innej listy tylko raz!!!

    public void insertList(int index,DoubleLinked list){
        if (index<0 || index>this.size) throw new IndexOutOfBoundsException();
        Element first = list.sentinel.getNext();
        Element last = list.sentinel.getPrevious();
        Element next = this.getElement(index);
        Element prev = next.getPrevious();
        first.dSetPrevious(prev);
        prev.dSetNext(first);
        last.dSetNext(next);
        next.dSetPrevious(last);
        this.size+=list.size;

    }

    public void addList(DoubleLinked list){
        Element first = list.sentinel.getNext();
        Element last = list.sentinel.getPrevious();
        Element prev = this.sentinel.getPrevious();
        first.dSetPrevious(prev);
        prev.dSetNext(first);
        last.dSetNext(this.sentinel);
        this.sentinel.dSetPrevious(last);
        list.sentinel.detach();
        this.size+=list.size;

    }

    public void insertList(Object value,DoubleLinked list){
        //jesli bedzie wiecej niz jedno wystapienie to doda liste przed 1 znalezionym elementem
        insertList(indexOf(value),list);
        if (indexOf(value)==(this.size())){
            addList(list);
        }
    }
}
