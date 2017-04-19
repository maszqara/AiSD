import Stacks.StosDyn;


/**
 * Created by magdalenamazur on 27.03.2017.
 */
public class Test44 {
    public static void main(String args[]) {

        StosDyn s = new StosDyn(5);


        s.push(70);
        s.push(5);
        s.push(40);
        System.out.println("Rozmiar: "+s.getRoz());
        System.out.println("Rozmiar: "+s.getRoz());
        s.all();
        s.push(3);
        s.push(67);
        s.all();
        s.push(67);
        s.all();
        s.push(67);
        s.all();
        s.push(67);
        s.all();
        s.push(67);
        s.all();
        s.push(67);
        s.all();
        s.push(67);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        System.out.println("Rozmiar: "+s.size());
        s.pop();
        s.pop();
        s.pop();
        System.out.println("Rozmiar: "+s.size());
        s.pop();
        s.pop();
        s.pop();

        s.all();
        System.out.println("Rozmiar: "+s.size());
    }

}
