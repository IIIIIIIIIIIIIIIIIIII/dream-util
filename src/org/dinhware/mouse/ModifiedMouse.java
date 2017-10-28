package org.dinhware.mouse;

import org.dreambot.api.Client;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.input.event.impl.mouse.impl.click.ClickMode;
import org.dreambot.api.input.mouse.destination.AbstractMouseDestination;
import org.dreambot.api.methods.input.mouse.CrosshairState;
import org.dreambot.api.methods.input.mouse.MouseSettings;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.utilities.impl.Condition;
import org.dreambot.api.wrappers.interactive.Entity;

import java.awt.*;
import java.util.List;

/**
 * Created by: Niklas
 * Date: 27.04.2017
 * Alias: Dinh
 * Time: 23:26
 */

/*
 * Custom Mouse class to change default Mouse behaviour
 */
public class ModifiedMouse extends Mouse {

    public ModifiedMouse(Client client, Object o) {
        super(client, o);
    }

    @Override
    public Mouse getContext() {
        return super.getContext();
    }

    @Override
    public int getIdleTime() {
        return super.getIdleTime();
    }

    @Override
    public Point getLastClicked() {
        return super.getLastClicked();
    }

    @Override
    public int getLastClickedX() {
        return super.getLastClickedX();
    }

    @Override
    public int getLastClickedY() {
        return super.getLastClickedY();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public Point getPosition() {
        return super.getPosition();
    }

    @Override
    public MouseSettings getMouseSettings() {
        return super.getMouseSettings();
    }

    @Override
    public int getCrosshairColorID() {
        return super.getCrosshairColorID();
    }

    @Override
    public CrosshairState getCrosshairState() {
        return super.getCrosshairState();
    }

    @Override
    public int getLastCrosshairColorID() {
        return super.getLastCrosshairColorID();
    }

    @Override
    public List<Entity> getEntitiesOnCursor() {
        return super.getEntitiesOnCursor();
    }

    @Override
    public boolean click(Rectangle rectangle) {
        return super.click(rectangle);
    }

    @Override
    public boolean click(Rectangle rectangle, boolean b) {
        return super.click(rectangle, b);
    }

    @Override
    public boolean click(Point point) {
        return super.click(point);
    }

    @Override
    public boolean click(Point point, boolean b) {
        return super.click(point, b);
    }

    @Override
    public boolean click(Entity entity) {
        return super.click(entity);
    }

    @Override
    public boolean click(Entity entity, boolean b) {
        return super.click(entity, b);
    }

    @Override
    public boolean click(AbstractMouseDestination abstractMouseDestination, boolean b) {
        return super.click(abstractMouseDestination, b);
    }

    @Override
    public boolean click() {
        return super.click();
    }

    @Override
    public boolean click(boolean b) {
        return super.click(b);
    }

    @Override
    public boolean click(ClickMode clickMode) {
        return super.click(clickMode);
    }

    @Override
    public boolean click(AbstractMouseDestination abstractMouseDestination) {
        return super.click(abstractMouseDestination);
    }

    @Override
    public boolean click(AbstractMouseDestination abstractMouseDestination, ClickMode clickMode) {
        return super.click(abstractMouseDestination, clickMode);
    }

    @Override
    public void mouseDownWhile(int i, Condition condition) {
        super.mouseDownWhile(i, condition);
    }

    @Override
    public void scrollWhile(boolean b, int i, Condition condition) {
        super.scrollWhile(b, i, condition);
    }

    @Override
    public boolean move(Rectangle rectangle) {
        return super.move(rectangle);
    }

    @Override
    public boolean move(Entity entity) {
        return super.move(entity);
    }

    @Override
    public boolean move(Point point) {
        return super.move(point);
    }

    @Override
    public boolean move(Tile tile) {
        return super.move(tile);
    }

    @Override
    public boolean move(AbstractMouseDestination abstractMouseDestination) {
        return super.move(abstractMouseDestination);
    }

    @Override
    public boolean move() {
        return super.move();
    }

    @Override
    public boolean drag(Point point) {
        return super.drag(point);
    }

    @Override
    public boolean drag(Tile tile) {
        return super.drag(tile);
    }

    @Override
    public boolean drag(Entity entity) {
        return super.drag(entity);
    }

    @Override
    public boolean drag(Rectangle rectangle) {
        return super.drag(rectangle);
    }

    @Override
    public boolean drag(AbstractMouseDestination abstractMouseDestination) {
        return super.drag(abstractMouseDestination);
    }

    @Override
    public boolean moveMouseOutsideScreen() {
        return super.moveMouseOutsideScreen();
    }

    @Override
    public boolean isMouseInScreen() {
        return super.isMouseInScreen();
    }

    @Override
    public boolean hop(Point point) {
        return super.hop(point);
    }

    @Override
    public boolean hop(int i, int i1) {
        return super.hop(i, i1);
    }

    @Override
    public Point getPointOutsideScreen() {
        return super.getPointOutsideScreen();
    }

    @Override
    public void setLastClickPosition(Point point) {
        super.setLastClickPosition(point);
    }

    @Override
    public double getLastMouseMagnitude() {
        return super.getLastMouseMagnitude();
    }

    @Override
    public void setLastMouseMagnitude(double v) {
        super.setLastMouseMagnitude(v);
    }

    @Override
    public double getLastMouseDirection() {
        return super.getLastMouseDirection();
    }

    @Override
    public void setLastMouseDirection(double v) {
        super.setLastMouseDirection(v);
    }

    @Override
    public long getLastMouseMoveTime() {
        return super.getLastMouseMoveTime();
    }

    @Override
    public void setLastMouseMoveTime(long l) {
        super.setLastMouseMoveTime(l);
    }

    @Override
    public long getMouseMoveResetTimeMillis() {
        return super.getMouseMoveResetTimeMillis();
    }

    @Override
    public boolean isAlwaysHop() {
        return super.isAlwaysHop();
    }

    @Override
    public void setAlwaysHop(boolean b) {
        super.setAlwaysHop(b);
    }
}
