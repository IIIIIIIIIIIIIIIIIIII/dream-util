package org.dinhware.solver;

import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.randoms.RandomEvent;
import org.dreambot.api.randoms.RandomManager;
import org.dreambot.api.randoms.RandomSolver;

/**
 * Created by: Niklas
 * Date: 28.10.2017
 * Alias: Dinh
 * Time: 18:51
 */


/*
 *  Defining this class as abstract in order to force inheritance of the execute method
 */
public abstract class CustomSolver extends RandomSolver {

    public CustomSolver(RandomEvent randomEvent, MethodContext methodContext) {
        super(randomEvent, methodContext);
    }

    public void register(RandomManager randomManager) {
        randomManager.registerSolver(this);
    }
}