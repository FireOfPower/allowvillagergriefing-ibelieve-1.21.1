package com.AllowVillagerGriefing.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.EntityMobGriefingEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityMobGriefingEvent.class)
public abstract class MixinGamerule{

    @Shadow
    private boolean canGrief;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void EntityMobGriefingEventHead(Level level, Entity entity, CallbackInfo ci) {
        if(entity.getType() == EntityType.VILLAGER){
            this.canGrief = true;
        }
    }
}