package server.poketowns.commands.gyms;

import java.util.ArrayList;

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

import server.poketowns.gyms.Gym;
import server.poketowns.gyms.GymManager;

public class GymCancelChallenge implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			//1 min cooldown
					for(ArrayList<Player>ps:GymChallenge.getInstance().getChallengeValues()){
						for(Player p2:ps){
							if(p2.getName().equals(p.getName())){
								for(Player ea : GymChallenge.getInstance().getChallengeKeyset()){
									if(GymChallenge.getInstance().getPlayer(ea).equals(ps)){
										ps.remove(p);
										GymChallenge.getInstance().replace(ea, ps);
									}
								}
							}
						}
					}
				}
		return CommandResult.success();
	}
}
