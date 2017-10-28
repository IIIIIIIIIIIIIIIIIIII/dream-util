package org.dinhware.hiscore;

/**
 * Created by: Niklas
 * Date: 26.11.2016
 * Alias: Dinh
 * Time: 19:06
 */

public enum HiscoreSkill {
    OVERALL("Overall", 0),
    ATTACK("Attack", 1),
    DEFENCE("Defence", 2),
    STRENGTH("Strength", 3),
    HITPOINTS("Hitpoints", 4),
    RANGED("Ranged", 5),
    PRAYER("Prayer", 6),
    MAGIC("Magic", 7),
    COOKING("Cooking", 8),
    WOODCUTTING("Woodcutting", 9),
    FLETCHING("Fletching", 10),
    FISHING("Fishing", 11),
    FIREMAKING("Firemaking", 12),
    CRAFTING("Crafting", 13),
    SMITHING("Smithing", 14),
    MINING("Mining", 15),
    HERBLORE("Herblore", 16),
    AGILITY("Agility", 17),
    THIEVING("Thieving", 18),
    SLAYER("Slayer", 19),
    FARMING("Farming", 20),
    RUNECRAFT("Runecraft", 21),
    HUNTER("Hunter", 22),
    CONSTRUCTION("Construction", 23);

    private String skill;
    private int index;

    HiscoreSkill(String skill, int index) {
        this.skill = skill;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return skill;
    }

}