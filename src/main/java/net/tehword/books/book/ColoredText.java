package net.tehword.books.book;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.ChatFormatting;

public class ColoredText {
    public static MutableComponent getColoredText() {
        // Создаём компоненты для каждого слова
        MutableComponent linup = Component.literal("Линуп").withStyle(ChatFormatting.GOLD); // Оранжевый
        MutableComponent techword = Component.literal("Техворд").withStyle(ChatFormatting.LIGHT_PURPLE); // Фиолетовый
        MutableComponent restOfText = Component.literal(" самый крутой кодеры в СНГ!");

        // Собираем всё в один текст
        return linup.append(" и ").append(techword).append(restOfText);
    }
}