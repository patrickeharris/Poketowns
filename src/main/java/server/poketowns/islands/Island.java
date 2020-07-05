package server.poketowns.islands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.biome.BiomeType;

import server.poketowns.config.ConfigurationManager;

public class Island {
	private String owner;
	private BiomeType biome;
	private Location<World> middle;
	private Location<World> home;
	public Island(String owner, BiomeType biome, Location<World> middle, Location<World> home){
		this.owner=owner;
		this.biome=biome;
		this.middle=middle;
		this.home=home;
	}
	public String getOwner(){
		return owner;
	}
	public Location<World> getMiddle(){
		return middle;
	}
	public BiomeType getBiome(){
		return biome;
	}
	public Location<World> getHome(){
		return home;
	}
	public void setHome(Location<World> home){
		this.home = home;
		ConfigurationManager.getInstance().loadConfig();
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("island").getChildrenMap().keySet()){
			if(Double.valueOf((String) s)==getMiddle().getX()){
				ConfigurationManager.getInstance().getConfig().getNode("island").removeChild(s);
			}
		}
		ConfigurationManager.getInstance().saveConfig();
		ConfigurationManager.getInstance().loadConfig();
		ConfigurationManager.getInstance().getConfig().getNode("island", getMiddle().getX(), getOwner(), getMiddle().getX(), getMiddle().getY(), getMiddle().getZ(), getHome().getX(), getHome().getY(), getHome().getZ()).setValue(getHome().getZ());
		ConfigurationManager.getInstance().saveConfig();
	}
	public void setOwner(String name){
		this.owner = name;
	}
	public void setBiome(BiomeType biome){
		this.biome = biome;
		int highx = this.getMiddle().getBlockX()+10;
		int highz = this.getMiddle().getBlockZ()+10;
		int highy = this.getMiddle().getBlockY()-25;
		int x1 = this.getMiddle().getBlockX()-10;
		int z1 = this.getMiddle().getBlockZ()-10;
		int y1 = this.getMiddle().getBlockY()-25;
		for (int x = x1; x <= highx; x++) {
			for (int y = y1; y <= highy; y++) {
				for (int z = z1; z <= highz; z++){
		           Sponge.getServer().getWorld("islands").get().setBiome(x, y, z, biome);
		        }
		    }
		}
	}
}
