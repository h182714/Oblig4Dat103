import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private ArrayList<Integer> buffer;
    private int maxSize;

    public Buffer(int size) {
        buffer = new ArrayList<>();
        maxSize = size;
    }

    public void BufferAdd(Integer i){
        buffer.add(i);
        System.out.println("Add: " + i + "From Buffer");
    }
    public Integer BufferRemove(){
        if(!buffer.isEmpty()){
            return buffer.remove(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public boolean isFull() {
        return buffer.size() >= maxSize;
    }
}
