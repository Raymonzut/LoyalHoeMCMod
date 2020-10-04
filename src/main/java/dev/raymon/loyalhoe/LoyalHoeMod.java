package dev.raymon.loyalhoe;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
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

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }
}
