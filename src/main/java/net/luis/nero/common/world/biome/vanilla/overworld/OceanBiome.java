package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.ModBiomeFeatures;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.vanilla.overworld.type.OceanBiomeType;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModSurfaceBuilders;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class OceanBiome extends OverworldBiome {
	
	protected final IBiomeType biomeType;
	
	public OceanBiome(BiomeEffects biomeEffects, IBiomeType biomeType) {
		super(biomeEffects, biomeType.getTemperature(), biomeType.getBiomeNoise());
		this.biomeType = biomeType;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return this.biomeType.getMobSpawnSettings();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return this.biomeType.getBiomeGenerationSettings();
	}
	
	@Override
	public ModBiomeFeatures getModFeatures() {
		ModBiomeFeatures modBiomeFeatures = super.getModFeatures();
		if (this.biomeType == OceanBiomeType.LEGACY_FORZEN_OCEAN) {
			modBiomeFeatures.setModSurfaceBuilder(() -> ConfiguredModSurfaceBuilders.LEGACY_FORZEN_OCEAN);
		}
		return modBiomeFeatures;
	}
	
	@Override
	public boolean isUnderground() {
		return false;
	}
	
	@Override
	public boolean isOcean() {
		return this.biomeType.isOcean();
	}
	
	@Override
	public boolean isBeach() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return this.biomeType.isIsland();
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.biomeType.isHilly();
	}
	
	@Override
	public boolean isWindswept() {
		return this.biomeType.isWindswept();
	}
	
}
