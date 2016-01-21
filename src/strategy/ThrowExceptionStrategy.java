/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.util.List;

/**
 *
 * @author hinterseber
 */
public class ThrowExceptionStrategy<T> implements CapacityReachedStrategy<T>{

    @Override
    public void execute(List<T> elements) {
        throw new IllegalStateException("Capacity has been reached.");
    }
    
}