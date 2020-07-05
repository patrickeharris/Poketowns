package server.poketowns.commands.gyms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

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

public class GymChallenge implements CommandExecutor{
	HashMap<Player, ArrayList<Player>> challenges = new HashMap<Player, ArrayList<Player>>();
	HashMap<Player, Long> cooldown = new HashMap<Player, Long>();
	static GymChallenge instance = new GymChallenge();
	public static GymChallenge getInstance(){
		return instance;
	}
	public Set<Player> getChallengeKeyset(){
		return challenges.keySet();
	}
	public Collection<ArrayList<Player>> getChallengeValues(){
		return challenges.values();
	}
	public ArrayList<Player> getPlayer(Player p){
		return challenges.get(p);
	}
	public void replace(Player p, ArrayList<Player> p2){
		challenges.replace(p, p2);
	}
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			//1 min cooldown
			if(context.hasAny("gym_leader")){
				String leader = (String)context.getOne("gym_leader").get();
				if(!cooldown.containsKey(p)){
					if(GymManager.getInstance().getGyms()==null){
						p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Gyms!"));
						return CommandResult.successCount(9);
					}
					for(Gym gym:GymManager.getInstance().getGyms()){
						if(gym.getOwner().equalsIgnoreCase(leader)){
							if(Sponge.getServer().getPlayer(gym.getOwner()).isPresent()){
								if(Sponge.getServer().getPlayer(gym.getOwner()).get().isOnline()){
									if(challenges.containsKey(Sponge.getServer().getPlayer(gym.getOwner()).get())){
										if(challenges.get(Sponge.getServer().getPlayer(gym.getOwner()).get()).contains(p)){
										
										}else{
											challenges.get(Sponge.getServer().getPlayer(gym.getOwner()).get()).add(p);
										}
									}
									if(!challenges.containsKey(Sponge.getServer().getPlayer(gym.getOwner()).get())){
										ArrayList<Player>ps= new ArrayList<Player>();
										ps.add(p);
										challenges.put(Sponge.getServer().getPlayer(gym.getOwner()).get(), ps);
									}
									p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Challenged ",gym.getOwner()," To A Battle! If They Accept You Will Be Teleported To Them! If You Wish To Cancel Type /gym challenge cancel!"));
									Sponge.getServer().getPlayer(gym.getOwner()).get().sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,p.getName()," Would Like To Challenge You! Type /gym challenge accept ",p.getName()," To Accept This Player's Offer And Teleport Them To You!"));
									cooldown.put(p, System.currentTimeMillis()+60000);
									return CommandResult.successCount(0);
								}
							}
						}
					}
					p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,leader," Is Not A Valid Gym Leader!"));
					return CommandResult.successCount(1);
				}
				if(cooldown.get(p)<System.currentTimeMillis()){
					if(GymManager.getInstance().getGyms()==null){
						p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Gyms!"));
						return CommandResult.successCount(9);
					}
					for(Gym gym:GymManager.getInstance().getGyms()){
						if(gym.getOwner().equalsIgnoreCase(leader)){
						if(Sponge.getServer().getPlayer(gym.getOwner()).isPresent()){
							if(Sponge.getServer().getPlayer(gym.getOwner()).get().isOnline()){
								if(challenges.containsKey(Sponge.getServer().getPlayer(gym.getOwner()).get())){
									if(challenges.get(Sponge.getServer().getPlayer(gym.getOwner()).get()).contains(p)){
										
									}else{
										challenges.get(Sponge.getServer().getPlayer(gym.getOwner()).get()).add(p);
									}
								}
								if(!challenges.containsKey(Sponge.getServer().getPlayer(gym.getOwner()).get())){
									ArrayList<Player>ps= new ArrayList<Player>();
									ps.add(p);
									challenges.put(Sponge.getServer().getPlayer(gym.getOwner()).get(), ps);
								}
								p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Challenged ",gym.getOwner()," To A Battle! If They Accept You Will Be Teleported To Them! If You Wish To Cancel Type /gym challenge cancel!"));
								Sponge.getServer().getPlayer(gym.getOwner()).get().sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,p.getName()," Would Like To Challenge You! Type /gym challenge accept ",p.getName()," To Accept This Player's Offer And Teleport Them To You!"));
								cooldown.put(p, System.currentTimeMillis()+60000);
								return CommandResult.successCount(0);
							}
						}
						}
					}
					p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,leader," Is Not A Valid Gym Leader!"));
					return CommandResult.successCount(1);
				}else{
					p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Cannot Challenge a Leader Again For ",(cooldown.get(p)-System.currentTimeMillis())/1000," Seconds!"));
				}
			}
		}
		return CommandResult.success();
	}
}
