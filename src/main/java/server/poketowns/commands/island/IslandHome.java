package server.poketowns.commands.island;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.islands.IslandManager;
import server.poketowns.supersmash.Inventories;

public class IslandHome implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny(Text.of("name"))){
				String name = (String) context.getOne(Text.of("name")).get();
				if(IslandManager.getInstance().hasIsland(name)){
					if(IslandManager.getInstance().invited(name, p)){
						p.setLocation(IslandManager.getInstance().getIsland(name).getHome());
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"Welcome To ",name,"'s Home!"));
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"Island Is Currently In Beta So Please Don't Store Valuables Here Yet!"));
						return CommandResult.successCount(3);
					}
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Are Not Invited To ",name,"'s Island!"));
					return CommandResult.successCount(4);
				}
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,name, " Does Not Have An Island!"));
				return CommandResult.successCount(5);
			}
			if(IslandManager.getInstance().hasIsland(p.getName())){
				if(!Inventories.getInstance().hasInventory(p)){
					p.setLocation(IslandManager.getInstance().getIsland(p.getName()).getHome());
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"Welcome Home!"));
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"Island Is Currently In Beta So Please Don't Store Valuables Here Yet!"));
					return CommandResult.successCount(1);
				}
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Leave While In A Game! Type /game leave To Leave!"));
				return CommandResult.successCount(2);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Not Created An Island! Make One Now With /island create!"));
		}
		return CommandResult.success();
	}
}
