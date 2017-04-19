package Office;
import java.util.Random;

public class Client {

    protected int time,id,remTime;


    public Client(int id){
        this.id=id;
        this.time=(new Random().nextInt(20)+1);
        remTime=this.time;

    }


    public String toString(){
        return String.format("Klient %d - czas sprawy %d", this.id, this.remTime);
    }

    public int getTime(){
        return this.time;
    }
    public boolean isDone(){
        return(remTime==0);
    }

}
