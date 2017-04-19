package Stacks;

/**
 * Created by magdalenamazur on 27.03.2017.
 */
public class StosDyn extends StosTab{

    public StosDyn(int roz) {
        super(roz);
    }


    public void checkSizeUp(){

        if(size()==(3*this.roz)/4){
            this.roz+=roz;
            Object[] e1 = new Object[roz];
            System.out.println("Zwiększamy o połowę!");
            for (int i = 0; i <= top; i++)
            {e1[i]=e[i];}
            this.e=e1;
        }
    }
    public void checkSizeD(){
        if(size()==this.roz/4){
            this.roz-=roz/2;
            Object[] e1 = new Object[roz];
            System.out.println("Zmniejszamy o połowę!");
            for (int i = 0; i <= top; i++)
            {e1[i]=e[i];}
            this.e=e1;

        }
    }
    public void push(Object obiekt)throws StackFullException {
        if (isFull()){ throw new StackFullException(); }
        e[++top] = obiekt;
        checkSizeUp();
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) { throw new EmptyStackException(); }
        checkSizeD();
        return e[top--];

    }
}
