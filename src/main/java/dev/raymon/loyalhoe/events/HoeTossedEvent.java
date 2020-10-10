package dev.raymon.loyalhoe.events;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.*;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.Map;

import dev.raymon.loyalhoe.LoyalHoeMod;

@Mod.EventBusSubscriber(modid = LoyalHoeMod.MOD_ID, bus = Bus.FORGE)
public class HoeTossedEvent
{
    @SubscribeEvent
    public static void itemTossed(ItemTossEvent event)
    {
        ItemEntity itemEntity = event.getEntityItem();
        Item item = itemEntity.getItem().getItem();

        if (item instanceof HoeItem){
            ItemStack itemStack = itemEntity.getItem();
            Map<Enchantment, Integer> enchantmentPairs = EnchantmentHelper.getEnchantments(itemStack);

            boolean hasLoyalty = enchantmentPairs.containsKey(Enchantments.LOYALTY);
            if (!hasLoyalty) {
                LoyalHoeMod.LOGGER.info("Tossed non-loyal hoe");
                itemEntity.addVelocity(0, 1.25, 0);
                itemEntity.setInfinitePickupDelay();
            }
        }
    }
}
