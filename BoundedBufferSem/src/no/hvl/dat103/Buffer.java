package no.hvl.dat103;

import java.util.ArrayList;

public class Buffer {
    private ArrayList<Integer> buffer;
    private int maxSize;

    public Buffer(int size) {
        maxSize = size;
        buffer = new ArrayList<>();
    }

    public void BufferAdd(Integer i) {
        buffer.add(i);
    }

    public Integer BufferRemove() {
        if (!buffer.isEmpty()) {
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