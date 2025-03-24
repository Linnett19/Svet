package net.tehword.svet.item.Custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Supplier;

public class GuiItem extends Item {
    private final Supplier<Screen> screenSupplier;

    public GuiItem(Properties properties, Supplier<Screen> screenSupplier) {
        super(properties);
        this.screenSupplier = screenSupplier;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) {
            Minecraft.getInstance().setScreen(screenSupplier.get());
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}