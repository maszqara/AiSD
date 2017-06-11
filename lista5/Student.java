import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.lang.Comparable;
import java.util.*;
import java.util.Comparator;

class Student implements Comparable<Student> {
    private int indeks;
    private String imie;
    private String nazwisko;
    private ArrayList<String> names;
    private ArrayList<String> lastn;

    Student() throws IOException {
        names = loadNames("names.txt");
        lastn = loadNames("lastn.txt");
        this.imie = getRandomName();
        this.nazwisko = getRandomLastn();
        Random r = new Random();
        this.indeks = r.nextInt(1000000);

    }

    private ArrayList<String> loadNames(String file) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader input = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(file)));
        try {
            String line = null;
            while ((line = input.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            input.close();
        }
        return lines;
    }


    private String getRandomName() {
        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }

    private String getRandomLastn() {
        Random random = new Random();
        return lastn.get(random.nextInt(lastn.size()));
    }

public int getIndeks(){
    return indeks;
}
    public String getLastName() {return nazwisko;}

    public int compareTo(Student other) {
       return this.nazwisko.compareTo(other.nazwisko);
    }


    public String toString() {
        return String.format("%06d %-12s %s", this.indeks, this.imie, this.nazwisko);
    }


    public String getName() {
        return imie;
    }
}


class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student left, Student right) throws ClassCastException {
        return left.getName().compareTo(right.getName());
    }
}


    class IndexComparator implements Comparator<Student> {
        @Override
        public int compare(Student left, Student right) throws ClassCastException {
            return right.getIndeks() > left.getIndeks() ? -1 : right.getIndeks() == left.getIndeks() ? 0 : 1;
        }

    }

class AllComparator implements Comparator<Student>{

    @Override
    public int compare(Student left, Student right) {
        int studentComparsion = left.getLastName().compareTo(right.getLastName());
        if (studentComparsion == 0 ) {int osoba2 = left.getName().compareTo(right.getName());
            studentComparsion=osoba2;
            if(osoba2==0){int osoba3 = left.getIndeks() > right.getIndeks()? +1 : left.getIndeks() < right.getIndeks()? -1 : 0;
                studentComparsion=osoba3;}}
        return studentComparsion;
    }
}


