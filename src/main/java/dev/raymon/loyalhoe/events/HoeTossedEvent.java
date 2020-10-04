package dev.raymon.loyalhoe.events;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import dev.raymon.loyalhoe.LoyalHoeMod;

@Mod.EventBusSubscriber(modid = LoyalHoeMod.MOD_ID, bus = Bus.FORGE)
public class HoeTossedEvent
{
    @SubscribeEvent
    public static void itemTossed(ItemTossEvent event)
    {
        ItemEntity itemEntity = event.getEntityItem();
        Item item = itemEntity.getItem().getItem();
        if (item instanceof HoeItem)
        {
            LoyalHoeMod.LOGGER.info("Tossed a hoe");
            itemEntity.addVelocity(0, 1.25, 0);
            itemEntity.setInfinitePickupDelay();
        }
    }
}
