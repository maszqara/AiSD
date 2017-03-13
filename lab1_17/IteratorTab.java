
public class IteratorTab implements Iterator
{
    private Object [] tab;
    private int pierwszy;
    private int ostatni;
    private int biez;

    public IteratorTab(Object [] tablica)
    {
        tab = tablica;
        pierwszy=0;
        ostatni=tab.length-1;
    }

    public IteratorTab(Object [] tablica,int p, int iloscElem){

        tab = tablica;
        p = pierwszy;
        ostatni = p+iloscElem-1;

    }


    public void previous()
    {
        --biez;
    }


    public void next()
    {
        ++biez;
    }


    public void first()
    {
        biez=pierwszy;
    }


    public void last()
    {
        biez=ostatni;
    }


    public boolean isDone()
    {
        return biez < pierwszy || biez > ostatni;
    }


    public Object current()
    {
        return tab[biez];
    }
}
