package server.poketowns.listeners;

import java.util.HashMap;
import java.util.Optional;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.supersmash.Inventories;

public class PlayerMove {
	@Listener
	public void onPlayerMove(MoveEntityEvent event){
		 Optional<Player> player_ = event.getCause().first(Player.class);
		 if (!player_.isPresent()) return;
		 Player player = player_.get();
		 if(Inventories.getInstance().hasInventory(player)){
			 double x = event.getToTransform().getLocation().getX();
			 double z = event.getToTransform().getLocation().getZ();
			 if(x<24460&&x>24323&&z<26871&&z>26736&&event.getTargetEntity().getWorld().getName().equals("world")){
	    		}else{
				 	player.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Cannot Move Here While In-Game! Type /game leave to leave!"));
	    			event.setCancelled(true);
	    		}
		 }
	}
}
