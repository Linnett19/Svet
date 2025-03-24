package net.tehword.books;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.tehword.books.MenuTypeRegistry;

public class BookContainer extends AbstractContainerMenu {
    public BookContainer(int containerId, Inventory playerInventory) {
        super(MenuTypeRegistry.BOOK_CONTAINER.get(), containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY; // Возвращаем пустой ItemStack
    }

    @Override
    public boolean stillValid(Player player) {
        return true; // Проверка, может ли игрок взаимодействовать с контейнером
    }
}