import static java.lang.Thread.sleep;

public class CustomSemaphore {

	private int buffersize;

public CustomSemaphore(int buffersize){
    this.buffersize = buffersize;
}

public void Wait(){
    while(this.buffersize <= 0){
    	Thread.yield();
    }
        this.buffersize--;
}

public void Signal(){
    this.buffersize++;

	}
}
