
public class Wyczerpane implements Predicate
{
    public boolean accept(Object t){
        return ((Towar)t).ilosc == 0;
    }
}
