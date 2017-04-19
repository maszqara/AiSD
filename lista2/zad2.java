/**
 * Created by magdalenamazur on 25.03.2017.
 */
public class zad2 {
    public static void main(String[] args) {

        DoubleLinked list1 = new DoubleLinked();
        list1.add(0);
        list1.add(1);
        list1.add("dddd");
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        System.out.println("Przed usunięciem 2: "+list1);
        //System.out.println(list1.contains(2));
        //System.out.println(list1.indexOf(2));
        list1.remove(2);

        System.out.println("Usunięta 2: "+list1);


        DoubleLinked list2 = new DoubleLinked();
        list2.add(11);
        list2.add(10);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.remove(6);

        DoubleLinked list3 = new DoubleLinked();
        list3.add("aa");
        list3.add("bb");
        list3.add("cc");

        DoubleLinked list4 = new DoubleLinked();
        list4.add("a1");
        list4.add("b2");
        list4.add("c3");

        list1.add("dddd");
        list1.add("bbb");
        System.out.println("Lista 1:\n"+list1);
        System.out.println("Lista 2:\n"+list2);
        System.out.println("Lista 3:\n"+list3);
        System.out.println("Lista 4:\n"+list4);
        System.out.println();

        list1.insertList(1,list3);
        System.out.println("Wstawienie listy 3 na drugie miejce listy\n"+list1);


        list1.insertList("dddd",list2);
        System.out.println("Wstawienie listy 2 przed dddd\n"+list1);

        list1.addList(list4);
        System.out.println("Dodanie na koniec listy 4\n"+list1);
    }
}
