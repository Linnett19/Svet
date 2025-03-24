package net.tehword.books;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class CustomScreen extends Screen {
    public CustomScreen() {
        super(Component.literal("Custom GUI"));
    }

    @Override
    protected void init() {
        // Добавление кнопок и других элементов
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);

        // Отрисовка текста
        guiGraphics.drawString(font, "This is a custom GUI!", width / 2 - 50, height / 2 - 10, 0xFFFFFF);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}