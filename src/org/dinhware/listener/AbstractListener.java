package org.dinhware.listener;

import org.dreambot.api.methods.MethodContext;

/**
 * Created by: Niklas
 * Date: 27.10.2017
 * Alias: Dinh
 * Time: 16:34
 */

public abstract class AbstractListener extends Thread {

    protected MethodContext methodContext;
    protected int value;

    void initialize(MethodContext methodContext) {
        this.methodContext = methodContext;
        this.init();
    }

    public abstract void init();

}
