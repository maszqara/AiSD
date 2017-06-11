
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student left, Student right) throws ClassCastException {
        int studentComparsion = right.getLastName().compareTo(left.getLastName());
        if (studentComparsion == 0 ) {int osoba2 = right.getName().compareTo(left.getName());
            studentComparsion=osoba2;
            if(osoba2==0){int osoba3 = left.getIndeks() < right.getIndeks()? +1 : left.getIndeks() < right.getIndeks()? -1 : 0;
                studentComparsion=osoba3;}}
        return studentComparsion;
    }
}
