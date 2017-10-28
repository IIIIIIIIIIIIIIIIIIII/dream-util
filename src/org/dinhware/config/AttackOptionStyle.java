package org.dinhware.config;

import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.wrappers.widgets.WidgetChild;

/**
 * Created by: Niklas
 * Date: 28.10.2017
 * Alias: Dinh
 * Time: 18:45
 */

public class AttackOptionStyle {

    private MethodContext methodContext;

    /*
     * Constructor to receive a MethodContext reference
     */
    public AttackOptionStyle(MethodContext methodContext) {
        this.methodContext = methodContext;
    }

    /*
     * Enum of available Attack options
     */
    private enum AttackOption {
        DEPENDS_ON_COMBAT_LEVEL, ALWAYS_RIGHT_CLICK, LEFT_CLICK_WHERE_AVAILABLE, HIDDEN
    }

    private boolean isAttackOption(SettingType settingType, AttackOption attackOption) {
        return (methodContext.getPlayerSettings().getConfig(settingType.getConfigValue()) & attackOption.ordinal()) == attackOption.ordinal();
    }

    /*
     * Enum of options for different types
     */
    private enum SettingType {
        PLAYER(67, 83, 1107), NPC(68, 84, 1306);
        private int mainChildIndex, childIndex, configValue;

        SettingType(int mainChildIndex, int childIndex, int configValue) {
            this.mainChildIndex = mainChildIndex;
            this.childIndex = childIndex;
            this.configValue = configValue;
        }

        public int getMainChildIndex() {
            return mainChildIndex;
        }

        public int getChildIndex() {
            return childIndex;
        }

        public int getConfigValue() {
            return configValue;
        }
    }

    private boolean openConfig() {
        return methodContext.getTabs().isOpen(Tab.OPTIONS) || methodContext.getTabs().open(Tab.OPTIONS);
    }

    private boolean openControls() {
        WidgetChild configChild = methodContext.getWidgets().getWidgetChild(261, 1, 6);
        return configChild != null && (configChild.getTextureId() == 762 || configChild.interact("Controls"));
    }

    private boolean toggleAttackOption(SettingType settingType, AttackOption attackOption) {
        if (openConfig() && openControls()) {
            WidgetChild optionChild = methodContext.getWidgets().getWidgetChild(261, settingType.getChildIndex(), (attackOption.ordinal() + 1));
            if (optionChild != null && optionChild.isVisible()) {
                return optionChild.interact();
            } else {
                WidgetChild comboBox = methodContext.getWidgets().getWidgetChild(261, settingType.getMainChildIndex(), 0);
                return comboBox != null && comboBox.interact();
            }
        }
        return false;
    }
}