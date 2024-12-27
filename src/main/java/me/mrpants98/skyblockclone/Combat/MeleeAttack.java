package me.mrpants98.skyblockclone.Combat;

import me.mrpants98.skyblockclone.Holograms.DamageMob;
import me.mrpants98.skyblockclone.SkyblockClone;
import net.kyori.adventure.text.Component;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataContainer;
import static org.bukkit.persistence.PersistentDataType.*;
import java.util.*;

import static me.mrpants98.skyblockclone.NamespaceKeys.*;
import static me.mrpants98.skyblockclone.Combat.DamageStatsCalculations.*;
import static me.mrpants98.skyblockclone.Holograms.TextComponents.*;

public class MeleeAttack implements Listener {

    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent e) {

        if (!(e.getDamager() instanceof Player p) || !(e.getEntity() instanceof LivingEntity entity))
            return;

        PersistentDataContainer entityContainer = entity.getPersistentDataContainer();
        int mobHealth;
        int mobDefense;
        int mobLvl;
        int mobMaxHealth;

        if (!entityContainer.has(healthKey) || !entityContainer.has(defenseKey) || !entityContainer.has(lvlKey) || !entityContainer.has(maxHealthKey))
            return;

        mobHealth = entityContainer.get(healthKey, INTEGER);
        mobDefense = entityContainer.get(defenseKey, INTEGER);
        mobLvl = entityContainer.get(lvlKey, INTEGER);
        mobMaxHealth = entityContainer.get(maxHealthKey, INTEGER);

        EntityType mobType = entity.getType();
        String entityName = mobType.name().substring(0, 1) + mobType.name().substring(1).toLowerCase();

        PersistentDataContainer playerContainer = p.getPersistentDataContainer();

        if (!playerContainer.has(baseDamageKey) || !playerContainer.has(strengthKey) || !playerContainer.has(critChanceKey) || ! playerContainer.has(critDamageKey))
            return;

        int baseDamage = playerContainer.get(baseDamageKey, INTEGER);
        int strength = playerContainer.get(strengthKey, INTEGER);
        int critChance = playerContainer.get(critChanceKey, INTEGER);

        Random rand = new Random();
        int critRoll = rand.nextInt(0, 100);
        boolean didCrit = critRoll < critChance;

        int critDamage = didCrit ? playerContainer.get(critDamageKey, INTEGER) : 0;

        float damageAmount = getDamageValue(baseDamage, strength, 1, 1, 0, critDamage, mobDefense);
        mobHealth -= damageAmount;

        entity.getPersistentDataContainer().set(healthKey, INTEGER, mobHealth);

//        List<Entity> passengers = entity.getPassengers();

//        for (Entity passenger : passengers) {
//            if (!(passenger instanceof TextDisplay text))
//                continue;
//
//            Component displayText = getMobTitle(mobLvl, mobHealth, mobMaxHealth, entityName);
//            text.text(displayText);
//        }

        entity.setHealth(entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

        DamageMob damageMob = new DamageMob(SkyblockClone.getPlugin(), (int)damageAmount, didCrit, entity);
        damageMob.runTaskLater(SkyblockClone.getPlugin(), 20);

        if (mobHealth <= 0)
            entity.setHealth(0);
    }
}
