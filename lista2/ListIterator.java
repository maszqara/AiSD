
public class ListIterator implements Iterator {

    private Element current;
    private LinkedList list;


    public ListIterator (LinkedList list)
    {
        this.list=list;
    }

    public void previous() {
    }

    public void next()
    {
        this.current = current.getNext();
    }

    public void first()
    {
        this.current=this.list.getElement(0);
    }

    public void last()
    {
        this.current=this.list.getElement(list.size()-1);
    }

    public boolean isDone()
    {
        return this.current==null;
    }

    public Element current() throws IndexOutOfBoundsException {
        if (isDone())
            throw new IndexOutOfBoundsException();
        return this.current;
    }
}

