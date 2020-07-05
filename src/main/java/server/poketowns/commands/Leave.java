package server.poketowns.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.listeners.PlayerDeath;
import server.poketowns.supersmash.Inventories;

public class Leave implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(!Inventories.getInstance().hasInventory(p)){
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Are Not In-Game!"));
				return CommandResult.successCount(0);
			}
			p.getInventory().clear();
			for(ItemStack i :Inventories.getInstance().getInventory(p)){
				if(i.getItem().equals(ItemTypes.CHAINMAIL_HELMET)||i.getItem().equals(ItemTypes.LEATHER_HELMET)||i.getItem().equals(ItemTypes.DIAMOND_HELMET)||i.getItem().equals(ItemTypes.GOLDEN_HELMET)||i.getItem().equals(ItemTypes.IRON_HELMET)){
					p.setHelmet(i);
				}else
					if(i.getItem().equals(ItemTypes.CHAINMAIL_CHESTPLATE)||i.getItem().equals(ItemTypes.LEATHER_CHESTPLATE)||i.getItem().equals(ItemTypes.DIAMOND_CHESTPLATE)||i.getItem().equals(ItemTypes.GOLDEN_CHESTPLATE)||i.getItem().equals(ItemTypes.IRON_CHESTPLATE)||i.getItem().equals(ItemTypes.ELYTRA)){
						p.setChestplate(i);
					}else
						if(i.getItem().equals(ItemTypes.CHAINMAIL_LEGGINGS)||i.getItem().equals(ItemTypes.LEATHER_LEGGINGS)||i.getItem().equals(ItemTypes.DIAMOND_LEGGINGS)||i.getItem().equals(ItemTypes.GOLDEN_LEGGINGS)||i.getItem().equals(ItemTypes.IRON_LEGGINGS)){
							p.setLeggings(i);
						}else
							if(i.getItem().equals(ItemTypes.CHAINMAIL_BOOTS)||i.getItem().equals(ItemTypes.LEATHER_BOOTS)||i.getItem().equals(ItemTypes.DIAMOND_BOOTS)||i.getItem().equals(ItemTypes.GOLDEN_BOOTS)||i.getItem().equals(ItemTypes.IRON_BOOTS)){
								p.setBoots(i);
							}else
								p.getInventory().offer(i);
			}
			Inventories.getInstance().removeInventory(p);
			if(PlayerDeath.getInstance().hasLives(p)){
				PlayerDeath.getInstance().removeLives(p);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Have Left The Game!"));
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "If You Are Missing Items, Relog!"));
		}
		return CommandResult.success();
	}
}
