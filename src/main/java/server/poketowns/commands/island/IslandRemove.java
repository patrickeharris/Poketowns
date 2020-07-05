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

public class IslandRemove implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny(Text.of("confirm"))){
				IslandManager.getInstance().removeIsland(p);
				return CommandResult.successCount(1);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"Make Sure You Have Taken All Items Off The Island And Moved Your Home Elsewhere! If You Want To Remove Type /island remove confirm!"));
		}
		return CommandResult.success();
	}
}
