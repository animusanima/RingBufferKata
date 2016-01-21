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
public class RemoveFirstElementStrategy<T> implements CapacityReachedStrategy<T> {

    @Override
    public void execute(List<T> elements) {
        if (elements.isEmpty())
            throw new IllegalStateException("Can't remove from empty list.");        
        elements.remove(0);
    }
    
}