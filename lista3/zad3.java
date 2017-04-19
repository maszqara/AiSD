import Kolejka.Queue;
import Office.Client;
import Office.Worker;

import java.util.Random;

public class zad3 {

    public static void main(String[] args){
    int last = 0;
        int workTime=480;
        int breakTime=30;

        Queue clientQueue= new Queue();
        Worker a = new Worker(clientQueue, "A");
        Worker b = new Worker(clientQueue, "B");
        Worker c = new Worker(clientQueue, "C");

        while (workTime>0){
            if(workTime==240){
                System.out.println();
                System.out.println("Początek przerwy!");
            }
            if(workTime<240){
                while(breakTime!=0){
                    System.out.println("Przerwa potrwa jeszcze "+breakTime+" min");
                workTime++;
                breakTime--;}
            }
            for (int i = last;i<=last+new Random().nextInt(3);i++){
            if (new Random().nextInt(10)+1==9){
                Client k = new Client(last+1);
                clientQueue.enqueue(k);
                last++;
                }
             }
            a.work();
            b.work();
            c.work();
            workTime--;
            System.out.println("Ilośc osób w kolejce: "+clientQueue.size());
            System.out.println("Numer ostatniej osoby: "+last);
           // System.out.println(clientQueue.toString());
    }

        if (workTime==0){
            System.out.println("Koniec pracy urzędu!");
        }
   }
}
