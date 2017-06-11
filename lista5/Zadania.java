import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Zadania {

    public int menu() {

        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Uporządkuj ciąg uporządkowany");
        System.out.println("     2. Uporządkuj ciąg odwrotnie uporządkowany");
        System.out.println("     3. Uporządkuj ciąg losowy");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        return w;
    }

    public Zadania() throws IOException {

        Scanner in = new Scanner(System.in);
        int wybor = menu();

        while (wybor != 0) {
            switch (wybor) {

                case 1:
                    System.out.println("Podaj długość ciągu");
                    posortowany(in.nextInt());
                    break;
                case 2:
                    System.out.println("Podaj długość ciągu");
                    odwrotny(in.nextInt());
                    break;
                case 3:
                    System.out.println("Podaj długość ciągu");
                    losowe(in.nextInt());
                    break;
            }
            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = menu();
        }
        System.out.println("\n     Koniec programu\n\n");
    }

    private void losowe(int len){
        int k;
        int [] tab = new int[len];
        Sort sorter = new Sort();
        for (int i = 0; i < tab.length; i++) {
            Random r = new Random();
            k = r.nextInt(100000);
            tab[i] = k;
            System.out.println(k);}
            int[] sorted = sorter.bubbleSort(tab.clone());
            int[] sorted2 = sorter.selectSort(tab.clone());
            int[] sorted3 = sorter.insertSort(tab.clone());
            int[] sorted4 = sorter.shellSort(tab.clone());
            int[] sorted5 = sorter.quickSort(tab.clone());
            int[] sorted6 = sorter.mergeSort(tab.clone());

    }
    private void odwrotny(int len) {
        int k=len+1;
        int[] tab = new int[len];
        Sort sorter = new Sort();
        for (int i = 0; i < tab.length; i++) {
            k--;
            tab[i] = k;
            System.out.println(k);}

        int[] sorted = sorter.bubbleSort(tab.clone());
        int[] sorted2 = sorter.selectSort(tab.clone());
        int[] sorted3 = sorter.insertSort(tab.clone());
        int[] sorted4 = sorter.shellSort(tab.clone());
        int[] sorted5 = sorter.quickSort(tab.clone());
        int[] sorted6 = sorter.mergeSort(tab.clone());



    }
    private void posortowany(int len) {
        int[] tab = new int[len];
        Sort sorter = new Sort();
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i;
            System.out.println(i);}

        int[] sorted = sorter.bubbleSort(tab.clone());
        int[] sorted2 = sorter.selectSort(tab.clone());
        int[] sorted3 = sorter.insertSort(tab.clone());
        int[] sorted4 = sorter.shellSort(tab.clone());
        int[] sorted5 = sorter.quickSort(tab.clone());
        int[] sorted6 = sorter.mergeSort(tab.clone());



    }

}
