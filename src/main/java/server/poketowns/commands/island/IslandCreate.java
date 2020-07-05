package server.poketowns.commands.island;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

import server.poketowns.islands.IslandManager;

public class IslandCreate implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			IslandManager.getInstance().createIsland(p);
		}
		return CommandResult.success();
	}
}
