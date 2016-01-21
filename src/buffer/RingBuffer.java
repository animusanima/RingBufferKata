/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

/**
 *
 * @author hinterseber
 */
public final class RingBuffer 
{
    private final int bufferSize;
    
    public RingBuffer(int size) {
        if (size == 0)
            throw new IllegalArgumentException("RingBuffer with zero size is not allowed.");
        bufferSize = size;
    }
    
    public int size() {
        return bufferSize;
    }
}