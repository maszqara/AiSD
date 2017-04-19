import Kolejka.Element;
import Kolejka.Queue;

public class zad1 {
    public static void main(String[] args) {
        Queue kol = new Queue();
        for (int i=0;i<20;i++)
            { Element a = new Element(i);
            kol.enqueue(a);}
       System.out.println(kol);
        System.out.println(kol.size());
        System.out.println();
        kol.dequeue();
        kol.dequeue();
        kol.dequeue();
        kol.enqueue(5);
        System.out.println(kol);
        System.out.println(kol.size());
        kol.clear();
        System.out.println(kol);
        System.out.println(kol.size());
        kol.enqueue(5);
        System.out.println(kol);
        System.out.println(kol.size());
    }
}
