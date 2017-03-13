
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class List0Zad1
{
    public static void main(String[] args) throws FileNotFoundException {
        Operacje_Macierz M = new Operacje_Macierz(8,5);
        try
        { M.Zapis("macierz.txt",false);
            M.Odczyt("macierz.txt");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}



class Operacje_Macierz {

    private int n, m;
    private double mac[][];

    Operacje_Macierz(int n, int m) {

        this.n = n;
        this.m = m;
        mac = new double[n][m];

        Wypelnij();
        Najwiekszy();
    }


    private void Wypelnij() {

        int q = 100;

        Random rand = new Random();
        Random ran = new Random();


        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mac[i][j] = rand.nextDouble() * ran.nextInt(q + 1);

    }

    public void Zapis(String place, boolean add) throws IOException {

        FileWriter wri = new FileWriter(place, add);
        PrintWriter pri = new PrintWriter(wri);

        pri.println("Macierz");
        pri.println("Liczba wierszy:");
        pri.println(n);
        pri.println("Liczba kolumn:");
        pri.println(m);
        //pri.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                pri.printf("%05.2f", mac[i][j]);
                pri.print("\t");
            }

            pri.println();
        }
        pri.println();
        pri.println(Najwiekszy());
        pri.close();
    }


    private String Najwiekszy() {
        int i = 0, j = 0, k = 0, w = 0;
        double wynik = mac[i][j];
        for (j = 0; j < m; j++) {
            for (i = 0; i < n; i++) {
                if (wynik < mac[i][j]) {
                    wynik = mac[i][j];
                    w = i + 1;
                    k = j + 1;
                }
            }
        }
        String text = String.format("%s" + "%05.2f", "Największa wartosc to: ", wynik);
        String text2 = (" w wierszu " + w + " i kolumnie " + k);
        return text + text2;
    }


    public void Odczyt(String place) throws IOException {

        FileReader fr = new FileReader(place);
        BufferedReader br = new BufferedReader(fr);
        String textLine = br.readLine();
        br.readLine();
        Scanner sc = new Scanner(br.readLine());
        int row = sc.nextInt();
        br.readLine();
        sc = new Scanner(br.readLine());
        int col = sc.nextInt();
        double[][] mac = new double[row][col];
        int i = 0;
        int j = 0;
        for (String line; (line = br.readLine()) != null; ) {
            sc = new Scanner(line);
            while (sc.hasNextDouble()) {
                mac[i][j] = sc.nextDouble();
                j++;
                if (j == col) {
                    j = 0;
                    i++;
                }
            }

        }
        br.close();
        System.out.println("Liczba wierszy: "+ row);
        System.out.println("Liczba kolumn: " + col);
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                System.out.format("%05.2f", mac[i][j]);
                System.out.print("\t");

            }
            System.out.println();
        }
    }


}






