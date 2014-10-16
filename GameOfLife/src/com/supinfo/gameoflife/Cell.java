package com.supinfo.gameoflife;

/**
 * @author Kevin Valfin <valfin.kevin@gmail.com>
 */
public interface Cell {

    Cell newGeneration(int numberOfNeighbours);

    String getAsString();

    boolean isAlive();
}
