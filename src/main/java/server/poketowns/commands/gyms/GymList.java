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

import server.poketowns.gyms.Gym;
import server.poketowns.gyms.GymManager;

public class GymList implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			p.sendMessage(Text.of(TextStyles.BOLD,TextColors.BLUE,"All Gyms:"));
			if(GymManager.getInstance().getGyms()==null){
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Gyms!"));
				return CommandResult.successCount(9);
			}
			for(Gym gym:GymManager.getInstance().getGyms()){
				p.sendMessage(Text.of(TextColors.LIGHT_PURPLE,"Type: ",gym.getType()," ",TextColors.GREEN,"Leader: ",gym.getOwner()," ",TextColors.GOLD,"Min Level: ",gym.getMinLevel()," Max Level: ", gym.getMaxLevel()));
			}
		}
		return CommandResult.success();
	}
}
