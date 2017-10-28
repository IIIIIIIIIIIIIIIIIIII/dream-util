package org.dinhware.listener;

import org.dinhware.listener.listeners.AbstractConfigListener;
import org.dinhware.listener.listeners.AbstractExperienceListener;
import org.dinhware.listener.listeners.AbstractLevelListener;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.utilities.impl.Condition;

/**
 * Created by: Niklas
 * Date: 27.10.2017
 * Alias: Dinh
 * Time: 16:31
 */

public abstract class ListenerManager extends AbstractScript {

    private final Object lock = new Object();

    @Override
    public void onStart() {
        new Thread(() -> delayUntil(() -> getClient().isLoggedIn())).start();
    }

    private void delayUntil(Condition condition) {
        synchronized (lock) {
            while (getClient().getInstance().getScriptManager().isRunning() && !condition.verify()) sleep(500);
        }
    }

    private void run(AbstractListener abstractListener) {
        synchronized (lock) {
            abstractListener.initialize(this);
            abstractListener.start();
        }
    }

    protected void registerConfigListener(AbstractConfigListener configListener) {
        run(configListener);
    }

    protected void registerExperienceListener(AbstractExperienceListener experienceListener) {
        run(experienceListener);
    }

    protected void registerLevelListener(AbstractLevelListener levelListener) {
        run(levelListener);
    }

}
