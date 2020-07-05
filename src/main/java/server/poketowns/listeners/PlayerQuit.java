package server.poketowns.listeners;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;

import server.poketowns.supersmash.Inventories;

public class PlayerQuit {
	@Listener
	public void onPlayerQuit(ClientConnectionEvent.Disconnect e){
		if(Inventories.getInstance().hasInventory(e.getTargetEntity())){
			e.getTargetEntity().getInventory().clear();
			for(ItemStack i :Inventories.getInstance().getInventory(e.getTargetEntity())){
				if(i.getItem().equals(ItemTypes.CHAINMAIL_HELMET)||i.getItem().equals(ItemTypes.LEATHER_HELMET)||i.getItem().equals(ItemTypes.DIAMOND_HELMET)||i.getItem().equals(ItemTypes.GOLDEN_HELMET)||i.getItem().equals(ItemTypes.IRON_HELMET)){
					e.getTargetEntity().setHelmet(i);
				}else
					if(i.getItem().equals(ItemTypes.CHAINMAIL_CHESTPLATE)||i.getItem().equals(ItemTypes.LEATHER_CHESTPLATE)||i.getItem().equals(ItemTypes.DIAMOND_CHESTPLATE)||i.getItem().equals(ItemTypes.GOLDEN_CHESTPLATE)||i.getItem().equals(ItemTypes.IRON_CHESTPLATE)||i.getItem().equals(ItemTypes.ELYTRA)){
						e.getTargetEntity().setChestplate(i);
					}else
						if(i.getItem().equals(ItemTypes.CHAINMAIL_LEGGINGS)||i.getItem().equals(ItemTypes.LEATHER_LEGGINGS)||i.getItem().equals(ItemTypes.DIAMOND_LEGGINGS)||i.getItem().equals(ItemTypes.GOLDEN_LEGGINGS)||i.getItem().equals(ItemTypes.IRON_LEGGINGS)){
							e.getTargetEntity().setLeggings(i);
						}else
							if(i.getItem().equals(ItemTypes.CHAINMAIL_BOOTS)||i.getItem().equals(ItemTypes.LEATHER_BOOTS)||i.getItem().equals(ItemTypes.DIAMOND_BOOTS)||i.getItem().equals(ItemTypes.GOLDEN_BOOTS)||i.getItem().equals(ItemTypes.IRON_BOOTS)){
								e.getTargetEntity().setBoots(i);
							}else
								e.getTargetEntity().getInventory().offer(i);
			}
			Inventories.getInstance().removeInventory(e.getTargetEntity());
			if(PlayerDeath.getInstance().hasLives(e.getTargetEntity())){
				PlayerDeath.getInstance().removeLives(e.getTargetEntity());
			}
		}
	}
}
