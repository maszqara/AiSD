
public class NieZaliczone implements Predicate
{
    public boolean accept(Object s){
        return ((Student)s).ocena <= 2;
    }
}
