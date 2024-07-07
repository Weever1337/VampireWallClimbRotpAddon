package it.hurts.weever.rotp_vamp_climb;

import it.hurts.weever.rotp_vamp_climb.init.power.non_stand.vampirism.VampActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(VampClimbAddon.MOD_ID)
public class VampClimbAddon {
    public static final String MOD_ID = "rotp_vamp_climb";
    public static final Logger LOGGER = LogManager.getLogger();

    public VampClimbAddon() {
//        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        VampActions.loadRegistryObjects();
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
