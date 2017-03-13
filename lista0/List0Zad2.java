import java.io.*;
import java.util.Random;


public class List0Zad2
{
    public static void main(String[] args) throws FileNotFoundException {
        Operacje_Macierz2 M = new Operacje_Macierz2(8,5);

        }
    }



 class Operacje_Macierz2{

    private int n, m;
    private double mac[][];



    Operacje_Macierz2(int n, int m)
    {

        this.n = n;
        this.m = m;
        mac = new double[n][m];

        Wypelnij();
        Najwiekszy();
        Zapis();
        Odczyt();

    }




    private void Wypelnij(){

        int q = 100;

        Random rand = new Random();
        Random ran = new Random();


        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                mac[i][j]=rand.nextDouble()*ran.nextInt(q+1);

    }



    private double Najwiekszy() {
        int i = 0, j = 0, k= 0, w=0;
        double wynik = mac[i][j];
        for (j = 0; j < m; j++) {
            for (i = 0; i < n; i++) {
                if (wynik < mac[i][j]) {
                    wynik = mac[i][j];
                    w=i+1;
                    k=j+1;
                }
            }
        }
        return wynik;
    }
     private int NajK() {
         int i = 0, j = 0, k= 0, w=0;
         double wynik = mac[i][j];
         for (j = 0; j < m; j++) {
             for (i = 0; i < n; i++) {
                 if (wynik < mac[i][j]) {
                     wynik = mac[i][j];
                     w=i+1;
                     k=j+1;
                 }
             }
         }
         return k;
     }
     private int NajW() {
         int i = 0, j = 0, k= 0, w=0;
         double wynik = mac[i][j];
         for (j = 0; j < m; j++) {
             for (i = 0; i < n; i++) {
                 if (wynik < mac[i][j]) {
                     wynik = mac[i][j];
                     w=i+1;
                     k=j+1;
                 }
             }
         }
         return w;
     }


    public void Zapis(){


    try {
        FileOutputStream plikBin = new FileOutputStream("wyniki.dat");
        BufferedOutputStream buforBin = new BufferedOutputStream(plikBin);
        DataOutputStream wynikBin = new DataOutputStream(buforBin);
        wynikBin.writeInt(n);
        wynikBin.writeInt(m);
        for(int i=0; i<n; i++)
        {for (int j = 0; j < m; j++){
            wynikBin.writeDouble(mac[i][j]);}}
        wynikBin.writeDouble(Najwiekszy());
        wynikBin.writeInt(NajW());
        wynikBin.writeInt(NajK());

        buforBin.close();}
    catch (IOException e) {
        System.out.println(e.getMessage());

    }}
        public void Odczyt(){
        try {
            FileInputStream plikBin = new FileInputStream("wyniki.dat");
            BufferedInputStream buforBin = new BufferedInputStream(plikBin);
            DataInputStream wynikBin = new DataInputStream(buforBin);
            try {
                while (true) {
                    int n = wynikBin.readInt();
                    System.out.println("Liczba wierszy: "+ n);
                    int m = wynikBin.readInt();
                    System.out.println("Liczba kolumn: " +m);
                    System.out.println();
                    double[][] mac = new double[n][m];
                    for (int i = 0; i < n; i++){
                        for (int j = 0; j < m; j++){
                            mac[i][j] = wynikBin.readDouble();
                            System.out.format("%05.2f", mac[i][j]);
                        System.out.print("\t");}
                        System.out.println();}System.out.println();
                    double wynik = wynikBin.readDouble();
                    System.out.format("%s" + "%05.2f%n", "Największa wartość: ", wynik);
                    int w= wynikBin.readInt();
                    System.out.println("Wiersz: " +w);
                    int k= wynikBin.readInt();
                    System.out.println("Kolumna: " +k);
                }
            } catch (EOFException eof) {
                buforBin.close();
            }
            System.out.println();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    }









