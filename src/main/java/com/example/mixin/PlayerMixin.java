package com.example.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends Entity {

    public PlayerMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick()V", at = @At("TAIL"))
    private void playerTick(CallbackInfo ci) {
        if (getBlockStateAtPos().isOf(Blocks.WATER)) {
            setNoGravity(true);
        }
        else {
            setNoGravity(false);
        }
    }
}

