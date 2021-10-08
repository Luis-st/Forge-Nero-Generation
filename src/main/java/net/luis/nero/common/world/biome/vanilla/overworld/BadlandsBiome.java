package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class BadlandsBiome extends OverworldBiome {
	
	protected final boolean windswept;
	protected final boolean wooded;
	
	public BadlandsBiome(BiomeEffects biomeEffects, double baseNoise, double noiseScale, boolean windswept, boolean wooded) {
		super(biomeEffects, 2.0F, baseNoise, baseNoise);
		this.windswept = windswept;
		this.wooded = wooded;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeUtil.getBadlandsSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeUtil.getBadlandsFeatures(this.windswept, this.wooded).build();
	}
	
	@Override
	public boolean isUnderground() {
		return false;
	}
	
	@Override
	public boolean isOcean() {
		return false;
	}
	
	@Override
	public boolean isBeach() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return false;
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return true;
	}
	
	@Override
	public boolean isWindswept() {
		return this.windswept;
	}
	
}
