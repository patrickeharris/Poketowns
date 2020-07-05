package server.poketowns.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.config.ConfigurationManager;
import server.poketowns.experience.ExperienceManager;
import server.poketowns.islands.Island;
import server.poketowns.islands.IslandManager;
import server.poketowns.pokestops.PokeStopManager;

public class Interact {
	//config
	private HashMap<Player, Long> cooldown = new HashMap<Player, Long>();
	private ArrayList<String> second = new ArrayList<String>();
	static Interact instance = new Interact();
	public static Interact getInstance(){
		return instance;
	}
	public void onStart(){
		ConfigurationManager.getInstance().loadConfig();
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("second").getChildrenMap().keySet()){
			Sponge.getServer().getBroadcastChannel().send(Text.of(s));
			String name = (String) s;
			second.add(name);
		}
	}
	@Listener
	public void onInteractBlock(InteractBlockEvent e){
		if(e.getCause().root() instanceof Player){
			Player p = (Player)e.getCause().root();
			if(p.getItemInHand(HandTypes.MAIN_HAND).isPresent()){
				ItemStack is = p.getItemInHand(HandTypes.MAIN_HAND).get();
				if(is.getItem().getId().equals("pixelmon:item.Trainer_Editor")){
					if(!p.hasPermission("use.wand")){
						p.kick(Text.of("No Using AN NPC Editor"));
					}
				}
				if(is.getItem().getId().equals("pixelmon:item.Trainer_Editor")){
					if(!p.hasPermission("use.wand")){
						p.kick(Text.of("No Using AN NPC Editor"));
					}
				}
			}
			if(e.getTargetBlock().getState().getType().equals(BlockTypes.WALL_SIGN)){
				ImmutableListValue<Text> iSignData = e.getTargetBlock().get(ImmutableSignData.class).get().lines();
				Text t1 = iSignData.get(0);
				Text t2 = iSignData.get(1);
				if(e.getTargetBlock().getLocation().get().getX()>-19000||e.getTargetBlock().getLocation().get().getX()<-19007||e.getTargetBlock().getLocation().get().getZ()>-11107||e.getTargetBlock().getLocation().get().getZ()<-11100){
					if(t2.equals(Text.of("For Free"))){
						p.getInventory().offer(ItemStack.of(ItemTypes.GOLDEN_SHOVEL, 1));
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Been Given 1 Golden Shovel!"));
					}
				}
				if(t1.equals(Text.of("PokeStop"))){
					PokeStopManager PokeStop = new PokeStopManager();
					if(cooldown.containsKey(p)){
						if(cooldown.get(p)>System.currentTimeMillis()){
							p.sendMessage(Text.of(TextColors.RED,"You Must Wait Before Using The PokeStop Again!"));
							return;
						}
						cooldown.remove(p);
					}
					try {
						PokeStop.PokeStop(p);
						ExperienceManager.getInstance().addXp(p, 100);
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Been Given 100 Experience!"));
						cooldown.put(p, System.currentTimeMillis()+3600000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(t1.equals(Text.of("Charmander"))){
					//set coords
					if(e.getTargetBlock().getLocation().get().getX()>24584||e.getTargetBlock().getLocation().get().getX()<24591||e.getTargetBlock().getLocation().get().getZ()>26699||e.getTargetBlock().getLocation().get().getZ()<26704){
						if(!second.contains(p.getName())){
							String st = "pokegive "+ p.getName()+ " charmander";
							Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
							second.add(p.getName());
							ConfigurationManager.getInstance().loadConfig();
					        ConfigurationManager.getInstance().getConfig().getNode("second", p.getName()).setValue(p.getName());
							ConfigurationManager.getInstance().saveConfig();
						}
					}
				}
				if(t1.equals(Text.of("Squirtle"))){
					//set coords
					if(e.getTargetBlock().getLocation().get().getX()>24584||e.getTargetBlock().getLocation().get().getX()<24591||e.getTargetBlock().getLocation().get().getZ()>26699||e.getTargetBlock().getLocation().get().getZ()<26704){
						if(!second.contains(p.getName())){
							String st = "pokegive "+ p.getName()+ " squirtle";
							Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
							second.add(p.getName());
							ConfigurationManager.getInstance().loadConfig();
					        ConfigurationManager.getInstance().getConfig().getNode("second", p.getName()).setValue(p.getName());
							ConfigurationManager.getInstance().saveConfig();
						}
					}
				}
				if(t1.equals(Text.of("Bulbasaur"))){
					//set coords
					if(e.getTargetBlock().getLocation().get().getX()>24584||e.getTargetBlock().getLocation().get().getX()<24591||e.getTargetBlock().getLocation().get().getZ()>26699||e.getTargetBlock().getLocation().get().getZ()<26704){
						if(!second.contains(p.getName())){
							String st = "pokegive "+ p.getName()+ " bulbasaur";
							Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
							second.add(p.getName());
							ConfigurationManager.getInstance().loadConfig();
					        ConfigurationManager.getInstance().getConfig().getNode("second", p.getName()).setValue(p.getName());
							ConfigurationManager.getInstance().saveConfig();
						}
					}
				}
			}
		}
	}
}
