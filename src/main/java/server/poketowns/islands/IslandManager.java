package server.poketowns.islands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.util.RespawnLocation;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldArchetypes;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.biome.BiomeTypes;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import server.poketowns.config.ConfigurationManager;

public class IslandManager {
	//islands : save to config, load from config
	//server shop : when right click sign, make inventory with sections, make inventory with items, get balance, buy item, sell item
	//gym commands : all gyms (owner, type, lvl min, lvl max), online gyms, win command(for leader)(gives badge), loss command(for leader), player stats, gym/gym leader stats
	//broadcast messages
	//combine pixelmon/nucleus money?
	//website shop
	//voting
	//pokestops
	private static IslandManager instance = new IslandManager();
	private HashMap<Double, Island> island = new HashMap<Double, Island>();
	private HashMap<String, ArrayList<String>> invites = new HashMap<String, ArrayList<String>>();
	public static IslandManager getInstance(){
		return instance;
	}
	public void onStart(){
		if(!Sponge.getServer().getWorld("islands").isPresent()){
			try {
				Sponge.getServer().createWorldProperties("islands", WorldArchetypes.THE_VOID);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Sponge.getServer().loadWorld("islands");
		//load from config
		Location<World> mid = new Location<World>(Sponge.getServer().getWorld("islands").get(),0,25,0);
		Island i = new Island("spypt", BiomeTypes.VOID,mid,mid);
		island.put(mid.getX(), i);
		ConfigurationManager.getInstance().loadConfig();
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("island").getChildrenMap().keySet()){
			String id = s.toString();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("island",id).getChildrenMap().keySet()){
				String owner = s2.toString();
				for(Object s3: ConfigurationManager.getInstance().getConfig().getNode("island",id,owner).getChildrenMap().keySet()){
					String midX = s3.toString();
					for(Object s4: ConfigurationManager.getInstance().getConfig().getNode("island",id,owner,midX).getChildrenMap().keySet()){
						String midY = s4.toString();
						for(Object s5: ConfigurationManager.getInstance().getConfig().getNode("island",id,owner,midX,midY).getChildrenMap().keySet()){
							String midZ = s5.toString();
							for(Object s6: ConfigurationManager.getInstance().getConfig().getNode("island",id,owner,midX,midY,midZ).getChildrenMap().keySet()){
								String homeX = s6.toString();
								for(Object s7: ConfigurationManager.getInstance().getConfig().getNode("island",id,owner,midX,midY,midZ,homeX).getChildrenMap().keySet()){
									String homeY = s7.toString();
									for(Object s8: ConfigurationManager.getInstance().getConfig().getNode("island",id,owner,midX,midY,midZ,homeX,homeY).getChildrenMap().keySet()){
										String homeZ = s8.toString();
										Location<World>mid2 =new Location<World>(Sponge.getServer().getWorld("islands").get(),Double.valueOf(midX),Double.valueOf(midY),Double.valueOf(midZ));
										Location<World>home =new Location<World>(Sponge.getServer().getWorld("islands").get(),Double.valueOf(homeX),Double.valueOf(homeY),Double.valueOf(homeZ));
										Island i2 = new Island(owner,mid2.getBiome(),mid2,home);
										island.put(Double.valueOf(id), i2);
									}
								}
							}
						}
					}
				}
			}
		}
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("islandinvite").getChildrenMap().keySet()){
			String owner = s.toString();
			ArrayList<String>toInvites = new ArrayList<String>();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("islandinvite",owner).getChildrenMap().keySet()){
				toInvites.add(s2.toString());
			}
			invites.put(owner, toInvites);
		}
	}
	public void createIsland(Player owner){
		if(hasIsland(owner.getName())){
			owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Alrady Have An Island! Use /island home To Get There!"));
			return;
		}
		double testInt = 0;
			for(Island i : island.values()){
				if(i.getMiddle().getX()>testInt){
					testInt = i.getMiddle().getX();
				}
			}
			Location<World> previous = island.get(testInt).getMiddle();
			Location<World> mid = new Location<World>(previous.getExtent(), previous.getBlockX()+40, previous.getBlockY(),  previous.getBlockZ()+40);
			Location<World> home = new Location<World>(previous.getExtent(), previous.getBlockX()+40, previous.getBlockY()+1,  previous.getBlockZ()+40);
			Island i = new Island(owner.getName(), BiomeTypes.VOID, mid, home);
			island.put(mid.getX(), i);
	        ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("island", mid.getX(), owner.getName(), mid.getX(), mid.getY(), mid.getZ(), home.getX(), home.getY(), home.getZ()).setValue(home.getZ());
	        //ConfigurationManager.getInstance().getConfig().getNode("islands","n",size1,owner.getName(), i.getMiddle().getBlockX(), i.getMiddle().getBlockY(),i.getMiddle().getBlockZ(), i.getMiddle().getBlockX(), i.getMiddle().getBlockY(),i.getMiddle().getBlockZ()).setValue(i.getMiddle().getBlockZ());
	        ConfigurationManager.getInstance().saveConfig();
			int highX = previous.getBlockX()+50;
			int highZ =  previous.getBlockZ()+50;
			int highY = previous.getBlockY();
			int lowX = previous.getBlockX()+30;
			int lowZ =  previous.getBlockZ()+30;
			int lowY = previous.getBlockY()-25;
			for (int x = lowX; x <= highX; x++) {
				for (int y = lowY; y <= highY; y++) {
					for (int z = lowZ; z <= highZ; z++){
						NamedCause cause = NamedCause.source(Sponge.getPluginManager().getPlugin("server").get());
						Sponge.getServer().getWorld("islands").get().setBlockType(x, y, z, BlockTypes.DIRT, Cause.of(cause));
		            }
		        }
		    }
			owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"Island Successfully Created! Use /island home To Get There!"));
		}
	public void removeIsland(Player owner){
		for(Island i : island.values()){
			if(i.getOwner().equals(owner.getName())){
						ConfigurationManager.getInstance().loadConfig();
						for(Object s: ConfigurationManager.getInstance().getConfig().getNode("island").getChildrenMap().keySet()){
							if(Double.valueOf((String) s)==i.getMiddle().getX()){
								ConfigurationManager.getInstance().getConfig().getNode("island").removeChild(s);
							}
						}
						ConfigurationManager.getInstance().saveConfig();
						i.setOwner("");
						//change to spawn coords
						Location<World>spawn = new Location<World>(Sponge.getServer().getWorld("world").get(),0,100,0);
						if(owner.getLocation().getExtent().getName().equals("islands")){
							owner.setLocation(spawn);
						}
						if(owner.get(Keys.RESPAWN_LOCATIONS).isPresent()){
							for(RespawnLocation r : owner.get(Keys.RESPAWN_LOCATIONS).get().values()){
								if(r.asLocation().get().getExtent().equals("islands")){
									owner.get(Keys.RESPAWN_LOCATIONS).get().remove(owner.getUniqueId(), r);
									if(owner.get(Keys.RESPAWN_LOCATIONS).get().isEmpty()){
										owner.get(Keys.RESPAWN_LOCATIONS).get().put(owner.getUniqueId(), RespawnLocation.builder().location(spawn).build());
									}
								}
							}
						}
						int highX = i.getMiddle().getBlockX()+10;
						int highZ = i.getMiddle().getBlockZ()+10;
						int highY = i.getMiddle().getBlockY()+200;
						int lowX = i.getMiddle().getBlockX()-10;
						int lowZ = i.getMiddle().getBlockZ()-10;
						int lowY = i.getMiddle().getBlockY()-25;
						for (int x = lowX; x <= highX; x++) {
							for (int y = lowY; y <= highY; y++) {
								for (int z = lowZ; z <= highZ; z++){
									if(Sponge.getServer().getWorld("islands").get().getBlockType(x, y, z)!=BlockTypes.AIR){
										NamedCause cause = NamedCause.source(Sponge.getPluginManager().getPlugin("server").get());
										Sponge.getServer().getWorld("islands").get().setBlockType(x, y, z, BlockTypes.AIR, Cause.of(cause));
									}
					            }
					        }
					    }
						if(invites.containsKey(owner.getName())){
							invites.remove(owner.getName());
						}
						owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Successfully Removed Your Island!"));
						return;
			}
		}
		owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Do Not Own An Island! Create One Now With /island create!"));
		return;
	}
	public Island getIsland(String owner){
		for(Island i : island.values()){
			if(i.getOwner().equals(owner)){
				return i;
			}
		}
		return null;
	}
	public boolean hasIsland(String owner){
		for(Island i : island.values()){
			if(i.getOwner().equals(owner)){
				return true;
			}
		}
		return false;
	}
	public void invite(Player owner, Player invite){
		if(hasIsland(owner.getName())){
			if(invites.containsKey(owner.getName())){
				if(invites.get(owner.getName()).contains(invite.getName())){
					owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,invite.getName(), " Has Already Been Invited To Your Island!"));
					return;
				}
				ArrayList<String>newInvite = invites.get(owner.getName());
				newInvite.add(invite.getName());
				invites.replace(owner.getName(), newInvite);
				ConfigurationManager.getInstance().loadConfig();
				ConfigurationManager.getInstance().getConfig().getNode("islandinvite",owner.getName(),invite.getName()).setValue(invite.getName());
				ConfigurationManager.getInstance().saveConfig();
				owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,invite.getName()," Has Successfully Been Invited To Your Island!"));
				return;
			}
			ArrayList<String>newInvite = new ArrayList<String>();
			newInvite.add(invite.getName());
			invites.put(owner.getName(), newInvite);
			ConfigurationManager.getInstance().loadConfig();
			ConfigurationManager.getInstance().getConfig().getNode("islandinvite",owner.getName(),invite.getName()).setValue("1");
			ConfigurationManager.getInstance().saveConfig();
			owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,invite.getName()," Has Successfully Been Invited To Your Island!"));
			return;
		}
		owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Do Not Own An Island! Make One Now With /island create!"));
	}
	public void removeInvite(Player owner, String invite){
		if(hasIsland(owner.getName())){
			if(invites.containsKey(owner.getName())){
				if(invites.get(owner.getName()).contains(invite)){
					ArrayList<String>newInvite = invites.get(owner.getName());
					newInvite.remove(invite);
					invites.replace(owner.getName(), newInvite);
					ConfigurationManager.getInstance().loadConfig();
					for(Object s: ConfigurationManager.getInstance().getConfig().getNode("islandinvite",owner.getName()).getChildrenMap().keySet()){
						if((String) s==invite){
							ConfigurationManager.getInstance().getConfig().getNode("islandinvite",owner.getName()).removeChild(s);
						}
					}
					ConfigurationManager.getInstance().saveConfig();
					owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,invite," Has Successfully Been Removed From Your Island!"));
					return;
				}
				owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,invite," Has Not Been Invited To Your Island! Invite People With /island invite name!"));
				return;
			}
			owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Not Invited Anyone To Your Island! Invite People With /island invite name!"));
			return;
		}
		owner.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Do Not Own An Island! Make One Now With /island create!"));
	}
	public boolean invited(String owner, Player invite){
		if(hasIsland(owner)){
			if(invites.containsKey(owner)){
				if(invites.get(owner).contains(invite.getName())){
					return true;
				}
			}
		}
		return false;
	}
	public ArrayList<Island> invites(Player invite){
		ArrayList<Island>islands = new ArrayList<Island>();
		if(hasIsland(invite.getName())){
			islands.add(getIsland(invite.getName()));
		}
		for(ArrayList<String> i : invites.values()){
			if(i.contains(invite.getName())){
				for(String name: invites.keySet()){
					if(invites.get(name).equals(i)){
						islands.add(getIsland(name));
					}
				}
			}
		}
		return islands;
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
