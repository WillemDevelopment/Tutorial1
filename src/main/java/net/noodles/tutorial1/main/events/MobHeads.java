package net.noodles.tutorial1.main.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class MobHeads implements Listener {


    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        List<EntityType> types = Arrays.asList(EntityType.ZOMBIE, EntityType.SKELETON, EntityType.VILLAGER);
        if (!types.contains(e.getEntityType())) {
            return;
        }
        LivingEntity entity = (LivingEntity)e.getEntity();
        entity.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));

    }

}
