
public class Zaliczone implements Predicate
{
    public boolean accept(Object s){
        return ((Student)s).ocena >2;
    }
}
