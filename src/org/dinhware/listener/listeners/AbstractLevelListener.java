package org.dinhware.listener.listeners;

import org.dinhware.listener.AbstractListener;
import org.dreambot.api.methods.skills.Skill;

/**
 * Created by: Niklas
 * Date: 27.10.2017
 * Alias: Dinh
 * Time: 16:36
 */

public abstract class AbstractLevelListener extends AbstractListener {

    private Skill skill;

    protected AbstractLevelListener(Skill skill) {
        this.skill = skill;
    }

    @Override
    public void run() {
        while (methodContext.getClient().getInstance().getScriptManager().isRunning()) {
            int cache = methodContext.getSkills().getRealLevel(skill);
            if (cache > value) {
                onLevelUp(skill, cache - value);
                value = cache;
            }
        }
    }

    @Override
    public void init() {
        value = methodContext.getSkills().getRealLevel(skill);
    }

    public abstract void onLevelUp(Skill skill, int levels);
}
