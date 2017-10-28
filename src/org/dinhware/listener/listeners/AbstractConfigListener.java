package org.dinhware.listener.listeners;

import org.dinhware.listener.AbstractListener;

/**
 * Created by: Niklas
 * Date: 27.10.2017
 * Alias: Dinh
 * Time: 16:41
 */

public abstract class AbstractConfigListener extends AbstractListener {

    private int setting;

    protected AbstractConfigListener(int setting) {
        this.setting = setting;
    }

    @Override
    public void run() {
        while (methodContext.getClient().getInstance().getScriptManager().isRunning()) {
            int cache = methodContext.getPlayerSettings().getConfig(setting);
            if (value != cache) {
                onConfigChange(setting, value = cache);
            }
        }
    }

    @Override
    public void init() {
        value = methodContext.getPlayerSettings().getConfig(setting);
    }

    public abstract void onConfigChange(int setting, int config);
}
