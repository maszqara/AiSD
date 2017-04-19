/**
 * Created by magdalenamazur on 02.04.2017.
 */
public class Kolejka {
    protected  Object[] e;
    protected int first,last,size;

    public Kolejka(int s){
        e = new Object[s];
        size = 0;
        first=0;
        last=0;

    }

    public void enqueue(Object obiekt){
        if (size()==e.length){
            System.out.println("Kolejka pełna!");
            throw new FullQueueException();
        }
        else {
            e[last]=obiekt;
            last++;
            size++;}

    }
    public Object dequeue() throws EmptyQueueException {
        if(size()!=0)
        {
            Object temp=e[0];
            for(int i=1;i <=last-1;i++){
                e[i-1]=e[i];
            }
            //e[last-1]=null;
            last--;
            size--;
            return temp;
        }
        else System.out.println("Kolejka pusta!");
        throw new EmptyQueueException();

    }
    public void clear() {
        while (size()!=0){
            dequeue();
        }
        System.out.println("Bufor pusty!");
    }

    public int size() {
        return size;
    }

    public void all() {
        for (int i = 0; i <= size()-1; i++)
            System.out.print(e[i] + " ");
        System.out.println();
    }


    public static void main(String[] args){
        Kolejka kol = new Kolejka(10);
        for (int i =1;i<=10;i++)
        { kol.enqueue(i);}
        kol.all();
        kol.dequeue();
        kol.all();
        kol.dequeue();
        kol.all();
        kol.enqueue(6);
        kol.all();
        kol.dequeue();
        kol.all();
        System.out.println(kol.size());
        kol.clear();
        System.out.println(kol.size());

    }
}
