import java.io.IOException;
import java.util.Scanner;

public class Zadania {

    public int menu() {

        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Pełna Lista");
        System.out.println("     2. Zmień ocenę");
        System.out.println("     3. Średnia ocen zaliczonych");
        System.out.println("     4. Nie zaliczyli kursu");
        System.out.println("     5. Zaliczyli kurs");
        System.out.println("     6. Dopisz studenta");
        System.out.println("     7. Usuń studenta");
        System.out.println("     8. Uporządkuj według ocen");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        return w;
    }

    public Zadania(Database db) throws IOException {



        Scanner in = new Scanner(System.in);
        int wybor = menu();

        while (wybor != 0) {
            switch (wybor) {

                case 1:
                    db.pelnaLista();
                    break;
                case 2:
                    db.zmiana();
                    break;
                case 3:
                    db.srednia();
                    break;
                case 4:
                    db.nieZal();
                    break;
                case 5:
                    db.zal();
                    break;
                case 6:
                    db.dopisz();
                    break;
                case 7:
                    db.usun();
                    break;
                case 8:
                    db.sort(false);
                    break;
            }
            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = menu();
        }
        System.out.println("\n     Koniec programu\n\n");
    }


}
