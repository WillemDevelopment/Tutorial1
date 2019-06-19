package net.noodles.tutorial1.main.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.Arrays;
import java.util.List;

public class HorseChange implements Listener {

    @EventHandler
    public void onHorseSpawn(EntitySpawnEvent e) {
        List<EntityType> types = Arrays.asList(EntityType.HORSE);
        if (!types.contains(e.getEntityType())) {
            return;
        }
        LivingEntity entity = (LivingEntity)e.getEntity();
        ((org.bukkit.entity.Horse) entity).setVariant(Horse.Variant.SKELETON_HORSE);

        }
    }
