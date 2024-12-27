package me.mrpants98.skyblockclone;

import me.mrpants98.skyblockclone.Configs.MobValues;
import me.mrpants98.skyblockclone.Holograms.MobTitle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.persistence.PersistentDataType;
import static me.mrpants98.skyblockclone.NamespaceKeys.*;

public class EntitySpawn implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {

        if (!(e.getEntity() instanceof LivingEntity spawned) || e.getEntity() instanceof Player)
            return;

        EntityType mobType = spawned.getType();

        int entityLevel = MobValues.get().getInt("lvl." + mobType.toString());
        int entityHealth = MobValues.get().getInt("maxHealth." + mobType.toString());
        int entityMaxHealth = MobValues.get().getInt("maxHealth." + mobType.toString());;
        int defense = MobValues.get().getInt("defense." + mobType.toString());

        String entityName = mobType.name().substring(0, 1) + mobType.name().substring(1).toLowerCase();

        spawned.getPersistentDataContainer().set(lvlKey, PersistentDataType.INTEGER, entityLevel);
        spawned.getPersistentDataContainer().set(healthKey, PersistentDataType.INTEGER, entityHealth);
        spawned.getPersistentDataContainer().set(maxHealthKey, PersistentDataType.INTEGER, entityMaxHealth);
        spawned.getPersistentDataContainer().set(defenseKey, PersistentDataType.INTEGER, defense);

        spawned.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(10000);
        
        MobTitle title = new MobTitle(SkyblockClone.getPlugin(), entityLevel, entityHealth, entityMaxHealth, entityName, spawned);
        title.runTaskTimer(SkyblockClone.getPlugin(), 0, 1);
    }
}
