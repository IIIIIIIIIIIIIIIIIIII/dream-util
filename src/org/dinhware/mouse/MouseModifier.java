package org.dinhware.mouse;

import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.script.AbstractScript;

import java.lang.reflect.Field;

/**
 * Created by: Niklas
 * Date: 27.04.2017
 * Alias: Dinh
 * Time: 23:27
 */

public class MouseModifier {

    /*
     * Sets a custom Mouse by replacing the Mouse field
     */
    public static boolean setModifiedMouseController(AbstractScript s) {
        /*
         * Loops through all Fields in MethodContext to find Mouse
         */
        for (Field f : MethodContext.class.getDeclaredFields()) {
            if (f.getType().equals(Mouse.class)) {
                f.setAccessible(true);
                try {
                    /*
                     * Modifies the Mouse field
                     */
                    f.set(s, new ModifiedMouse(s.getClient(), null));
                } catch (IllegalAccessException iae) {
                    iae.printStackTrace();
                }
                f.setAccessible(false);
            }
        }
        return false;
    }
}