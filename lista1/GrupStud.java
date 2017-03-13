import java.io.IOException;

public class GrupStud
{
    public static void main(String args[]) throws IOException {

        Student[] s = new Student[5];
        s[0] = new Student(1, "Krzysztof", "Wrzeszcz", 4);
        s[1] = new Student(2, "Anna", "Kiełbasa", 3);
        s[2] = new Student(3, "Marcin", "Pasztet", 3.5);
        s[3] = new Student(4, "Katarzyna", "Barszcz", 4.5);
        s[4] = new Student(5, "Bolesław", "Golas", 2);

        Database db = new Database(s);
        new Zadania(db);
    }
}
