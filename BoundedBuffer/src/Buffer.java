import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private List<Integer> buffer;

    public Buffer() {
        buffer = new ArrayList<>();
    }


    public void BufferAdd(int i) {
        Integer tall = i;
        buffer.add(tall);
        System.out.println("add " + tall + " to list");
    }

    public Integer BufferRemove() {
        if(!buffer.isEmpty()) {
            Integer tall = buffer.remove(0);
            System.out.println("remove " + tall + " from list");
            return tall;
        }else {
            System.out.println("list empty, return -1");
            return -1;
        }
    }

    public boolean BufferErTom() {
        return buffer.isEmpty();
    }

    public List<Integer> getBuffer() {
        return buffer;
    }
}