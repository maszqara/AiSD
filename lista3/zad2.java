import Kolejka.Bufor;

public class zad2 {
    public static void main(String[] args){
        Bufor buf = new Bufor(10);
        for (int i =1;i<=10;i++)
        { buf.enqueue(i);}
        buf.all();
        buf.dequeue();
        buf.all();
        buf.enqueue(6);
        buf.all();
        System.out.println(buf.size());
        buf.clear();
        System.out.println(buf.size());

    }
}
