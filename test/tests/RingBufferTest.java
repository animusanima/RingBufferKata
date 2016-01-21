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

/**
 *
 * @author hinterseber
 */
public class RingBufferTest 
{
    private RingBuffer<Integer> cut;
    public RingBufferTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
}