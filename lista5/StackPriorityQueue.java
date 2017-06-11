import java.lang.*;
import java.lang.Comparable;
import java.util.*;

public class StackPriorityQueue <T extends Comparable>{

    private List<T> list;
    private Comparator comparator;
    int por,przes =0;

    public StackPriorityQueue(Comparator<T> comparator) {
            this.comparator = comparator;
            this.list = new ArrayList<T>();
        }


    public boolean enqueue(T value) { // dołączenie elementu
            this.list.add(value);
            swim(this.list.size()-1); // wynurzenie (wyniesienie) elementu
        return true;
    }

    private void swim(int index) { // wynurzanie elementu (wynoszenie elementu w górę)
            int parent;

        }
    private void swap(int index1, int index2) { // zamiana miejscami dwóch elementów
            T temp = this.list.get(index1);
            this.list.set(index1, this.list.get(index2));
            this.list.set(index2, temp);
             this.przes++;
        }
    public T dequeue()  { // pobranie/usunięcie elementu
            if (isEmpty());
            T result = this.list.get(0);
            if (this.list.size() > 1) {
                this.list.set(0, this.list.get(this.list.size() - 1));
                sink(0); // zatapianie (opuszczanie) elementu
            }
            this.list.remove(this.list.size() - 1);
            return result;
        }

    private void sink(int index) { // zatapianie (opuszczanie) elementu
            boolean isDone=false;
            int child;
            while(!isDone && (child=2*index+ 1 ) < this.list.size()) {
                if (child < this.list.size()-1 &&
                        this.comparator.compare(this.list.get(child), this.list.get(child+1)) < 0){
                    ++child;
                    por++;}
                if (this.comparator.compare(this.list.get(index), this.list.get(child)) < 0){
                    swap(index, child);
                por++;}
                else isDone=true;
                index = child;
            }
        }
        public void clear() {
            this.list.clear();
        }
        public int size() {
            return list.size();
        }
        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void compare(int index){
            int parent;
            while(index != 0 && this.comparator.compare(this.list.get(index), this.list.get(parent= (index - 1) / 2)) > 0)
            { swap(index, parent);
                index=parent;
                por++;}

        }


}

