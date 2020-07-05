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

public class GymAcceptChallenge implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			//1 min cooldown
			if(context.hasAny("gym_leader")){
				String name = (String)context.getOne("gym_leader").get();
						for(Player ps : Sponge.getServer().getOnlinePlayers()){
							if(ps.getName().equals(name)){
								for(Player p2 : GymChallenge.getInstance().getChallengeKeyset()){
									if(p2.getName().equals(p.getName())){
										if(GymChallenge.getInstance().getPlayer(p2).contains(ps)){
											ps.setLocation(p2.getLocation());
											ps.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,p2.getName()," Has Accepted Your Challenge Request And You Have Been Teleported To ",p2.getName()," To Fight!"));
											p2.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Accepted ",ps.getName(),"'s Challenge Request And ",ps.getName()," Has Been Teleported To You To Fight!"));
											return CommandResult.successCount(10);
										}
									}
								}
							}
						}
						p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,name," Has Not Challenged You!"));
						return CommandResult.successCount(11);
					}
					p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"No Players To Accept!"));
				}
		return CommandResult.success();
	}
}
