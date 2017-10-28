package org.dinhware.thread;

import org.dreambot.api.script.AbstractScript;

/**
 * Created by: Niklas
 * Date: 28.10.2017
 * Alias: Dinh
 * Time: 18:24
 */


/*
 *  Defining this class as abstract in order to pass AbstractScript to our Main and
 *  force inheritance of the execute method which is required to run Code of thread
 */
abstract class AbstractLoop extends AbstractScript {

    /*
     * Overriding onStart so this is technically called upon Script start
     */
    @Override
    public void onStart() {
        /*
         * Starting a new Thread that keeps looping until the Script is stopped
         */
        new Thread(() -> {
            while (getClient().getInstance().getScriptManager().isRunning()) {
                /*
                 * Calling the abstract execute method and sleeping this::execute ms
                 */
                sleep(execute());
            }
        }).start();
    }

    /*
     * Abstract method that will be called from the Thread and go off in our Main
     */
    abstract int execute();
}
