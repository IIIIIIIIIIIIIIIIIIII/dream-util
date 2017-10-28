package org.dinhware.hop;

import org.dreambot.api.input.event.impl.InteractionEvent;
import org.dreambot.api.input.mouse.destination.impl.shape.RectangleDestination;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.MethodProvider;

import java.awt.*;

/**
 * Created by: Niklas
 * Date: 06.10.2017
 * Alias: Dinh
 * Time: 23:55
 */

public class CustomHop {

    /*
     * Rectangle of the World button
     */
    private final Rectangle CHANGE_WORLD = new Rectangle(5, 463, 99, 34);

    private MethodContext methodContext;

    public CustomHop(MethodContext methodContext) {
        this.methodContext = methodContext;
    }

    /*
     * Returns the bounds of the specified World
     */
    private Rectangle getWorld(int world, ValueSet valueSet) {
        if (world < 0 || world > valueSet.getLimit()) return null;
        int row = (int) Math.ceil((world + 1) / valueSet.getDivisor());
        int position = (world % valueSet.getModulo());
        return new Rectangle(59 + (93 * row), valueSet.getStartX() + (valueSet.getMultiplierX() * position), 87, 18);
    }

    /*
     * ValueSet for different kind of the World-grid
     */
    private ValueSet[] valueSets = new ValueSet[]{
            new ValueSet(94, 19D, 19, 37, 24),
            new ValueSet(89, 18D, 18, 49, 24),
            new ValueSet(99, 20D, 20, 35, 23)
    };

    private boolean hopWidgetLess(int world, int grid) {
        RectangleDestination rectangleDestination;
        if (methodContext.getClient().getCurrentWorld() == world) return true;
        rectangleDestination = new RectangleDestination(methodContext.getClient(), CHANGE_WORLD);
        new InteractionEvent(rectangleDestination).interact();
        MethodProvider.sleep(800);
        Rectangle worldBounds = getWorld(world, valueSets[grid]);
        if (worldBounds == null) return hopWidgetLess(world, grid);
        rectangleDestination = new RectangleDestination(methodContext.getClient(), worldBounds);
        new InteractionEvent(rectangleDestination).interact();
        return hopWidgetLess(world, grid);
    }

}
