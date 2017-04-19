package Stacks;

public class StosTon extends StosTab{

    public StosTon(int roz) {
        super(roz);
    }
    public void push(Object obiekt) {
        if (isFull()){
            Object[] temp = new Object[1];
            temp[0]=e[top];
            e[0]=e[top];
            pop();
            for(int i=1;i <=top;i++){
                e[i-1]=e[i];
            }
            e[top]=temp[0];
        }
            e[++top] = obiekt;
    }
}
