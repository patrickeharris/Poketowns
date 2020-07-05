package server.poketowns.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.islands.Island;
import server.poketowns.islands.IslandManager;
import server.poketowns.supersmash.Abilities;
import server.poketowns.supersmash.Inventories;

public class LeftClick {
	@Listener
	public void onLeftClick(InteractBlockEvent.Primary.MainHand e){
		if(e.getCause().root() instanceof Player){
			Player p = (Player)e.getCause().root();
			if(Inventories.getInstance().hasInventory(p)){
				String poke = Abilities.getInstance().getPoke(p);
				if(poke=="charmander"){
					Abilities.getInstance().primaryCharmander(p);
				}
				if(poke=="squirtle"){
					Abilities.getInstance().primarySquirtle(p);
				}
				if(poke=="bulbasaur"){
					Abilities.getInstance().primaryBulbasaur(p);
				}
				e.setCancelled(true);
			}
			if(p.getLocation().getExtent().getName().equals("islands")){
				ArrayList<Island>islands = IslandManager.getInstance().invites(p);
				ArrayList<Island>islands2 = IslandManager.getInstance().invites(p);
				if(!islands.isEmpty()){
					if(e.getTargetBlock().getState().getType()==BlockTypes.AIR){
						return;
					}
					HashMap<Player, Integer>ints = new HashMap<Player, Integer>();
					ints.put(p, islands.size());
					for(Island island:islands){
						if(e.getTargetBlock().getLocation().get().getBlockX()>island.getMiddle().getBlockX()-11&&e.getTargetBlock().getLocation().get().getBlockX()<island.getMiddle().getBlockX()+11&&e.getTargetBlock().getLocation().get().getBlockZ()>island.getMiddle().getBlockZ()-11&&e.getTargetBlock().getLocation().get().getBlockZ()<island.getMiddle().getBlockZ()+11){
							islands2.remove(island);
						}
					}
					if(islands2.size()==ints.get(p)){
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Edit An Island You Have Not Made Or Do Not Have Perms To!"));
						e.setCancelled(true);
						return;
					}
				}else{
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Edit An Island You Have Not Made Or Do Not Have Perms To!"));
					e.setCancelled(true);
					return;
				}
			}
		}
	}
}
