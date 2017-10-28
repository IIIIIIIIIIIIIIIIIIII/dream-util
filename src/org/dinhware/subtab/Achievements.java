package org.dinhware.subtab;

import org.dreambot.api.input.event.impl.InteractionEvent;
import org.dreambot.api.input.mouse.destination.impl.shape.RectangleDestination;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.settings.PlayerSettings;

import java.awt.*;

/**
 * Created by: Niklas
 * Date: 08.10.2017
 * Alias: Dinh
 * Time: 11:39
 */


public class Achievements {
    /*
     * Tab-bounds for the three SubTab Icons in the Quest tab
     */
    private static final Rectangle[] TAB_BOUNDS = new Rectangle[]{
            new Rectangle(683, 209, 18, 18),
            new Rectangle(701, 209, 18, 18),
            new Rectangle(719, 209, 18, 18)
    };

    /*
     * Returns the current open SubTab by shifting and computing
     */
    private static SubTab getOpen(MethodContext methodContext) {
        PlayerSettings playerSettings = methodContext.getPlayerSettings();
        int setting1002 = playerSettings.getConfig(1002), setting1055 = playerSettings.getConfig(1055);
        int quest = (setting1002 & Integer.MIN_VALUE) == Integer.MIN_VALUE ? 0 : 1;
        int kourend = (setting1055 & (1 << 15)) == 32768 ? 2 : (setting1055 & (1 << 4)) == 16 ? 1 : 0;
        return quest == 1 && kourend == 0 ? SubTab.QUEST : quest == 0 && kourend == 0 ? SubTab.DIARY : quest == 1 && kourend == 1 ? SubTab.MINIGAME : SubTab.KOUREND;
    }

    /*
     * Returns true if the Quest- & correct Sub- Tab  are open
     */
    public static boolean isOpen(SubTab tab, MethodContext methodContext) {
        return methodContext.getTabs().isOpen(org.dreambot.api.methods.tabs.Tab.QUEST) && getOpen(methodContext) == tab;
    }

    /*
     * Opens the specified SubTab with the Mouse
     */
    public static boolean open(SubTab tab, MethodContext methodContext) {
        return open(tab, true, methodContext);
    }

    /*
     * Opens the specified SubTab with either the Mouse or Keyboard
     */
    public static boolean open(SubTab tab, boolean mouse, MethodContext methodContext) {
        SubTab current = getOpen(methodContext);
        if (!methodContext.getTabs().isOpen(org.dreambot.api.methods.tabs.Tab.QUEST)) {
            if (mouse) methodContext.getTabs().openWithMouse(org.dreambot.api.methods.tabs.Tab.QUEST);
            else methodContext.getTabs().openWithFKey(org.dreambot.api.methods.tabs.Tab.QUEST);
        }
        if (current == tab) return true;
        for (int i = 0; i < 3; i++) {
            if (current.getIndices()[i] == tab.ordinal()) {
                return new InteractionEvent(new RectangleDestination(methodContext.getClient(), TAB_BOUNDS[i])).interact();
            }
        }
        return false;
    }
}