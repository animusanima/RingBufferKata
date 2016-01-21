/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import java.util.ArrayList;

/**
 *
 * @author hinterseber
 * @param <T> RingBuffer type
 */
public final class RingBuffer<T>
{
    private final int bufferSize;
    private ArrayList<T> elements;
    
    public RingBuffer(int size) {
        if (size == 0)
            throw new IllegalArgumentException("RingBuffer with zero size is not allowed.");
        bufferSize = size;        
        elements = new ArrayList<>();
    }
    
    public void add(T element) {
        elements.add(element);
    }
    
    public T take() {
        T ele = elements.remove(0);
        return ele;
    }
    
    public int count() {
        return elements.size();
    }
    
    public int size() {
        return bufferSize;
    }
}