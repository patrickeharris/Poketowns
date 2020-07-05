package server.poketowns.commands.gyms;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

import server.poketowns.gyms.GymManager;

public class RemoveGym implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny("owner")){
				String owner = (String) context.getOne("owner").get();
				GymManager.getInstance().removeGym(owner,p);
			}
		}
		return CommandResult.success();
	}
}
