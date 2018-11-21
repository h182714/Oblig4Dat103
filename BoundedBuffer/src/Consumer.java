import java.util.concurrent.Semaphore;

public class Consumer extends Thread{
    Semaphore sem;
    CustomSemaphore s;
    CustomSemaphore full;
    CustomSemaphore tom;
    Buffer buffer;

    public Consumer(CustomSemaphore s, CustomSemaphore full, CustomSemaphore tom, Buffer buffer){
        this.sem=sem;
        this.s=s;
        this.full=full;
        this.tom=tom;
        this.buffer=buffer;
    }

    public void run(){
        while (true){
            try{
                full.wait();
                s.wait();

            }catch (InterruptedException e){
                    e.printStackTrace();
            }
            Integer i= buffer.BufferRemove();
            s.Signal();
            tom.Signal();
            System.out.println("Removed: " + i);
        }
    }

}
