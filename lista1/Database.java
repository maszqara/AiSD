import java.util.Scanner;

class Database {

    private Student[] s;
    private IteratorTab itab;
    private IteratorFiltr izal;
    private IteratorFiltr inZal;

    Database(Student[] s) {

        this.s = s;
        this.itab = new IteratorTab(s);
        this.izal = new IteratorFiltr(itab, new Zaliczone());
        this.inZal = new IteratorFiltr(itab, new NieZaliczone());
    }

    void zmiana() {

        System.out.println("Podaj nr indeksu studenta ktoremu chcesz zmienic ocene");

        Scanner wej = new Scanner(System.in);
        int n = wej.nextInt();
        for (this.itab.first(); !this.itab.isDone(); this.itab.next()) {
            Student x = (Student) this.itab.current();
            if (x.getIndeks() == n) {
                System.out.println("Podaj nowa ocene");
                double m = wej.nextInt();
                x.zmienOcene(m);
                x.wyswietl();
            }
        }
    }

    void pelnaLista()

    {
        System.out.println("Pełna lista studentów");

        for (this.itab.first(); !this.itab.isDone(); this.itab.next()) {
            Student x = (Student) this.itab.current();
            x.wyswietl();
        }
    }

    void srednia() {
        double k = 0;
        int i = 0;
        System.out.println("Srednia ocen studentow z pozytywna ocena to");

        for (this.izal.first(); !this.izal.isDone(); this.izal.next()) {
            Student x = (Student) this.izal.current();
            k += x.getOcene();
            i++;
        }

        System.out.println(k / i);
    }

    void nieZal() {

        System.out.println("Lista studentów, ktorzy nie zaliczyli");

        for (this.inZal.first(); !this.inZal.isDone(); this.inZal.next()) {
            Student x = (Student) this.inZal.current();
            x.wyswietl();
        }
    }

    void zal() {

        System.out.println("Lista studentów, ktorzy zaliczyli");

        for (this.izal.first(); !this.izal.isDone(); this.izal.next()) {
            Student x = (Student) this.izal.current();
            x.wyswietl();
        }
    }

    void usun() {

        System.out.println("Podaj nr indeksu studenta ktorego chcesz usunac");

        Scanner wej = new Scanner(System.in);
        int n = wej.nextInt();
        int i = 0;
        Student[] s = new Student[this.s.length - 1];
        for (this.itab.first(); !this.itab.isDone(); this.itab.next()) {
            Student x = (Student) this.itab.current();
            if (x.getIndeks() != n) {
                s[i] = x;
                i++;
            }
        }
        this.s = s;
        this.itab = new IteratorTab(this.s);
        this.izal = new IteratorFiltr(this.itab, new Zaliczone());
        this.inZal = new IteratorFiltr(this.itab, new NieZaliczone());

    }

    void dopisz() {

        System.out.println("Podaj numer indeksu");
        Scanner wej = new Scanner(System.in);
        int n = wej.nextInt();
        System.out.println("Podaj imię");
        String im = wej.next();
        System.out.println("Podaj nazwisko");
        String naz = wej.next();
        System.out.println("Podaj ocenę");
        double oc = wej.nextDouble();
        int i = 0;
        boolean inserted = false;
        Student y = new Student(n, im, naz, oc);
        Student[] s = new Student[(this.s.length) + 1];
        for (this.itab.first(); !this.itab.isDone(); this.itab.next()) {
            Student x = (Student) this.itab.current();
            if (x.getIndeks() == n) {
                s[i++] = y;
                s[i++] = x;
                inserted = true;
            } else if (x.getIndeks() < n || inserted) {
                s[i] = x;
                i++;
            } else {
                s[i++] = y;
                s[i++] = x;
                inserted = true;
            }

        }
        if (!inserted) {
            s[s.length - 1] = y;
        }
        this.s = s;
        this.itab = new IteratorTab(this.s);
        this.izal = new IteratorFiltr(this.itab, new Zaliczone());
        this.inZal = new IteratorFiltr(this.itab, new NieZaliczone());

    }

    void sort(boolean b) {
        int i=0;
        this.itab.first();
        if(!b) {
            int sw = 0;
            while (!this.itab.isDone()) {
                try {
                    Student x = (Student) this.itab.current();
                    this.itab.next();
                    Student y = (Student) this.itab.current();
                    if (x.getOcene() < y.getOcene()) {
                        s[i+1] = x;
                        s[i] = y;
                        sw++;
                    }
                    i++;
                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }
            this.sort(sw==0);
        }
        else {
            this.itab = new IteratorTab(this.s);
            this.izal = new IteratorFiltr(this.itab, new Zaliczone());
            this.inZal = new IteratorFiltr(this.itab, new NieZaliczone());
        }
    }


}