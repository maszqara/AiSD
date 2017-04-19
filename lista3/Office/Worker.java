package Office;
import Kolejka.Element;
import Kolejka.EmptyQueueException;
import Kolejka.Queue;

public class Worker {
    private Queue kol;
    private Client current;
    private String name;

    public Worker(Queue kol, String name) {
        this.kol = kol;
        this.name = name;
    }

    public void work() {
        if (this.kol.isEmpty() && this.current==null) {
            System.out.println("Urzędnik " + name + " czeka na klienta.");
        }
           else if (this.current == null) {
                Element k = (Element) this.kol.dequeue();
                this.current = (Client) k.obiekt;
                System.out.println(String.format("%s -> %2s", current.toString(), this.name));
                int t = this.current.getTime();
                this.current.remTime--;

            } else if (!this.current.isDone()) {
                    System.out.println(String.format("%s -> %2s", current.toString(), this.name));
                    this.current.remTime--;
                } else if (this.current.isDone()) {
                        this.current = null;
                work();
                    }

            }





    }
