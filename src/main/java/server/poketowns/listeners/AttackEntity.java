package server.poketowns.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.AttackEntityEvent;

import server.poketowns.supersmash.Inventories;

public class AttackEntity {
	@Listener
	public void onClickInventory(AttackEntityEvent e){
		if(e.getCause().root() instanceof Player){
			Player p = (Player)e.getCause().root();
			if(!Inventories.getInstance().hasInventory(p)){
				e.setCancelled(true);
			}
		}
	}
}
