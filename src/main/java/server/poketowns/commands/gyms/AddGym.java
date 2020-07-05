package server.poketowns.commands.gyms;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.gyms.GymManager;

public class AddGym implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny("owner")){
				String owner = (String) context.getOne("owner").get();
				if(context.hasAny("type")){
					String type = (String) context.getOne("type").get();
					if(context.hasAny("min")){
						String min = (String) context.getOne("min").get();
						if(context.hasAny("max")){
							String max = (String) context.getOne("max").get();
							if(context.hasAny("badgeId")){
								String badgeId = (String) context.getOne("badgeId").get();
								GymManager.getInstance().createGym(owner, type,badgeId, Integer.valueOf(min),  Integer.valueOf(max));
								p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"Successfully Added Gym!"));
							}
						}
					}
				}
			}
		}
		return CommandResult.success();
	}
}
