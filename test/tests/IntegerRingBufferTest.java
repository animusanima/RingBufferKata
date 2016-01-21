package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import buffer.RingBuffer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.is;
import strategy.RemoveFirstElementStrategy;
import strategy.ThrowExceptionStrategy;

/**
 *
 * @author hinterseber
 */
public class IntegerRingBufferTest 
{
    private RingBuffer<Integer> cut;
    public IntegerRingBufferTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cut = null;
        cut = new RingBuffer<>(2);
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroSizedRingBufferIsNotAllowed() {
        RingBuffer<Integer> rb = new RingBuffer<>(0);
        assertNotNull(rb);
    }
    
    @Test
    public void creatingRingBufferOfSizeTwo() {
        assertThat(cut.size(), is(2));
        assertThat(cut.count(), is(0));
    }
    
    
    @Test
    public void canAddElement() {
        cut.add(1);        
        assertThat(cut.count(), is(1));
    }    
    
    @Test
    public void canTakeElement() {
        cut.add(1);
        Integer ele = cut.take();
        
        assertNotNull(ele);
        assertThat(cut.count(), is(0));
    }
    
    @Test(expected = IllegalStateException.class)
    public void takeFromEmptyBufferThrowsException() {
        cut.take();
    }
    
    @Test
    public void overwriteFirstElementAfterAddingMoreElementsThanSize() {        
        cut = new RingBuffer<>(3);
        
        cut.add(1);
        cut.add(2);
        cut.add(3);
        cut.add(4);
        
        Integer ele = cut.take();
        assertThat(ele, is(2));
        assertThat(cut.size(), is(3));
        assertThat(cut.count(), is(2));
    }
    
    @Test
    public void ringBufferKataFinalTest() {
        cut = new RingBuffer<>(3);
        
        cut.add(1);
        cut.add(2);
                
        assertThat(cut.size(), is(3));
        assertThat(cut.count(), is(2));
        
        Integer ele = cut.take();
        assertThat(ele, is(1));
                
        cut.add(3);
        cut.add(4);
        cut.add(5);
        
        ele = cut.take();
        assertThat(ele, is(3));
        
        cut.add(6);
        cut.add(7);
        
        assertThat(cut.count(), is(cut.size()));
        
        assertThat(cut.toString(), is("5,6,7"));
    }
    
    @Test
    public void removeFirstEntryStrategy() {
        cut = new RingBuffer<>(3);
        cut.setStrategy(new RemoveFirstElementStrategy<>());
        cut.add(3);
        cut.add(4);
        cut.add(5);
        cut.add(7);
        assertThat(cut.count(), is(3));

        Integer ele = cut.take();
        assertThat(ele, is(4));
    }
    
    @Test(expected = IllegalStateException.class)
    public void throwExceptionStrategy() {
        cut = new RingBuffer<>(3);
        cut.setStrategy(new ThrowExceptionStrategy<>());
        cut.add(3);
        cut.add(4);
        cut.add(5);
        cut.add(7);
    }
}