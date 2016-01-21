/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import buffer.RingBuffer;

/**
 *
 * @author hinterseber
 */
public final class BufferFactory 
{    
    public static RingBuffer createBufferWithSize(int size) {
        return new RingBuffer(size);
    }
}