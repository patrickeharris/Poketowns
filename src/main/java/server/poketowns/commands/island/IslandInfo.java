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

public class IslandInfo implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny(Text.of("name"))){
				String name = (String) context.getOne(Text.of("name")).get();
				if(IslandManager.getInstance().hasIsland(name)){
					Island i = IslandManager.getInstance().getIsland(name);
					p.sendMessage(Text.of(TextColors.GOLD, name,"'s Island"));
					p.sendMessage(Text.of(TextColors.GREEN, "   Biome: ",i.getBiome().getName()));
					p.sendMessage(Text.of(TextColors.GREEN, "   Home: (",i.getHome().getBlockX()," ,",i.getHome().getBlockY()," ,",i.getHome().getBlockZ(),")"));
					p.sendMessage(Text.of(TextColors.GREEN, "   Middle: (",i.getMiddle().getBlockX()," ,",i.getMiddle().getBlockY()," ,",i.getMiddle().getBlockZ(),")"));
					return CommandResult.successCount(1);
				}
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,name," Does Not Have An Island!"));
				return CommandResult.successCount(2);
			}else{
				if(IslandManager.getInstance().hasIsland(p.getName())){
					Island i = IslandManager.getInstance().getIsland(p.getName());
					p.sendMessage(Text.of(TextColors.GOLD, p.getName(),"'s Island"));
					p.sendMessage(Text.of(TextColors.GREEN, "   Biome: ",i.getBiome().getName()));
					p.sendMessage(Text.of(TextColors.GREEN, "   Home: (",i.getHome().getBlockX()," ,",i.getHome().getBlockY()," ,",i.getHome().getBlockZ(),")"));
					p.sendMessage(Text.of(TextColors.GREEN, "   Middle: (",i.getMiddle().getBlockX()," ,",i.getMiddle().getBlockY()," ,",i.getMiddle().getBlockZ(),")"));
				}
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Must Have An Island Or Specify The Name Of Someone Who Does!"));
				return CommandResult.successCount(3);
			}
		}
		return CommandResult.success();
	}
}
