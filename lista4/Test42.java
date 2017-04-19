import Stacks.StosList;
public class Test42 {
    public static void main(String args[]) {

        StosList s = new StosList();


        s.push(70);
        s.push(5);
        s.push(40);
        s.push(3);
        s.push(67);
       System.out.println(s.toString());
        //System.out.println(s.getLast());
        System.out.println("Rozmiar: " + s.size());
        s.pop();
        System.out.println(s.toString());
        System.out.println("Rozmiar: " + s.size());

        System.out.println("Pusty? " + s.isEmpty());
        s.pop();
        s.push(6);
        System.out.println(s.toString());
        s.clear();
        System.out.println(s.toString());
        System.out.println(s.size());
    }
}
