package org.dinhware.subtab;

/**
 * Created by: Niklas
 * Date: 08.10.2017
 * Alias: Dinh
 * Time: 11:36
 */

/*
 * Enum that holds the Index of the other visible Tabs
 */
public enum SubTab {
    QUEST(1, 2, 3),
    DIARY(0, 2, 3),
    MINIGAME(0, 1, 3),
    KOUREND(0, 1, 2);

    private int[] indices;

    SubTab(int... indices) {
        this.indices = indices;
    }

    /*
     * Returns the Indices of the visible Tabs
     */
    public int[] getIndices() {
        return indices;
    }
}