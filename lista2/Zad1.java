/**
 * Created by magdalenamazur on 16.03.2017.
 */
public class Zad1 {

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        System.out.println(list.contains(2));
        System.out.println(list.indexOf(2));
        list.remove(2);
        list.add("dddd");
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.remove(9);
        System.out.println(list);
        list.delete(6);
        list.delete(5);
        list.delete(4);
        list.delete(3);
        list.delete(2);
        list.delete(1);

        System.out.println(list);
        System.out.println(list.size());

    }
}
