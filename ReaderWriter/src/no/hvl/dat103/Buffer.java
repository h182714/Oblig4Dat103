package no.hvl.dat103;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Buffer {

    private ArrayList<Integer> buffer;
    private int readers;

    public Buffer() {
        readers = 0;
        buffer = new ArrayList<>();
    }

    public void BufferAdd(Integer s) {
        buffer.add(s);
    }
    public Integer BufferRemove() {
        if(!buffer.isEmpty()) {
            return buffer.remove(0);
        }
       return -1;
    }

    public boolean BufferErTom() {
        return buffer.isEmpty();
    }

    public int getReaders() {
        return readers;
    }

    public void setReaders(int readers){
        this.readers = readers;
    }

}