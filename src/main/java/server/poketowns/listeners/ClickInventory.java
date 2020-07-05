package server.poketowns.listeners;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import server.poketowns.supersmash.Abilities;
import server.poketowns.supersmash.Inventories;

public class ClickInventory {

	@Listener
	public void onClickInventory(ClickInventoryEvent e){
		if(e.getCause().root() instanceof Player){
			Player p = (Player)e.getCause().root();
			if(e.getTargetInventory().getName().get().equals("PokeStop")){
				e.setCancelled(true);
			}
			if(e.getTargetInventory().getName().get().equals("Select A Class!")){
				if(e.getCursorTransaction().getDefault().getType().equals(ItemTypes.BLAZE_ROD)){
					if(!Inventories.getInstance().hasInventory(p)){
						p.sendMessage(Text.of(TextColors.RED, "You Have Chosen Charmander!"));
						Abilities.getInstance().addPoke(p, "charmander");
						p.closeInventory(Cause.of(NamedCause.source(p)));
						Inventories.getInstance().addInventory(p, p.getInventory());
						p.getInventory().clear();
						ItemStack i1 = ItemStack.of(ItemTypes.BLAZE_ROD, 1);
						i1.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED,"Charmander's Rod of Fire"));
						p.getInventory().offer(i1);
						p.closeInventory(Cause.of(NamedCause.source(p)));
						//change coords
						Location<World>l = new Location<World>(Sponge.getServer().getWorld("world").get(),24390,65,26803);
						p.setLocation(l);
					}
				}
				if(e.getCursorTransaction().getDefault().getType().equals(ItemTypes.WATER_BUCKET)){
					if(!Inventories.getInstance().hasInventory(p)){
						p.sendMessage(Text.of(TextColors.BLUE, "You Have Chosen Squirtle!"));
						Abilities.getInstance().addPoke(p, "squirtle");
						p.closeInventory(Cause.of(NamedCause.source(p)));
						Inventories.getInstance().addInventory(p, p.getInventory());
						p.getInventory().clear();
						ItemStack i1 = ItemStack.of(ItemTypes.WATER_BUCKET, 1);
						i1.offer(Keys.DISPLAY_NAME, Text.of(TextColors.BLUE,"Squirtle's Cup of Water"));
						p.getInventory().offer(i1);
						p.closeInventory(Cause.of(NamedCause.source(p)));
						//change coords
						Location<World>l = new Location<World>(Sponge.getServer().getWorld("world").get(),24390,65,26803);
						p.setLocation(l);
					}
				}
				if(e.getCursorTransaction().getDefault().getType().equals(ItemTypes.GRASS)){
					if(!Inventories.getInstance().hasInventory(p)){
						p.sendMessage(Text.of(TextColors.GREEN, "You Have Chosen Bulbasaur!"));
						Abilities.getInstance().addPoke(p, "bulbasaur");
						p.closeInventory(Cause.of(NamedCause.source(p)));
						Inventories.getInstance().addInventory(p, p.getInventory());
						p.getInventory().clear();
						ItemStack i1 = ItemStack.of(ItemTypes.DIRT, 1);
						i1.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GREEN,"Bulbasaur's Block of Earth"));
						p.getInventory().offer(i1);
						p.closeInventory(Cause.of(NamedCause.source(p)));
						//change coords
						Location<World>l = new Location<World>(Sponge.getServer().getWorld("world").get(),24390,65,26803);
						p.setLocation(l);
					}
				}
				e.setCancelled(true);
			}
		}
	}
}
