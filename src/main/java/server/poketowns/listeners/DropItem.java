package server.poketowns.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.event.item.inventory.DropItemEvent;

import server.poketowns.supersmash.Inventories;

public class DropItem {
	@Listener
	public void onDropItem(DropItemEvent.Pre e){
		if(e.getCause().root() instanceof Player){
			Player p = (Player)e.getCause().root();
			if(Inventories.getInstance().hasInventory(p)){
				e.setCancelled(true);
			}
		}
	}
}
