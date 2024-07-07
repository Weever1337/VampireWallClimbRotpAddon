package it.hurts.weever.rotp_vamp_climb.action.non_stand;

import com.github.standobyte.jojo.action.non_stand.NonStandAction;
import com.github.standobyte.jojo.action.non_stand.VampirismAction;
import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.capability.entity.LivingUtilCapProvider;
import com.github.standobyte.jojo.capability.entity.PlayerUtilCapProvider;
import com.github.standobyte.jojo.init.power.non_stand.ModPowers;
import com.github.standobyte.jojo.power.impl.nonstand.INonStandPower;
import com.github.standobyte.jojo.power.impl.nonstand.type.hamon.HamonData;
import com.github.standobyte.jojo.power.impl.nonstand.type.hamon.HamonUtil;
import com.github.standobyte.jojo.power.impl.nonstand.type.hamon.skill.BaseHamonSkill.HamonStat;

import com.github.standobyte.jojo.power.impl.nonstand.type.vampirism.VampirismData;
import com.github.standobyte.jojo.util.mc.MCUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class VampWallClimb extends VampirismAction {
    public VampWallClimb(NonStandAction.Builder builder) {
        super(builder.holdType());
    }
    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, INonStandPower power, ActionTarget target) {
        if (user.horizontalCollision){
            return ActionConditionResult.POSITIVE;
        }
        return ActionConditionResult.NEGATIVE;
    }

    @Override
    protected void holdTick(World world, LivingEntity user, INonStandPower power, int ticksHeld, ActionTarget target, boolean requirementsFulfilled) {
        if (world.isClientSide() && user.horizontalCollision) {
            Vector3d movement = user.getLookAngle();
//            int final_energy = (int) (0.1D + (power.getEnergy() * 0.0025 + power.getMaxEnergy() * 0.0025));
            int final_energy = 4;
            user.setDeltaMovement(movement.x / final_energy, movement.y / final_energy, movement.z / final_energy);
        }
    }
}
