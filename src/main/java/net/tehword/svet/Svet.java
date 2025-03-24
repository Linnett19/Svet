package net.tehword.svet;

import com.mojang.logging.LogUtils;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tehword.BookRegistrar;
import net.tehword.books.BookContainer;
import net.tehword.books.MenuTypeRegistry;
import net.tehword.books.api.BookAPI;
import net.tehword.books.book.BookData;
import net.tehword.svet.item.ModItems;
import org.slf4j.Logger;
import net.minecraft.world.flag.FeatureFlags;


@Mod(Svet.MOD_ID)
public class Svet {
    public static final String MOD_ID = "svet";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Регистрация MenuType
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MOD_ID);
    public static final RegistryObject<MenuType<BookContainer>> BOOK_CONTAINER = MENUS.register("book_container", () -> new MenuType<>(BookContainer::new, FeatureFlags.VANILLA_SET));

    public Svet() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModItems.ITEMS.register(modEventBus);
        MENUS.register(modEventBus); // Регистрация MenuType

        // Регистрация демонстрационной книги
        BookAPI.registerBook(new BookData("demo", "Demo Book", "Welcome to the demo book!"));

        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.TEH_WORD);
            event.accept(ModItems.LINNETT);
            event.accept(ModItems.BOOK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}