import java.util.Collections;

public class Test {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addFirst(0);
        list.addFirst(5);


       list.addLast(1);
       list.addLast(2);

        System.out.println(list.indexOf(2));
        System.out.println(list);
        System.out.println();

        list.remove(5);
        System.out.println(list);
        System.out.println();

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        System.out.println(list);
        System.out.println();
        list.remove(6);
        System.out.println(list);
        System.out.println();
        list.remove(5);
        System.out.println(list);
        System.out.println();



    }
}
