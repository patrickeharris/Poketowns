package server.poketowns.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

import server.poketowns.config.ConfigurationManager;

public class Console implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(context.hasAny(Text.of("player"))){
			Object player = context.getOne(Text.of("player")).get();
			if(context.hasAny(Text.of("change"))){
				Object change = context.getOne(Text.of("change")).get();
				ConfigurationManager.getInstance().loadConfig();
				if(ConfigurationManager.getInstance().getConfig().getNode(change, player).getString()==null){
					ConfigurationManager.getInstance().getConfig().getNode(change, player).setValue("1");
					ConfigurationManager.getInstance().saveConfig();
					return CommandResult.successCount(1);
				}
				String amount = ConfigurationManager.getInstance().getConfig().getNode(change, player).getString();
				if(amount!=null){
					int left = ConfigurationManager.getInstance().getConfig().getNode(change, player).getInt();
					ConfigurationManager.getInstance().getConfig().getNode(change, player).setValue(left+1);
					ConfigurationManager.getInstance().saveConfig();
				}		
			}
		}
		return CommandResult.success();
	}
}
