package Stacks;

import Stacks.EmptyStackException;

public interface Stos
{
    public void push(Object obiekt);
    public Object pop() throws EmptyStackException;
    public int size();
    public boolean isEmpty();
}

