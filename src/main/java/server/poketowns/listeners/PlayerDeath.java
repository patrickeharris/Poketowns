package server.poketowns.listeners;

import java.util.HashMap;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import server.poketowns.supersmash.Abilities;
import server.poketowns.supersmash.Inventories;;

public class PlayerDeath {
	HashMap<Player, Integer> lives = new HashMap<Player, Integer>();
	private static PlayerDeath instance = new PlayerDeath();
	@Listener
	public void onPlayerDeath(RespawnPlayerEvent e){
		if(Inventories.getInstance().hasInventory(e.getTargetEntity())){
			if(lives.containsKey(e.getTargetEntity())){
				lives.replace(e.getTargetEntity(), lives.get(e.getTargetEntity())-1);
				e.getTargetEntity().sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Have ",lives.get(e.getTargetEntity())," Lives Remaining!"));
				if(lives.get(e.getTargetEntity())==0){
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
					lives.remove(e.getTargetEntity());
					e.getTargetEntity().sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Have Been Eliminated!"));
					e.getTargetEntity().sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "If You Are Missing Items, Relog!"));
					return;
				}
				if(lives.get(e.getTargetEntity())>1){
					//change coords
					Location<World>l = new Location<World>(Sponge.getServer().getWorld("world").get(),0,100,0);
					Transform<World>loc = new Transform<World>(l);
					String poke = Abilities.getInstance().getPoke(e.getTargetEntity());
					if(poke=="charmander"){
						Abilities.getInstance().passiveCharmander(e.getTargetEntity());
						ItemStack i1 = ItemStack.of(ItemTypes.BLAZE_ROD, 1);
						i1.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED,"Charmander's Rod of Fire"));
						e.getTargetEntity().getInventory().offer(i1);
						Location<World>l2 = new Location<World>(Sponge.getServer().getWorld("world").get(),24390,65,26803);
						e.getTargetEntity().setLocation(l2);
					}
					if(poke=="squirtle"){
						Abilities.getInstance().passiveSquirtle(e.getTargetEntity());
						ItemStack i1 = ItemStack.of(ItemTypes.WATER_BUCKET, 1);
						i1.offer(Keys.DISPLAY_NAME, Text.of(TextColors.BLUE,"Squirtle's Cup of Water"));
						e.getTargetEntity().getInventory().offer(i1);
						Location<World>l2 = new Location<World>(Sponge.getServer().getWorld("world").get(),24390,65,26803);
						e.getTargetEntity().setLocation(l2);
					}
					if(poke=="bulbasaur"){
						Abilities.getInstance().passiveBulbasaur(e.getTargetEntity());
						ItemStack i1 = ItemStack.of(ItemTypes.DIRT, 1);
						i1.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GREEN,"Bulbasaur's Block of Earth"));
						e.getTargetEntity().getInventory().offer(i1);
						Location<World>l2 = new Location<World>(Sponge.getServer().getWorld("world").get(),24390,65,26803);
						e.getTargetEntity().setLocation(l2);
					}
				}
				return;
			}
			lives.put(e.getTargetEntity(), 4);
			e.getTargetEntity().sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Have ",lives.get(e.getTargetEntity())," Lives Remaining!"));
			//change coords
			Location<World>l = new Location<World>(Sponge.getServer().getWorld("world").get(),0,100,0);
			Transform<World>loc = new Transform<World>(l);
			String poke = Abilities.getInstance().getPoke(e.getTargetEntity());
			if(poke=="charmander"){
				Abilities.getInstance().passiveCharmander(e.getTargetEntity());
			}
			if(poke=="squirtle"){
				Abilities.getInstance().passiveSquirtle(e.getTargetEntity());
			}
			if(poke=="bulbasaur"){
				Abilities.getInstance().passiveBulbasaur(e.getTargetEntity());
			}
			Location<World>l2 = new Location<World>(Sponge.getServer().getWorld("world").get(),24390,65,26803);
			e.getTargetEntity().setLocation(l2);
		}
	}
	public boolean hasLives(Player p){
		if(lives.containsKey(p))
			return true;
		return false;
	}
	public void removeLives(Player p){
		lives.remove(p);
	}
	public static PlayerDeath getInstance(){
		return instance;
	}
}
