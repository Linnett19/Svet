package net.tehword.books.book;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.tehword.svet.Svet;

public class BookScreen extends Screen {
    private static final ResourceLocation BOOK_TEXTURE = new ResourceLocation(Svet.MOD_ID, "textures/gui/book.png");
    private static final int TEXTURE_WIDTH = 255; // Ширина текстуры
    private static final int TEXTURE_HEIGHT = 250; // Высота текстуры

    private final Entity entity; // Сущность для отображения

    public BookScreen(EntityType<?> entityType) {
        super(Component.literal("Book GUI"));

        // Создаём сущность для отображения
        Level level = Minecraft.getInstance().level;
        if (level != null) {
            this.entity = entityType.create(level);
        } else {
            this.entity = null;
        }
    }

    @Override
    protected void init() {
        // Добавление кнопок и других элементов
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);

        // Отрисовка текстуры
        int x = (this.width - TEXTURE_WIDTH) / 2; // Центрирование по горизонтали
        int y = (this.height - TEXTURE_HEIGHT) / 2; // Центрирование по вертикали
        guiGraphics.blit(BOOK_TEXTURE, x, y, 0, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        // Получаем текст с разными цветами
        MutableComponent coloredText = ColoredText.getColoredText();

        // Отрисовка текста
        int textX = x + 20; // Позиция текста по X
        int textY = y + 20; // Позиция текста по Y
        guiGraphics.drawString(font, coloredText, textX, textY, 0xFFFFFF, false); // Отрисовка текста

        // Отрисовка сущности
        if (entity != null) {
            renderEntity(guiGraphics, x + 100, y + 100, 30, mouseX, mouseY);
        }

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    private void renderEntity(GuiGraphics guiGraphics, int x, int y, int size, int mouseX, int mouseY) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;

            // Поворот сущности к курсору
            float angle = (float) Math.atan2(mouseY - y, mouseX - x);
            livingEntity.yBodyRot = (float) Math.toDegrees(angle) + 90;
            livingEntity.yHeadRot = livingEntity.yBodyRot;
        }

        // Отрисовка сущности
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(x, y, 50.0F);
        guiGraphics.pose().scale(size, size, size);

        Minecraft.getInstance().getEntityRenderDispatcher().render(entity, 0, 0, 0, 0, 1, guiGraphics.pose(), guiGraphics.bufferSource(), 15728880);

        guiGraphics.pose().popPose();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}