package server.poketowns.commands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.config.ConfigurationManager;

public class Edit implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny(Text.of("change"))){
				Object change = context.getOne(Text.of("change")).get();
				if(context.hasAny(Text.of("slot"))){
					Object slot = context.getOne(Text.of("slot")).get();
					if(context.hasAny(Text.of("detail"))){
						Object detail = context.getOne(Text.of("detail")).get();
						ConfigurationManager.getInstance().loadConfig();
						if(ConfigurationManager.getInstance().getConfig().getNode(change, p.getName()).getString()==null){
							p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Haven't Bought That Change!"));
							return CommandResult.successCount(52);
						}
						String amount = ConfigurationManager.getInstance().getConfig().getNode(change, p.getName()).getString();
						if(amount!=null&&amount!="0"){
							int left = ConfigurationManager.getInstance().getConfig().getNode(change, p.getName()).getInt();
							ConfigurationManager.getInstance().getConfig().getNode(change, p.getName()).setValue(left-1);
							ConfigurationManager.getInstance().saveConfig();
							String st = "pokeedit "+ p.getName()+ " "+ slot+ " change:"+detail;
							Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
						}else
							p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "You Haven't Bought That Change!"));
					}else
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "Please Specify The New Selection!"));
				}else
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "Please Specify A Poke's Slot Number to Change!"));
			}else
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD, "Please Specify What You Would Like to Change!"));
		}
		return CommandResult.success();
	}
}
