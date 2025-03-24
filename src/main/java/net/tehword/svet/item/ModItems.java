package net.tehword.svet.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tehword.books.CustomScreen;
import net.tehword.books.book.BookScreen;
import net.tehword.svet.Svet;
import net.tehword.svet.item.Custom.GuiItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Svet.MOD_ID);






    public static final RegistryObject<Item> TEH_WORD = ITEMS.register("teh_word",
            () -> new Item(new Item.Properties().rarity(CustomRarities.ABYSS)));


    public static final RegistryObject<Item> LINNETT = ITEMS.register("linnett",
            () -> new Item(new Item.Properties().rarity(CustomRarities.APATHY)));

    // Пример регистрации предмета, который открывает BookScreen
    public static final RegistryObject<Item> BOOK = ITEMS.register("book", () -> new GuiItem(new Item.Properties(), () -> new BookScreen(EntityType.ZOMBIE)));

    // Пример регистрации предмета, который открывает CustomScreen
    public static final RegistryObject<Item> CUSTOM_GUI_ITEM = ITEMS.register("custom_gui_item", () -> new GuiItem(new Item.Properties(), CustomScreen::new));



    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().rarity(CustomRarities.COMMON)));





}
