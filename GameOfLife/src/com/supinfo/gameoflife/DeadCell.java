package com.supinfo.gameoflife;

/**
 * @author Kevin Valfin <valfin.kevin@gmail.com>
 */
public class DeadCell implements Cell {
    @Override
    public Cell newGeneration(int numberOfNeighbours) {
        if (numberOfNeighbours == 3) {
            return new AliveCell();
        } else {
            return this;
        }
    }

    @Override
    public String getAsString() {
        return "-";
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
