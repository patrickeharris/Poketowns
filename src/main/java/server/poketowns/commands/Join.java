package server.poketowns.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.supersmash.Inventories;
import server.poketowns.supersmash.SelectInventory;

public class Join implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(Inventories.getInstance().hasInventory(p)){
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Are Already In-Game!"));
				return CommandResult.successCount(0);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "This Game Is In Beta!"));
			SelectInventory inv = new SelectInventory();
			inv.addPlayer(p);
		}
		return CommandResult.success();
	}
}
