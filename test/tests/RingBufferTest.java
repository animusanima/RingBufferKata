package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import buffer.RingBuffer;
import helper.BufferFactory;
import static org.hamcrest.CoreMatchers.is;
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
public class RingBufferTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroSizedRingBufferIsNotAllowed() {
        RingBuffer rb = BufferFactory.createBufferWithSize(0);
        assertNotNull(rb);
    }
    
    @Test
    public void creatingRingBufferOfSizeTwo() {
        RingBuffer rb = BufferFactory.createBufferWithSize(2);
        assertThat(rb.size(), is(2));
    }
}