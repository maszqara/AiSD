import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String args[]) throws IOException {


        Towar[] t = new Towar[5];

        t[0] = new Towar("Kielbasa", 4, 3.0);
        t[1] = new Towar("Babeczki", 5, 2.5);
        t[2] = new Towar("Chleb", 20, 2.0);
        t[3] = new Towar("Fasola", 50, 0.5);
        t[4] = new Towar("Margaryna", 0, 3.2);

        IteratorTab itab = new IteratorTab(t);
        IteratorFiltr iwycz = new IteratorFiltr(itab, new Wyczerpane());

        System.out.println("Pełna lista towarów");

        for (itab.first(); !itab.isDone(); itab.next()) {
            Towar x1 = (Towar) itab.current();
            System.out.println(x1.toString());
        }
        System.out.println();


        System.out.println("Podaj nazwe towaru, ktoremu chcesz zmienic cene");

        Scanner wej = new Scanner(System.in);
        String n = wej.nextLine();
        for (itab.first(); !itab.isDone(); itab.next()) {
            Towar x = (Towar) itab.current();
            if (x.getNazwa().equals(n)) {
                System.out.println("Podaj nowa ocene");
                double m = wej.nextInt();
                x.zmienCene(m);
                System.out.println(x.toString());
            }

        }


        System.out.println();
        System.out.println("Lista towarów wyczerpanych");

        for (iwycz.first(); !iwycz.isDone(); iwycz.next()) {
            Towar x2 = (Towar) iwycz.current();
            System.out.println(x2.toString());
        }

        System.out.println();
        System.out.println("Podaj cene");
        wej = new Scanner(System.in);
        int k = wej.nextInt();

        for (itab.first(); !itab.isDone(); itab.next()) {
            Towar x3 = (Towar) itab.current();
            if (x3.getCene() < k) {
                System.out.println(x3.toString());
            }
        }
    }
}

