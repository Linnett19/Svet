package net.tehword.svet.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.tehword.svet.render.ItemWithBeamRenderer;

import java.util.HashMap;
import java.util.Map;

public class BeamItemRegistry {
    public static final Map<Item, ItemWithBeamRenderer.BeamProperties> ITEM_PROPERTIES = new HashMap<>();

    static {
        registerItemWithBeam(Items.DIAMOND, new int[]{0x415769, 0x415769, 0x415769}, 1.0F, 5);
        registerItemWithBeam(ModItems.TEH_WORD.get(), new int[]{0xebc4ff, 0xebc4ff}, 1.5F, 10);
        registerItemWithBeam(ModItems.LINNETT.get(), new int[]{0xebc4ff, 0x9bc0ca, 0x9bc0ca}, 1.5F, 10);
        registerItemWithBeam(Items.ENCHANTED_GOLDEN_APPLE, new int[]{0xffd700, 0xffa500, 0xff4500}, 2.0F, 8);


    //    registerItemWithBeam(Items.APPLE, new int[]{0xff0700, 0xff0700, 0xff0700}, 1.0F, 8);    //

    }

    public static void registerItemWithBeam(Item item, int[] colors, float beamLength, int beamCount) {
        ITEM_PROPERTIES.put(item, new ItemWithBeamRenderer.BeamProperties(colors, beamLength, beamCount));
    }
}

