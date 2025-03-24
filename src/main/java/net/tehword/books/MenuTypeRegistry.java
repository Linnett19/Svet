package net.tehword.books;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tehword.svet.Svet;

public class MenuTypeRegistry {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Svet.MOD_ID);

    public static final RegistryObject<MenuType<BookContainer>> BOOK_CONTAINER = MENUS.register("book_container", () -> new MenuType<>(BookContainer::new, FeatureFlags.VANILLA_SET));
}