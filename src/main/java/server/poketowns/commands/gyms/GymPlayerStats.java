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

public class GymPlayerStats implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(context.hasAny("player")){
				String gym = (String) context.getOne("player").get();
				if(GymManager.getInstance().getPlayers()==null){
					p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Players!"));
					return CommandResult.successCount(9);
				}
				for(String g : GymManager.getInstance().getPlayers()){
					if(g.equalsIgnoreCase(gym)){
						if(GymManager.getInstance().getLosses(g)==null||GymManager.getInstance().getLosses(g)==0){
							p.sendMessage(Text.of(TextColors.GOLD,g, TextColors.RED," Wins: ",GymManager.getInstance().getWins(g)," Losses: ",GymManager.getInstance().getLosses(g),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(g)));
						}else{
							p.sendMessage(Text.of(TextColors.GOLD,g, TextColors.RED," Wins: ",GymManager.getInstance().getWins(g)," Losses: ",GymManager.getInstance().getLosses(g),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(g)/GymManager.getInstance().getLosses(g)));
						}
						if(GymManager.getInstance().getWinsP(g)!=null){
							p.sendMessage(Text.of(TextColors.RED,"Beat Gyms: "));
							for(Gym won: GymManager.getInstance().getWinsP(g)){
								p.sendMessage(Text.of(TextColors.GREEN,won.getOwner()," ",TextColors.GOLD,won.getType()));
							}
						}
						if(GymManager.getInstance().getLossesP(g)!=null){
							p.sendMessage(Text.of(TextColors.RED,"Lost Gyms: "));
							for(Gym won: GymManager.getInstance().getLossesP(g)){
								p.sendMessage(Text.of(TextColors.GREEN,won.getOwner()," ",TextColors.GOLD,won.getType()));
							}
						}
						return CommandResult.successCount(0);
					}
				}
				p.sendMessage(Text.of(TextColors.GOLD,gym, TextColors.RED," Wins: 0"," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: 0"));
				return CommandResult.successCount(2);
			}
			if(GymManager.getInstance().getPlayers()==null){
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Players!"));
				return CommandResult.successCount(9);
			}
			for(String g : GymManager.getInstance().getPlayers()){
				if(g.equalsIgnoreCase(p.getName())){
					if(GymManager.getInstance().getLosses(g)==null||GymManager.getInstance().getLosses(g)==0){
						p.sendMessage(Text.of(TextColors.GOLD,g, TextColors.RED," Wins: ",GymManager.getInstance().getWins(g)," Losses: ",GymManager.getInstance().getLosses(g),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(g)));
					}else{
						p.sendMessage(Text.of(TextColors.GOLD,g, TextColors.RED," Wins: ",GymManager.getInstance().getWins(g)," Losses: ",GymManager.getInstance().getLosses(g),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(g)/GymManager.getInstance().getLosses(g)));
					}
					if(GymManager.getInstance().getWinsP(g)!=null){
						p.sendMessage(Text.of(TextColors.RED,"Beat Gyms: "));
						for(Gym won: GymManager.getInstance().getWinsP(g)){
							p.sendMessage(Text.of(TextColors.GREEN,won.getOwner()," ",TextColors.GOLD,won.getType()));
						}
					}
					if(GymManager.getInstance().getLossesP(g)!=null){
						p.sendMessage(Text.of(TextColors.RED,"Lost Gyms: "));
						for(Gym won: GymManager.getInstance().getLossesP(g)){
							p.sendMessage(Text.of(TextColors.GREEN,won.getOwner()," ",TextColors.GOLD,won.getType()));
						}
					}
				}
			}
			p.sendMessage(Text.of(TextColors.GOLD,p.getName(), TextColors.RED," Wins: 0"," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: 0"));
			return CommandResult.successCount(5);
			
		}
		return CommandResult.success();
	}
}
