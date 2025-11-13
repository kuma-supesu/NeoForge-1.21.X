package net.kuma.tutorialmod.trim;

import net.kuma.tutorialmod.TutorialMod;
import net.kuma.tutorialmod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> KUMA = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "kuma"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.KUMA_SMITHING_TEMPLATE, KUMA);
    }

    private static void register(BootstrapContext<TrimPattern> context, DeferredItem<Item> item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), item.getDelegate(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}