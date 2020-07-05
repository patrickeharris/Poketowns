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

public class IslandInvite implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny(Text.of("invite"))){
				String invite = (String) context.getOne(Text.of("invite")).get();
				for(Player player : Sponge.getServer().getOnlinePlayers()){
					if(player.getName().equalsIgnoreCase(invite)){
						IslandManager.getInstance().invite(p,player);
						return CommandResult.successCount(1);
					}
				}
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"That Player Is Not Online Or Does Not Exist!"));
				return CommandResult.successCount(2);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Must Specify A Player To Invite!"));
		}
		return CommandResult.success();
	}
}
