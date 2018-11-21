

public class Consumer extends Thread{
    CustomSemaphore sem;
    CustomSemaphore full;
    CustomSemaphore tom;
    Buffer buffer;

    public Consumer(CustomSemaphore sem, CustomSemaphore full, CustomSemaphore tom, Buffer buffer){
        this.sem=sem;
        this.full=full;
        this.tom=tom;
        this.buffer=buffer;
    }

    public void run(){
        while (true){
            full.Wait();
            sem.Wait();

            Integer tall = buffer.BufferRemove();
            System.out.println("Removed: " + tall);

            sem.Signal();
            tom.Signal();
        }
    }

}
