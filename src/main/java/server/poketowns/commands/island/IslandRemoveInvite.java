package server.poketowns.commands.island;

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

import server.poketowns.islands.IslandManager;

public class IslandRemoveInvite implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny(Text.of("invite"))){
				String invite = (String) context.getOne(Text.of("invite")).get();
				IslandManager.getInstance().removeInvite(p, invite);
				return CommandResult.successCount(1);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Must Specify A Player To Invite!"));
		}
		return CommandResult.success();
	}
}
