package net.luis.nero.init.world.dimension;

import net.luis.nero.Nero;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.level.Level;

public class ModDimensionWorlds {
	
    public static final ResourceKey<Level> DEEPSLATE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Nero.MOD_ID, "deepslate"));
    public static final ResourceKey<Level> TEST = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Nero.MOD_ID, "test"));

}
