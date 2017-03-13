
public class Student
{
    int indeks;
    String imie;
    String nazwisko;
    double ocena;

    public Student(int indeks,String imie,String nazwisko,double ocena)
    {
        this.indeks=indeks;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.ocena=ocena;
    }
    public void zmienOcene(double oc){
        ocena=oc;
    }
    public double getOcene(){return ocena;}
    public int getIndeks(){return indeks;}

    public void wyswietl()
    {
        System.out.println(indeks+", "+imie+", "+nazwisko+", "+ocena);
    }
}
