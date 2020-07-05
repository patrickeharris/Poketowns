package server.poketowns.gyms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import server.poketowns.config.ConfigurationManager;
import server.poketowns.experience.ExperienceManager;
import server.poketowns.islands.Island;

public class GymManager {
	private static GymManager instance = new GymManager();
	private ArrayList<Gym>gyms = new ArrayList<Gym>();
	private HashMap<String,Integer>wins = new HashMap<String,Integer>();
	private HashMap<String,Integer>losses = new HashMap<String,Integer>();
	private HashMap<String,Integer>fakeLosses = new HashMap<String,Integer>();
	private HashMap<String,ArrayList<Gym>>winGyms = new HashMap<String,ArrayList<Gym>>();
	private HashMap<String,ArrayList<Gym>>lossGyms = new HashMap<String,ArrayList<Gym>>();
	public static GymManager getInstance(){
		return instance;
	}
	//config load on start
	//exp system accepted to rank
	//pokestops
	public void onStart(){
		ConfigurationManager.getInstance().loadConfig();
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("gym").getChildrenMap().keySet()){
			String owner = s.toString();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("gym",owner).getChildrenMap().keySet()){
				String type = s2.toString();
				for(Object s3: ConfigurationManager.getInstance().getConfig().getNode("gym",owner,type).getChildrenMap().keySet()){
					String badgeId = s3.toString();
					for(Object s4: ConfigurationManager.getInstance().getConfig().getNode("gym",owner,type,badgeId).getChildrenMap().keySet()){
						String minLevel = s4.toString();
						for(Object s5: ConfigurationManager.getInstance().getConfig().getNode("gym",owner,type,badgeId,minLevel).getChildrenMap().keySet()){
							String maxLevel = s5.toString();
							for(Object s6: ConfigurationManager.getInstance().getConfig().getNode("gym",owner,type,badgeId,minLevel,maxLevel).getChildrenMap().keySet()){
								String wins = s6.toString();
								for(Object s7: ConfigurationManager.getInstance().getConfig().getNode("gym",owner,type,badgeId,minLevel,maxLevel,wins).getChildrenMap().keySet()){
									String losses = s7.toString();
									Gym gym = new Gym(owner,type,badgeId,Integer.valueOf(minLevel),Integer.valueOf(maxLevel),Integer.valueOf(wins), Integer.valueOf(losses));
									gyms.add(gym);
								}
							}
						}
					}
				}
			}
		}
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("wingyms").getChildrenMap().keySet()){
			String player = s.toString();
			ArrayList<Gym>gymList = new ArrayList<Gym>();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("wingyms",player).getChildrenMap().keySet()){
				String leader = s2.toString();
				for(Gym g : gyms){
					if(g.getOwner().equals(leader)){
						gymList.add(g);
					}
				}
			}
			winGyms.put(player, gymList);
		}
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("lossgyms").getChildrenMap().keySet()){
			String player = s.toString();
			ArrayList<Gym>gymList = new ArrayList<Gym>();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("lossgyms",player).getChildrenMap().keySet()){
				String leader = s2.toString();
				for(Gym g : gyms){
					if(g.getOwner().equals(leader)){
						gymList.add(g);
					}
				}
			}
			lossGyms.put(player, gymList);
		}
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("wins").getChildrenMap().keySet()){
			String player = s.toString();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("wins",player).getChildrenMap().keySet()){
				String times = s2.toString();
				wins.put(player, Integer.valueOf(times));
				
			}
		}
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("losses").getChildrenMap().keySet()){
			String player = s.toString();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("losses",player).getChildrenMap().keySet()){
				String times = s2.toString();
				losses.put(player, Integer.valueOf(times));
				
			}
		}
	}
	public void createGym(String owner, String type, String badgeId, int minLevel, int maxLevel){
		Gym gym = new Gym(owner,type,badgeId,minLevel,maxLevel,0,0);
		ConfigurationManager.getInstance().loadConfig();
        ConfigurationManager.getInstance().getConfig().getNode("gym", owner, type, badgeId, String.valueOf(minLevel), String.valueOf(maxLevel),String.valueOf(0),String.valueOf(0)).setValue(String.valueOf(0));
		ConfigurationManager.getInstance().saveConfig();
		gyms.add(gym);
	}
	public void removeGym(String owner,Player p){
		for(Gym gym:gyms){
			if(gym.getOwner().equals(owner)){
				ConfigurationManager.getInstance().loadConfig();
				for(Object s: ConfigurationManager.getInstance().getConfig().getNode("gym").getChildrenMap().keySet()){
					if((String) s==gym.getOwner()){
						ConfigurationManager.getInstance().getConfig().getNode("gym").removeChild(s);
					}
				}
				ConfigurationManager.getInstance().saveConfig();
				gyms.remove(gym);
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"Gym Successfully Removed!"));
				return;
			}
		}
		p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"That Is Not A Valid Gym Leader!"));
	}
	public ArrayList<Gym>getGyms(){
		if(gyms.isEmpty()){
			return null;
		}
		return gyms;
	}
	public Integer getWins(String p){
		if(wins.isEmpty()||!wins.containsKey(p)){
			return null;
		}
		return wins.get(p);
	}
	public Integer getLosses(String p){
		if(losses.isEmpty()||!losses.containsKey(p)){
			return null;
		}
		return losses.get(p);
	}
	public ArrayList<Gym> getWinsP(String p){
		if(winGyms.isEmpty()||!winGyms.containsKey(p)){
			return null;
		}
		return winGyms.get(p);
	}
	public ArrayList<Gym> getLossesP(String p){
		if(lossGyms.isEmpty()||!lossGyms.containsKey(p)){
			return null;
		}
		return lossGyms.get(p);
	}
	public Set<String> getPlayers(){
		if(wins.isEmpty()){
			return null;
		}
		return wins.keySet();
	}
	public void addWin(Player p, Gym g){
		g.addLoss();
		ExperienceManager.getInstance().addXp(p, 500);
		p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Been Given 500 Experience For Winning!"));
		if(wins.containsKey(p.getName())){
			ConfigurationManager.getInstance().loadConfig();
			for(Object s: ConfigurationManager.getInstance().getConfig().getNode("wins").getChildrenMap().keySet()){
				if(s.equals(p.getName())){
					ConfigurationManager.getInstance().getConfig().getNode("wins").removeChild(s);
				}
			}
			ConfigurationManager.getInstance().saveConfig();
			wins.replace(p.getName(), wins.get(p.getName())+1);
			if(winGyms.get(p.getName()).contains(g)){
				ConfigurationManager.getInstance().loadConfig();
		        ConfigurationManager.getInstance().getConfig().getNode("wins", p.getName(), String.valueOf(wins.get(p.getName()))).setValue(String.valueOf(wins.get(p.getName())));
				ConfigurationManager.getInstance().saveConfig();
				return;
			}
			if(lossGyms.get(p.getName()).contains(g)){
				lossGyms.get(p.getName()).remove(g);
				ConfigurationManager.getInstance().loadConfig();
				for(Object s: ConfigurationManager.getInstance().getConfig().getNode("lossgyms").getChildrenMap().keySet()){
					if(s.equals(p.getName())){
						ConfigurationManager.getInstance().getConfig().getNode("lossgyms").removeChild(s);
					}
				}
				ConfigurationManager.getInstance().saveConfig();
			}
			winGyms.get(p.getName()).add(g);
			ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("wingyms", p.getName(), g.getOwner()).setValue(g.getOwner());
			ConfigurationManager.getInstance().saveConfig();
			ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("wins", p.getName(), String.valueOf(wins.get(p.getName()))).setValue(String.valueOf(wins.get(p.getName())));
			ConfigurationManager.getInstance().saveConfig();
			return;
		}
		wins.put(p.getName(), 1);
		ArrayList<Gym>gs = new ArrayList<Gym>();
		gs.add(g);
		winGyms.put(p.getName(), gs);
		ConfigurationManager.getInstance().loadConfig();
        ConfigurationManager.getInstance().getConfig().getNode("wingyms", p.getName(), g.getOwner()).setValue(g.getOwner());
		ConfigurationManager.getInstance().saveConfig();
		ConfigurationManager.getInstance().loadConfig();
        ConfigurationManager.getInstance().getConfig().getNode("wins", p.getName(), String.valueOf(wins.get(p.getName()))).setValue(String.valueOf(wins.get(p.getName())));
		ConfigurationManager.getInstance().saveConfig();
	}
	public void addLoss(Player p, Gym g){
		g.addWin();
		ExperienceManager.getInstance().addXp(p, 100);
		p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Been Given 100 Experience For Losing!"));
		if(losses.containsKey(p.getName())){
			ConfigurationManager.getInstance().loadConfig();
			for(Object s: ConfigurationManager.getInstance().getConfig().getNode("losses").getChildrenMap().keySet()){
				if(s.equals(p.getName())){
					ConfigurationManager.getInstance().getConfig().getNode("losses").removeChild(s);
				}
			}
			ConfigurationManager.getInstance().saveConfig();
			losses.replace(p.getName(), losses.get(p.getName())+1);
			if(lossGyms.get(p.getName()).contains(g)){
				ConfigurationManager.getInstance().loadConfig();
		        ConfigurationManager.getInstance().getConfig().getNode("losses", p.getName(), String.valueOf(losses.get(p.getName()))).setValue(String.valueOf(losses.get(p.getName())));
				ConfigurationManager.getInstance().saveConfig();
				return;
			}
			if(winGyms.get(p.getName()).contains(g)){
				ConfigurationManager.getInstance().loadConfig();
		        ConfigurationManager.getInstance().getConfig().getNode("losses", p.getName(), String.valueOf(losses.get(p.getName()))).setValue(String.valueOf(losses.get(p.getName())));
				ConfigurationManager.getInstance().saveConfig();
				return;
			}
			ArrayList<Gym>ls = new ArrayList<Gym>();
			ls.add(g);
			lossGyms.replace(p.getName(), ls);
			ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("lossgyms", p.getName(), g.getOwner()).setValue(g.getOwner());
			ConfigurationManager.getInstance().saveConfig();
			ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("losses", p.getName(), String.valueOf(losses.get(p.getName()))).setValue(String.valueOf(losses.get(p.getName())));
			ConfigurationManager.getInstance().saveConfig();
			return;
		}
		losses.put(p.getName(), 1);
		ArrayList<Gym>ls = new ArrayList<Gym>();
		ls.add(g);
		lossGyms.put(p.getName(), ls);
		ConfigurationManager.getInstance().loadConfig();
        ConfigurationManager.getInstance().getConfig().getNode("lossgyms", p.getName(), g.getOwner()).setValue(g.getOwner());
		ConfigurationManager.getInstance().saveConfig();
		ConfigurationManager.getInstance().loadConfig();
        ConfigurationManager.getInstance().getConfig().getNode("losses", p.getName(), String.valueOf(losses.get(p.getName()))).setValue(String.valueOf(losses.get(p.getName())));
		ConfigurationManager.getInstance().saveConfig();
	}
	public void addFakeLoss(String p){
		if(losses.containsKey(p)){
			losses.replace(p, losses.get(p)+1);
			fakeLosses.put(p, 1);
		}
		losses.put(p, 1);
		fakeLosses.put(p, 1);
	}
	public void removeFakeLoss(String p){
		if(fakeLosses.containsKey(p)){
			losses.replace(p, losses.get(p)-1);
			fakeLosses.remove(p);
		}
	}
}
