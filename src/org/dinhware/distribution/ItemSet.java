package org.dinhware.distribution;

import org.dinhware.price.PriceCheck;

/**
 * Created by: Niklas
 * Date: 25.06.2017
 * Alias: Dinh
 * Time: 23:55
 */

public class ItemSet {

    private Utensil[] utensils;

    public ItemSet(Utensil... utensils) {
        this.utensils = utensils;
    }

    public Utensil[] getTotal(PriceCheck priceCheck, int spendable) {
        int sets = getSets(priceCheck, spendable);
        Utensil[] utensils;
        if (sets == 0) return utensils = new Utensil[0];
        utensils = new Utensil[this.utensils.length];
        for (int i = 0; i < utensils.length; i++) {
            utensils[i] = new Utensil(this.utensils[i].getItemID(), this.utensils[i].getAmount() * sets);
        }
        return utensils;
    }

    private int getSets(PriceCheck priceCheck, int spendable) {
        int price = 0;
        for (Utensil utensil : utensils) {
            price += utensil.getAmount() * priceCheck.getPrice(utensil.getItemID());
        }
        if (price <= 0) return 0;
        return (int) Math.floor(spendable / price);
    }

}
