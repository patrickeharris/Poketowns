package server.poketowns.commands.gyms;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.gyms.Gym;
import server.poketowns.gyms.GymManager;

public class GymWin implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			Gym gym = null;
			if(context.hasAny("player")){
				String name = (String)context.getOne("player").get();
				if(GymManager.getInstance().getGyms()==null){
					p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Gyms!"));
					return CommandResult.successCount(9);
				}
				for(Gym g: GymManager.getInstance().getGyms()){
					if(g.getOwner().equalsIgnoreCase(p.getName())){
						gym=g;
						break;
					}
				}
				for(Player pl:Sponge.getServer().getOnlinePlayers()){
					if(pl.getName().equalsIgnoreCase(name)){
						GymManager.getInstance().addWin(pl,gym);
						pl.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Beat ",p.getName(),"'s Gym! Here's A Prize!"));
						ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, gym.getBadgeId()).get()).quantity(1).build();
						pl.getInventory().offer(i);
						p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"Added A Win For ",pl.getName()));
						return CommandResult.successCount(0);
					}
				}
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"That Player Doesn't Exist Or Isn't Online!"));
				return CommandResult.successCount(1);
			}
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"Please Specify A Player!"));
			return CommandResult.successCount(2);
		}
		return CommandResult.success();
	}
}
