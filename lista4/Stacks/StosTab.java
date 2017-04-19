package Stacks;

import Stacks.EmptyStackException;
import Stacks.Stos;

public class StosTab implements Stos {

    protected  Object[] e;
    protected int top,roz;


    public StosTab(int roz) {
        e = new Object[roz];
        this.roz=roz;
        top = -1;
    }

    public void push(Object obiekt)throws StackFullException {
        if (isFull()){ throw new StackFullException(); }
        e[++top] = obiekt;
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) { throw new EmptyStackException(); }
        return e[top--];
    }


    public boolean isEmpty() {
        return (size()==0);
    }

    public boolean isFull() {
        return (size() == e.length);
    }

    public Object peek() throws EmptyStackException {
        if (isEmpty()) { throw new EmptyStackException(); }
        return e[top];
    }

    public void all() {
        for (int i = 0; i <= top; i++)
            System.out.print(e[i] + " ");
        System.out.println();
    }

    public void clear() {
        do pop();
        while (!isEmpty());
    }

    public int size() {
        return top + 1;
    }
public int getRoz(){
    return this.roz;
}
}