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

import server.poketowns.islands.Island;
import server.poketowns.islands.IslandManager;
import server.poketowns.supersmash.Inventories;

public class IslandSetHome implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(IslandManager.getInstance().hasIsland(p.getName())){
				if(p.getLocation().getExtent().getName().equals("islands")){
					Island i = IslandManager.getInstance().getIsland(p.getName());
					if(p.getLocation().getX()>i.getMiddle().getBlockX()-10&&p.getLocation().getX()<i.getMiddle().getBlockZ()+10&&p.getLocation().getZ()>i.getMiddle().getBlockZ()-10&&p.getLocation().getZ()<i.getMiddle().getBlockZ()+10){
						i.setHome(p.getLocation());
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"Successfully Set Your Island's Home!"));
						return CommandResult.successCount(1);
					}
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Set An Island Home Here!"));
					return CommandResult.successCount(2);
				}
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Set An Island Home Here!"));
				return CommandResult.successCount(3);
			}
			p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Not Created An Island! Make One Now With /island create!"));
		}
		return CommandResult.success();
	}
}
