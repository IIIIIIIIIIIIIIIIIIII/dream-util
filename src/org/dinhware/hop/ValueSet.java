package org.dinhware.hop;

/**
 * Created by: Niklas
 * Date: 06.10.2017
 * Alias: Dinh
 * Time: 23:09
 */

/*
 * Class to hold different values for the World interface pre-login
 */
public class ValueSet {

    private double divisor;
    private int limit, modulo, startX, multiplierX;

    public ValueSet(int limit, double divisor, int modulo, int startX, int multiplierX) {
        this.limit = limit;
        this.divisor = divisor;
        this.modulo = modulo;
        this.startX = startX;
        this.multiplierX = multiplierX;
    }

    public int getLimit() {
        return limit;
    }

    public double getDivisor() {
        return divisor;
    }

    public int getModulo() {
        return modulo;
    }

    public int getStartX() {
        return startX;
    }

    public int getMultiplierX() {
        return multiplierX;
    }
}
