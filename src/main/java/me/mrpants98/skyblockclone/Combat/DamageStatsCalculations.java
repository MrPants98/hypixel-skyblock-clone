package me.mrpants98.skyblockclone.Combat;

public class DamageStatsCalculations {

    public static float getDamageValue(float baseDamage, float strength, float additiveMultiplier, float multiplicativeMultiplier, float bonusModifiers, float critDamage, float enemyDefense) {
        float damageValue = ((5 + baseDamage) * (1+(strength/100)) * additiveMultiplier * multiplicativeMultiplier + bonusModifiers) * (1 + (critDamage/100));
        float damageValueAccountingDefense = damageValue * (1 - (enemyDefense / (enemyDefense + 100)));

        return damageValueAccountingDefense;
    }

    public static float getAbilityDamageValue(float baseAbilityDamage, float intelligence, float abilityScaling, float additiveMultiplier, float multiplicativeMultiplier, float bonusModifiers, float enemyDefense) {
        float damageValue = baseAbilityDamage * (1+(intelligence/100)*abilityScaling) * additiveMultiplier * multiplicativeMultiplier + bonusModifiers;
        float damageValueAccountDefense = damageValue * (1 - (enemyDefense / (enemyDefense + 100)));

        return damageValueAccountDefense;
    }

}
