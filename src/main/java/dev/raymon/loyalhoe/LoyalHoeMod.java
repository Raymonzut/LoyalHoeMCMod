package dev.raymon.loyalhoe;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.HoeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("loyalhoemod")
@Mod.EventBusSubscriber(modid = LoyalHoeMod.MOD_ID, bus = Bus.MOD)
public class LoyalHoeMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "loyalhoemod";
    public static LoyalHoeMod instance;

    public LoyalHoeMod()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        Enchantments.LOYALTY.type = EnchantmentType.create("Hoe", item -> item instanceof HoeItem);
    }
}
