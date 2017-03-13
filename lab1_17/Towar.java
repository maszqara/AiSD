
public class Towar {

    String nazwa;
    int ilosc;
    double cena,wartosc;

    public Towar(String nazwa,int ilosc,double cena){
        this.cena=cena;
        this.ilosc=ilosc;
        this.nazwa=nazwa;
        wartosc=ilosc*cena;

    }
    public void zmienCene(double c){ cena=c;}
    public double getCene(){return cena;}
    public String getNazwa(){return nazwa;}

    public String toString(){
        return nazwa+", "+ilosc+", "+cena+", "+wartosc;
    }

}
