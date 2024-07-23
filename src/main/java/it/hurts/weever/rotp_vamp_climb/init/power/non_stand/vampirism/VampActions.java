package it.hurts.weever.rotp_vamp_climb.init.power.non_stand.vampirism;

import com.github.standobyte.jojo.action.non_stand.NonStandAction;
import com.github.standobyte.jojo.action.non_stand.VampirismAction;
import com.github.standobyte.jojo.init.power.JojoCustomRegistries;
import com.github.standobyte.jojo.init.power.non_stand.vampirism.ModVampirismActions;
import com.github.standobyte.jojo.power.impl.nonstand.type.NonStandPowerType;
import com.github.standobyte.jojo.power.impl.nonstand.type.vampirism.VampirismPowerType;
import com.github.standobyte.jojo.util.general.LazySupplier;
import it.hurts.weever.rotp_vamp_climb.VampClimbAddon;
import it.hurts.weever.rotp_vamp_climb.action.non_stand.VampWallClimb;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import static com.github.standobyte.jojo.init.power.ModCommonRegisters.ACTIONS;
import static com.github.standobyte.jojo.init.power.ModCommonRegisters.NON_STAND_POWERS;
import com.github.standobyte.jojo.init.power.non_stand.ModPowers;
import net.minecraftforge.fml.common.Mod;
import static com.github.standobyte.jojo.init.power.non_stand.vampirism.ModVampirismActions.VAMPIRISM_ZOMBIE_SUMMON;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Supplier;

public class VampActions {
    public static void loadRegistryObjects() {}

    public static final Supplier<VampirismPowerType> VAMPIRISM = ModVampirismActions.VAMPIRISM;
    public static final RegistryObject<VampirismAction> VAMP_WALL_CLIMB = ACTIONS.register("vampirism_wall_climb",
            () -> new VampWallClimb(new NonStandAction.Builder().holdEnergyCost(5).needsFreeMainHand())
    );

    @Mod.EventBusSubscriber(modid = VampClimbAddon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void afterNonPowerRegister(@Nonnull final RegistryEvent.Register<NonStandPowerType<?>> event) {
            NonStandPowerType<?> vamp = VAMPIRISM.get();
            if (vamp != null) {
                try {
                    VampirismAction[] rightClickHotbar = (VampirismAction[]) VAMP_TYPE_RMB_HOTBAR.get(vamp);
                    VampirismAction[] edited = new VampirismAction[rightClickHotbar.length + 1];
                    edited[0] = rightClickHotbar[0];
                    edited[1] = VAMP_WALL_CLIMB.get();
                    System.arraycopy(rightClickHotbar, 1, edited, 2, rightClickHotbar.length - 1);
                    VAMP_TYPE_RMB_HOTBAR.set(vamp, edited);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                    System.out.println("[VAMP] EHHH FAIL");
                    throw new RuntimeException(e);
                }
            }
        }

        private static final Field VAMP_TYPE_RMB_HOTBAR = getField(NonStandPowerType.class, "abilities");

        private static Field getField(Class<?> clazz, String fieldName) {
            try {
                Field f = clazz.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f;
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
