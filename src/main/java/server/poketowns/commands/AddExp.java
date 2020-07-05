package server.poketowns.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

import server.poketowns.experience.ExperienceManager;

public class AddExp implements CommandExecutor {
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(context.hasAny(Text.of("player"))){
			if(context.hasAny(Text.of("amount"))){
				ExperienceManager.getInstance().addXpS((String)context.getOne("player").get(), (Integer)context.getOne("amount").get());
			}
		}
		return CommandResult.success();
	}
}
