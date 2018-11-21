import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private List<Integer> buffer;

    public Buffer(){
        buffer = new ArrayList<>();
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
    public List<Integer> getBuffer(){
        return buffer;
    }
    public boolean BufferErTom(){
        return buffer.isEmpty();
    }
}
