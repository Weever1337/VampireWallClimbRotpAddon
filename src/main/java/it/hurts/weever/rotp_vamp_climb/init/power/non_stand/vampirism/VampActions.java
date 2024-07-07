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

//    public static final Supplier<VampirismPowerType> VAMPIRISM = ModVampirismActions.VAMPIRISM;
//    public static final LazySupplier<NonStandPowerType<?>> VAMPIRISM = new LazySupplier<>(
//            () -> JojoCustomRegistries.NON_STAND_POWERS.fromId(new ResourceLocation("jojo", "vampirism")));
    public static final RegistryObject<VampirismAction> VAMP_WALL_CLIMB = ACTIONS.register("vampirism_wall_climb",
            () -> new VampWallClimb(new NonStandAction.Builder().holdEnergyCost(5).needsFreeMainHand().shiftVariationOf(VAMPIRISM_ZOMBIE_SUMMON))
    );

//    @Mod.EventBusSubscriber(modid = VampClimbAddon.MOD_ID)
//    public static class RegistryEvents {
//        @SubscribeEvent(priority = EventPriority.LOW)
//        public static void afterNonPowerRegister(@Nonnull final RegistryEvent.Register<NonStandPowerType<?>> event) {
//            NonStandPowerType<?> vamp = VAMPIRISM.get();
//            try {
//                VampirismAction[] abilities = (VampirismAction[]) VAMP_TYPE_RMB_HOTBAR.get(vamp);
//                System.out.println("[VAMP] try");
//                System.out.println(Arrays.toString(abilities));
//                VampirismAction[] edited = new VampirismAction[abilities.length + 1];
//                System.out.println(Arrays.toString(edited));
//                edited[0] = abilities[0];
//                edited[1] = VAMP_WALL_CLIMB.get();
//                System.out.println(Arrays.toString(edited));
//                System.arraycopy(abilities, 1, edited, 2, abilities.length - 1);
//                System.out.println(Arrays.toString(abilities));
//                VAMP_TYPE_RMB_HOTBAR.set(vamp, edited);
//            } catch (IllegalArgumentException | IllegalAccessException e) {
//                e.printStackTrace();
//                System.out.println("[VAMP] EHHH FAIL");
//                throw new RuntimeException(e);
//            }
//        }
//
//        private static final Field VAMP_TYPE_RMB_HOTBAR = getField(NonStandPowerType.class, "abilities");
//
//        private static Field getField(Class<?> clazz, String fieldName) {
//            try {
//                Field f = clazz.getDeclaredField(fieldName);
//                f.setAccessible(true);
//                return f;
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//    }
}
