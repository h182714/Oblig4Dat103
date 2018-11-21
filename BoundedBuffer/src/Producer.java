import java.util.concurrent.Semaphore;

public class Producer extends Thread{

    CustomSemaphore s;
    private CustomSemaphore sem;
    private CustomSemaphore tom;
    private CustomSemaphore full;
    private Buffer buffer;

    public Producer(CustomSemaphore s, CustomSemaphore tom, CustomSemaphore full, Buffer buffer){
        this.s = s;
        this.sem=sem;
        this.tom=tom;
        this.full=full;
        this.buffer=buffer;
    }
    @Override
    public void run(){
        do {
                Integer tall = 1;
                if(buffer.getBuffer().size() < bufferSize) {
                    tom.Wait();
                    sem.Wait();
                    buffer.addToList(tall);
                    sem.Signal();
                    full.Signal();
                }


                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }while (true);
        }
    }
        }
    }
}
