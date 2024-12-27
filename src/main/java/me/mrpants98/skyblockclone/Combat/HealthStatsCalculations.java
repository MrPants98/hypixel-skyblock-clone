package me.mrpants98.skyblockclone.Combat;

public class HealthStatsCalculations {
    public static float getEHp(float health, float defense) {
        float eHp = health * (1 + ( defense/100 ));
        return eHp;
    }

    public static float getDamageReduction(float defense) {
        float damageReduction = defense / (defense + 100);
        return damageReduction;
    }

    public static float getHealthRegenTick(float maxHealth, float healthRegen) {
        float regenTick = (float) ((1.5 + ( maxHealth / 100 )) * (healthRegen / 100));
        return regenTick;
    }

    public static float getTotalIncomingHealing(float healthGained, float vitality) {
        float incomingHealth = healthGained * (vitality / 100);
        return incomingHealth;
    }
}