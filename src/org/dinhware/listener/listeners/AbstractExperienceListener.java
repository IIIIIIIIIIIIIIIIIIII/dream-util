package org.dinhware.listener.listeners;

import org.dinhware.listener.AbstractListener;
import org.dreambot.api.methods.skills.Skill;

/**
 * Created by: Niklas
 * Date: 27.10.2017
 * Alias: Dinh
 * Time: 16:39
 */

public abstract class AbstractExperienceListener extends AbstractListener {

    private Skill skill;

    protected AbstractExperienceListener(Skill skill) {
        this.skill = skill;
    }

    @Override
    public void run() {
        while (methodContext.getClient().getInstance().getScriptManager().isRunning()) {
            int cache = methodContext.getSkills().getExperience(skill);
            if (cache > value) {
                onExperienceGain(skill, cache - value);
                value = cache;
            }
        }
    }

    @Override
    public void init() {
        value = methodContext.getSkills().getExperience(skill);
    }

    public abstract void onExperienceGain(Skill skill, int experience);
}
