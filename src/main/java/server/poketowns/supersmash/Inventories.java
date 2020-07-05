package server.poketowns.supersmash;

import java.util.ArrayList;
import java.util.HashMap;

import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;

public class Inventories {
	private static Inventories instance = new Inventories();
	private HashMap<Player, ArrayList<ItemStack>> ingame = new HashMap<Player,ArrayList<ItemStack>>();
	
	public static Inventories getInstance(){
		return instance;
	}
	
	public void addInventory(Player p, Inventory i){
		//gives 2 of what is in offhand
		//add listener for player quit and plugin disable
		if(!ingame.containsKey(p)){
			ArrayList<ItemStack>is = new ArrayList<ItemStack>();
			if(p.getItemInHand(HandTypes.OFF_HAND).isPresent()){
				is.add(p.getItemInHand(HandTypes.OFF_HAND).get());
				p.setItemInHand(HandTypes.OFF_HAND, null);
			}
			for (Inventory slot:i.slots()){
				if (slot.peek().isPresent()){
					ItemStack item = slot.peek().get();
					is.add(item);
				}
			}
			ingame.put(p, is);
		}
	}
	public void removeInventory(Player p){
		if(ingame.containsKey(p)){
			ingame.remove(p);
			Abilities.getInstance().removePoke(p);
		}
	}
	public ArrayList<ItemStack> getInventory(Player p){
		if(ingame.containsKey(p)){
			return(ingame.get(p));
		}
		return null;
	}
	public Boolean hasInventory(Player p){
		if(!ingame.containsKey(p))
			return false;
		return true;
	}
	public HashMap<Player, ArrayList<ItemStack>> getMap(){
		return ingame;
	}
	

}
