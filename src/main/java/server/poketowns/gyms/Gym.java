package server.poketowns.gyms;

import server.poketowns.config.ConfigurationManager;

public class Gym {
	private String owner;
	private String type;
	private String badgeId;
	private int minLevel;
	private int maxLevel;
	private int wins;
	private int losses;
	private int fakeLoss=0;
	public Gym(String owner, String type, String badgeId, int minLevel, int maxLevel, int wins, int losses){
		this.owner = owner;
		this.type = type;
		this.badgeId=badgeId;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.wins=wins;
		this.losses=losses;
	}
	public String getOwner(){
		return owner;
	}
	public String getType(){
		return type;
	}
	public String getBadgeId(){
		return badgeId;
	}
	public int getMinLevel(){
		return minLevel;
	}
	public int getMaxLevel(){
		return maxLevel;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setBadgeId(String badgeId){
		this.badgeId=badgeId;
	}
	public void setMinLevel(int minLevel){
		this.minLevel = minLevel;
	}
	public void setMaxLevel(int maxLevel){
		this.maxLevel = maxLevel;
	}
	public void addWin(){
		ConfigurationManager.getInstance().loadConfig();
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("gym").getChildrenMap().keySet()){
			if(s.equals(getOwner())){
				ConfigurationManager.getInstance().getConfig().getNode("gym").removeChild(s);
			}
		}
        ConfigurationManager.getInstance().getConfig().getNode("gym", owner, type, badgeId, String.valueOf(minLevel), String.valueOf(maxLevel),String.valueOf(wins+1),String.valueOf(losses)).setValue(String.valueOf(0));
		ConfigurationManager.getInstance().saveConfig();
		this.wins++;
	}
	public void addLoss(){
		ConfigurationManager.getInstance().loadConfig();
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("gym").getChildrenMap().keySet()){
			if(s.equals(getOwner())){
				ConfigurationManager.getInstance().getConfig().getNode("gym").removeChild(s);
			}
		}
        ConfigurationManager.getInstance().getConfig().getNode("gym", owner, type, badgeId, String.valueOf(minLevel), String.valueOf(maxLevel),String.valueOf(wins),String.valueOf(losses+1)).setValue(String.valueOf(0));
		ConfigurationManager.getInstance().saveConfig();
		this.losses++;
	}
	public int getWins(){
		return wins;
	}
	public int getLosses(){
		return losses;
	}
	public void addFakeLoss(){
		this.losses++;
		this.fakeLoss++;
	}
	public void removeFakeLoss(){
		if(fakeLoss>0){
			this.losses--;
			this.fakeLoss--;
		}
	}
	public boolean hasFakeLoss(){
		if(fakeLoss>0)
			return true;
		return false;
	}
}
