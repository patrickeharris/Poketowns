package server.poketowns.commands.island;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.biome.BiomeTypes;

import server.poketowns.islands.IslandManager;
import server.poketowns.supersmash.Inventories;

public class IslandSetBiome implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(IslandManager.getInstance().hasIsland(p.getName())){
				if(context.hasAny(Text.of("biome"))){
					String biome = (String) context.getOne(Text.of("biome")).get();
					if(getBiome(biome)!=null){
						IslandManager.getInstance().getIsland(p.getName()).setBiome(getBiome(biome));
						return CommandResult.successCount(1);
					}
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"That Is Not A Biome!"));
					return CommandResult.successCount(2);
				}
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Must Specify A Biome!"));
				return CommandResult.successCount(3);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Not Created An Island! Make One Now With /island create!"));
		}
		return CommandResult.success();
	}
	private BiomeType getBiome(String s){
		if(s.equalsIgnoreCase("beach")){
			return BiomeTypes.BEACH;
		}
		if(s.equalsIgnoreCase("birch_forest")){
			return BiomeTypes.BIRCH_FOREST;
		}
		if(s.equalsIgnoreCase("birch_forest_hills")){
			return BiomeTypes.BIRCH_FOREST_HILLS;
		}
		if(s.equalsIgnoreCase("birch_forest_hills_mountains")){
			return BiomeTypes.BIRCH_FOREST_HILLS_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("birch_forest_mountains")){
			return BiomeTypes.BIRCH_FOREST_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("cold_beach")){
			return BiomeTypes.COLD_BEACH;
		}
		if(s.equalsIgnoreCase("cold_taiga")){
			return BiomeTypes.COLD_TAIGA;
		}
		if(s.equalsIgnoreCase("cold_taiga_hills")){
			return BiomeTypes.COLD_TAIGA_HILLS;
		}
		if(s.equalsIgnoreCase("cold_taiga_mountains")){
			return BiomeTypes.COLD_TAIGA_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("deep_ocean")){
			return BiomeTypes.DEEP_OCEAN;
		}
		if(s.equalsIgnoreCase("desert")){
			return BiomeTypes.DESERT;
		}
		if(s.equalsIgnoreCase("desert_hills")){
			return BiomeTypes.DESERT_HILLS;
		}
		if(s.equalsIgnoreCase("desert_mountains")){
			return BiomeTypes.DESERT_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("extreme_hills")){
			return BiomeTypes.EXTREME_HILLS;
		}
		if(s.equalsIgnoreCase("extreme_hills_edge")){
			return BiomeTypes.EXTREME_HILLS_EDGE;
		}
		if(s.equalsIgnoreCase("extreme_hills_mountains")){
			return BiomeTypes.EXTREME_HILLS_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("extreme_hills_plus")){
			return BiomeTypes.EXTREME_HILLS_PLUS;
		}
		if(s.equalsIgnoreCase("extreme_hills_plus_mountains")){
			return BiomeTypes.EXTREME_HILLS_PLUS_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("flower_forest")){
			return BiomeTypes.FLOWER_FOREST;
		}
		if(s.equalsIgnoreCase("forest")){
			return BiomeTypes.FOREST;
		}
		if(s.equalsIgnoreCase("desert_hills")){
			return BiomeTypes.FOREST_HILLS;
		}
		if(s.equalsIgnoreCase("frozen_ocean")){
			return BiomeTypes.FROZEN_OCEAN;
		}
		if(s.equalsIgnoreCase("frozen_river")){
			return BiomeTypes.FROZEN_RIVER;
		}
		if(s.equalsIgnoreCase("hell")){
			return BiomeTypes.HELL;
		}
		if(s.equalsIgnoreCase("ice_mountains")){
			return BiomeTypes.ICE_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("ice_plains")){
			return BiomeTypes.ICE_PLAINS;
		}
		if(s.equalsIgnoreCase("ice_plains_spikes")){
			return BiomeTypes.ICE_PLAINS_SPIKES;
		}
		if(s.equalsIgnoreCase("jungle")){
			return BiomeTypes.JUNGLE;
		}
		if(s.equalsIgnoreCase("jungle_edge")){
			return BiomeTypes.JUNGLE_EDGE;
		}
		if(s.equalsIgnoreCase("jungle_edge_mountains")){
			return BiomeTypes.JUNGLE_EDGE_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("jungle_hills")){
			return BiomeTypes.JUNGLE_HILLS;
		}
		if(s.equalsIgnoreCase("jungle_mountains")){
			return BiomeTypes.JUNGLE_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("mega_spruce_taiga")){
			return BiomeTypes.MEGA_SPRUCE_TAIGA;
		}
		if(s.equalsIgnoreCase("mega_spruce_taiga_hills")){
			return BiomeTypes.MEGA_SPRUCE_TAIGA_HILLS;
		}
		if(s.equalsIgnoreCase("mega_taiga")){
			return BiomeTypes.MEGA_TAIGA;
		}
		if(s.equalsIgnoreCase("mega_taiga_hills")){
			return BiomeTypes.MEGA_TAIGA_HILLS;
		}
		if(s.equalsIgnoreCase("mesa")){
			return BiomeTypes.MESA;
		}
		if(s.equalsIgnoreCase("mesa_bryce")){
			return BiomeTypes.MESA_BRYCE;
		}
		if(s.equalsIgnoreCase("mesa_plateau")){
			return BiomeTypes.MESA_PLATEAU;
		}
		if(s.equalsIgnoreCase("mesa_plateau_forest")){
			return BiomeTypes.MESA_PLATEAU_FOREST;
		}
		if(s.equalsIgnoreCase("mesa_plateau_forest_mountains")){
			return BiomeTypes.MESA_PLATEAU_FOREST_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("mesa_plateau_mountains")){
			return BiomeTypes.MESA_PLATEAU_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("mushroom_island")){
			return BiomeTypes.MUSHROOM_ISLAND;
		}
		if(s.equalsIgnoreCase("mushroom_island_shore")){
			return BiomeTypes.MUSHROOM_ISLAND_SHORE;
		}
		if(s.equalsIgnoreCase("ocean")){
			return BiomeTypes.OCEAN;
		}
		if(s.equalsIgnoreCase("plains")){
			return BiomeTypes.PLAINS;
		}
		if(s.equalsIgnoreCase("river")){
			return BiomeTypes.RIVER;
		}
		if(s.equalsIgnoreCase("roofed_forest")){
			return BiomeTypes.ROOFED_FOREST;
		}
		if(s.equalsIgnoreCase("roofed_forest_mountains")){
			return BiomeTypes.ROOFED_FOREST_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("savanna")){
			return BiomeTypes.SAVANNA;
		}
		if(s.equalsIgnoreCase("savanna_mountains")){
			return BiomeTypes.SAVANNA_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("savanna_plateau")){
			return BiomeTypes.SAVANNA_PLATEAU;
		}
		if(s.equalsIgnoreCase("savanna_plateau_mountains")){
			return BiomeTypes.SAVANNA_PLATEAU_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("sky")){
			return BiomeTypes.SKY;
		}
		if(s.equalsIgnoreCase("stone_beach")){
			return BiomeTypes.STONE_BEACH;
		}
		if(s.equalsIgnoreCase("sunflower_plains")){
			return BiomeTypes.SUNFLOWER_PLAINS;
		}
		if(s.equalsIgnoreCase("swampland")){
			return BiomeTypes.SWAMPLAND;
		}
		if(s.equalsIgnoreCase("swampland_mountains")){
			return BiomeTypes.SWAMPLAND_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("taiga")){
			return BiomeTypes.TAIGA;
		}
		if(s.equalsIgnoreCase("taiga_hills")){
			return BiomeTypes.TAIGA_HILLS;
		}
		if(s.equalsIgnoreCase("taiga_mountains")){
			return BiomeTypes.TAIGA_MOUNTAINS;
		}
		if(s.equalsIgnoreCase("void")){
			return BiomeTypes.VOID;
		}
		return null;
	}
}
