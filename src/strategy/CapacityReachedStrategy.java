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
public interface CapacityReachedStrategy<T> {
    public void execute(List<T> elements);
}