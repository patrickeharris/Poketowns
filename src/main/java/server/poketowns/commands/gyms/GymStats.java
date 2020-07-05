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

public class GymStats implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny("gym_leader")){
				String gym = (String) context.getOne("gym_leader").get();
				if(GymManager.getInstance().getGyms()==null){
					p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Gyms!"));
					return CommandResult.successCount(9);
				}
				for(Gym g : GymManager.getInstance().getGyms()){
					if(g.getOwner().equalsIgnoreCase(gym)){
						if(g.getLosses()==0){
							p.sendMessage(Text.of(TextColors.LIGHT_PURPLE,"Type: ",g.getType()," ",TextColors.GREEN,"Leader: ",g.getOwner(), TextColors.RED," Wins: ",g.getWins()," Losses: ",g.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",g.getWins()));
						}else{
							p.sendMessage(Text.of(TextColors.LIGHT_PURPLE,"Type: ",g.getType()," ",TextColors.GREEN,"Leader: ",g.getOwner(), TextColors.RED," Wins: ",g.getWins()," Losses: ",g.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",g.getWins()/g.getLosses()));
						}
						return CommandResult.successCount(0);
					}
				}
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"That Is Not A Valid Gym Leader!"));
				return CommandResult.successCount(1);
			}
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Must Specify A Gym Leader!"));
			return CommandResult.successCount(1);
		}
		return CommandResult.success();
	}
}
