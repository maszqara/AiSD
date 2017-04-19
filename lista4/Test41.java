import Stacks.StosTab;

public class Test41 {
    public static void main(String args[]) {

        StosTab s = new StosTab(5);


        s.push(70);
        s.push(5);
        s.push(40);
        s.push(3);
        s.push(67);
        s.all();
        System.out.println(s.peek());

        System.out.println("Pelny? " + s.isFull());
        s.pop();
        System.out.println("Rozmiar: "+s.size());

        System.out.println("Pusty? " + s.isEmpty());

        System.out.println("Pelny? " + s.isFull());
        s.all();
        s.clear();
        s.all();
        System.out.println(s.size());
    }

}


