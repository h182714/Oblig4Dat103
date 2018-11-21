import static java.lang.Thread.sleep;

public class CustomSemaphore {

public int buffersize;

public CustomSemaphore(int s){
    this.buffersize = s;
}
public void Wait(){
    while(buffersize <= 0){

    }try {
        sleep(2);
    }catch( InterruptedException e){
        e.printStackTrace();
    }
        buffersize--;
}

public void Signal(){
    buffersize++;

}
}
