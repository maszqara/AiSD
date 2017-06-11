import java.io.IOException;

public class zad4 {

    public static void main(String[] args) throws IOException {

        StackPriorityQueue<Student> studentKolejka = new StackPriorityQueue(new StudentComparator());
        StackPriorityQueue<Student> kolejka2 = new StackPriorityQueue(new StudentComparator());
        System.out.println();
        for (int i=0; i<10; i++){
            Student s =new Student();
            studentKolejka.enqueue(s);
            System.out.println(s);
        }
        System.out.println();
        System.out.println("*********************");
        System.out.println();
        while(studentKolejka.size()>0){
            Student s = studentKolejka.dequeue();
            kolejka2.enqueue(s);
            System.out.println(s);
        }
        System.out.println();
        System.out.println(String.format("Porównania: %d, Przesunięcia: %d", studentKolejka.por, studentKolejka.przes));

    }
}
