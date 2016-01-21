/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import java.util.ArrayList;
import strategy.CapacityReachedStrategy;
import strategy.RemoveFirstElementStrategy;

/**
 *
 * @author hinterseber
 * @param <T> RingBuffer type
 */
public final class RingBuffer<T>
{
    private final int bufferSize;
    private final ArrayList<T> elements;
    private CapacityReachedStrategy<T> strategy;
    
    public RingBuffer(int size) {
        validateSize(size);
        
        bufferSize = size;
        elements = new ArrayList<>();
        this.strategy = new RemoveFirstElementStrategy<>();
    }
    
    public void setStrategy(CapacityReachedStrategy<T> strategy) {
        this.strategy = strategy;
    }            

    private void validateSize(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Only positive sizes are allowed.");
    }
    
    public void add(T element) {
        if (isCapacityReached()) {
            strategy.execute(elements);
        }        
        elements.add(element);
    }

    private boolean isCapacityReached() {
        return count() >= size();
    }
    
    public T take() {
        if (isEmpty())
            throw new IllegalStateException("Can't call take() on an empty buffer.");
        
        T ele = elements.remove(0);
        return ele;
    }

    private boolean isEmpty() {
        return count() == 0;
    }
    
    public int count() {
        return elements.size();
    }
    
    public int size() {
        return bufferSize;
    }

    @Override
    public String toString() {
        String res = "";
        res = elements.stream().map((ele) -> ele.toString() + ",").reduce(res, String::concat);        
        return res.substring(0, res.lastIndexOf(","));
    }
        
}