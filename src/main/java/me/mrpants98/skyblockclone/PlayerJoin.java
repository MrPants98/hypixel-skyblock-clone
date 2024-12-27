package me.mrpants98.skyblockclone;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static org.bukkit.persistence.PersistentDataType.*;

import static me.mrpants98.skyblockclone.NamespaceKeys.*;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        p.getPersistentDataContainer().set(maxHealthKey, INTEGER, 100);
        p.getPersistentDataContainer().set(healthKey, INTEGER, p.getPersistentDataContainer().get(maxHealthKey, INTEGER));
        p.getPersistentDataContainer().set(defenseKey, INTEGER, 0);

        p.getPersistentDataContainer().set(strengthKey, INTEGER, 0);
        p.getPersistentDataContainer().set(critChanceKey, INTEGER, 30);
        p.getPersistentDataContainer().set(critDamageKey, INTEGER, 50);
        p.getPersistentDataContainer().set(baseDamageKey, INTEGER, 0);

    }

}
