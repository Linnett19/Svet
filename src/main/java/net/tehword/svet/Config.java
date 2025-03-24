package net.tehword.svet;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    // Пример конфигурационного параметра
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.IntValue EXAMPLE_CONFIG;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        // Пример настройки
        EXAMPLE_CONFIG = builder.comment("Example configuration")
                .defineInRange("exampleSetting", 42, 1, 100);

        SPEC = builder.build();
    }
}