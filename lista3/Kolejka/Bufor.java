package Kolejka;


public class Bufor implements Kolejka {
    protected  Object[] e;
    protected int first,last,size;

    public Bufor(int s) {
        e = new Object[s];
        size = 0;
        first=0;
        last=0;

    }
    public void enqueue(Object obiekt){
       if (isFull()){
            System.out.println("Bufor pełny!");
        }
        else {
        e[last%e.length]=obiekt;
        last++;
        size++;}

    }

    public Object dequeue() throws EmptyQueueException {
        if(!isEmpty())
        {
            Object temp=e[first];
            e[first]= null;
            first=(first+1)%e.length;
            size--;
            return temp;
        }
      else System.out.println("Bufor pusty!");
        throw new EmptyQueueException();

    }

    public void clear() {
        while (!isEmpty()){
            dequeue();
        }
        System.out.println("Bufor pusty!");
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return (size()==0);
    }

    public boolean isFull() {
        return (size() == e.length);
    }

    public void all() {
        if (first > 0)
        { for (int i = first; i < e.length; i++)
                System.out.print(e[i] + " ");
        for (int k = 0; k < first; k++)
            System.out.print(e[k] + " ");
        System.out.println();}

        else for (int i = first; i < e.length; i++)
            System.out.print(e[i] + " ");
        System.out.println();
    }
}
