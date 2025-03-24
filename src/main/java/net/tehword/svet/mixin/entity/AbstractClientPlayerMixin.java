package net.tehword.svet.mixin.entity;

import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.tehword.svet.Svet;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin {

    @Unique
    private static final List<String> CAPE_LEGENDARY = Arrays.asList("Linnett", "Dev");
    @Unique
    private static final List<String> CAPE_DEV = Arrays.asList("SpaceWalrus5000", "LoonLord32");


    @Shadow
    @Nullable
    protected abstract PlayerInfo getPlayerInfo();

    @Inject(
            method = "getCloakTextureLocation",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void faf$getCustomCapeTexture(CallbackInfoReturnable<ResourceLocation> cir) {
        PlayerInfo playerInfo = this.getPlayerInfo();

        if (playerInfo == null || playerInfo.getProfile() == null || playerInfo.getProfile().getName() == null) {
            return;
        }

        String playerName = playerInfo.getProfile().getName();

        if (CAPE_LEGENDARY.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(Svet.MOD_ID, "textures/entity/cape/legendary_cape.png"));
        } else if (CAPE_DEV.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(Svet.MOD_ID, "textures/entity/cape/legendary_cape.png"));
        }
    }
}