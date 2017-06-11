import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sort {
    public int menu() {

        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Uporządkuj wg nazwisk (naturalny)");
        System.out.println("     2. Uporządkuj wg imion");
        System.out.println("     3. Uporządkuj wg indeksów");
        System.out.println("     4. Uporządkuj wg nazwisk, imion, indeksów");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        return w;
    }

    public Sort() throws IOException {

        Scanner in = new Scanner(System.in);
        int wybor = menu();

        List studentArray= new ArrayList();
        System.out.println("Lista studentów do posortowania: ");
        for (int i=0; i<10; i++) {
            studentArray.add(new Student());
        System.out.println(studentArray.get(i));}
        System.out.println();

        while (wybor != 0) {
            switch (wybor) {

                case 2:
                    System.out.println();
                    System.out.println("Sortowanie po imieniu:");
                    Collections.sort(studentArray, new NameComparator());
                    for (int i=0; i<10; i++) {
                        System.out.println(studentArray.get(i));}
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Sortowanie po indeksie:");
                    Collections.sort(studentArray, new IndexComparator());
                    for (int i=0; i<10; i++) {
                        System.out.println(studentArray.get(i));}
                    break;
                case 1:
                    System.out.println("Sortowanie komparatorem naturalnym po nazwiskach:");
                    Collections.sort(studentArray);
                    for (int i=0; i<10; i++) {
                        System.out.println(studentArray.get(i));}
                    break;
                case 4:
                    System.out.println("Sortowanie komparatorem złożonym (nazwisko, imię, indeks):");
                    Collections.sort(studentArray,new AllComparator());
                    for (int i=0; i<10; i++) {
                        System.out.println(studentArray.get(i));}
                    break;

            }
            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = menu();
        }
        System.out.println("\n     Koniec programu\n\n");

    }



}


