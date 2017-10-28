package org.dinhware.distribution;

/**
 * Created by: Niklas
 * Date: 26.06.2017
 * Alias: Dinh
 * Time: 11:04
 */

public class Utensil {

    private int itemID, amount;

    public Utensil(int itemID, int amount) {
        this.itemID = itemID;
        this.amount = amount;
    }

    public int getItemID() {
        return itemID;
    }

    public int getAmount() {
        return amount;
    }
}