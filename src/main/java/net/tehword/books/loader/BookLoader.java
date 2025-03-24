package net.tehword.books.loader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.tehword.books.book.BookData;
import net.tehword.books.book.BookRegistry;

import java.util.Map;

public class BookLoader extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = new Gson();

    public BookLoader() {
        super(GSON, "books");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> resources, ResourceManager manager, ProfilerFiller profiler) {
        for (Map.Entry<ResourceLocation, JsonElement> entry : resources.entrySet()) {
            ResourceLocation location = entry.getKey();
            JsonElement element = entry.getValue();

            // Парсинг JSON
            BookData bookData = GSON.fromJson(element, BookData.class);
            BookRegistry.register(bookData);
        }
    }
}