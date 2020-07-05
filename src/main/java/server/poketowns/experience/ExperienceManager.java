package server.poketowns.experience;

import java.util.HashMap;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import server.poketowns.config.ConfigurationManager;
import server.poketowns.islands.Island;

public class ExperienceManager {
	static ExperienceManager instance = new ExperienceManager();
	HashMap<String, Integer>xp = new HashMap<String, Integer>();
	public static ExperienceManager getInstance(){
		return instance;
	}
	public void onStart(){
		ConfigurationManager.getInstance().loadConfig();
		for(Object s: ConfigurationManager.getInstance().getConfig().getNode("xp").getChildrenMap().keySet()){
			String name = s.toString();
			for(Object s2: ConfigurationManager.getInstance().getConfig().getNode("xp",name).getChildrenMap().keySet()){
				String exp = s2.toString();
				xp.put(name, Integer.valueOf(exp));
			}
		}
	}
	public void addXp(Player p ,Integer i){
		if(xp.containsKey(p.getName())){
			ConfigurationManager.getInstance().loadConfig();
			for(Object s: ConfigurationManager.getInstance().getConfig().getNode("xp").getChildrenMap().keySet()){
				if(s.equals(p.getName())){
					ConfigurationManager.getInstance().getConfig().getNode("xp").removeChild(s);
				}
			}
			ConfigurationManager.getInstance().saveConfig();
			xp.replace(p.getName(), xp.get(p.getName())+i);
			if(getLevel(p)>getXpLevel(xp.get(p.getName())-i)){
				levelUp(p);
			}
			ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("xp", p.getName(), String.valueOf(xp.get(p.getName()))).setValue(String.valueOf(xp.get(p.getName())));
			ConfigurationManager.getInstance().saveConfig();
			return;
		}
		xp.put(p.getName(), i);
		ConfigurationManager.getInstance().loadConfig();
        ConfigurationManager.getInstance().getConfig().getNode("xp", p.getName(), String.valueOf(i)).setValue(String.valueOf(i));
		ConfigurationManager.getInstance().saveConfig();
		if(getLevel(p)>0){
			levelUp(p);
		}
	}
	public void addXpS(String p ,Integer i){
		if(xp.containsKey(p)){
			ConfigurationManager.getInstance().loadConfig();
			for(Object s: ConfigurationManager.getInstance().getConfig().getNode("xp").getChildrenMap().keySet()){
				if(s.equals(p)){
					ConfigurationManager.getInstance().getConfig().getNode("xp").removeChild(s);
				}
			}
			ConfigurationManager.getInstance().saveConfig();
			xp.replace(p, xp.get(p)+i);
			ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("xp", p, String.valueOf(xp.get(p))).setValue(String.valueOf(xp.get(p)));
			ConfigurationManager.getInstance().saveConfig();
			return;
		}
		xp.put(p, i);
		ConfigurationManager.getInstance().loadConfig();
        ConfigurationManager.getInstance().getConfig().getNode("xp", p, String.valueOf(i)).setValue(String.valueOf(i));
		ConfigurationManager.getInstance().saveConfig();
	}
	public void removeXp(Player p ,Integer i){
		if(xp.containsKey(p.getName())){
			for(Object s: ConfigurationManager.getInstance().getConfig().getNode("xp").getChildrenMap().keySet()){
				if(s.equals(p.getName())){
					ConfigurationManager.getInstance().getConfig().getNode("xp").removeChild(s);
				}
			}
			xp.replace(p.getName(), xp.get(p.getName())-i);
			ConfigurationManager.getInstance().loadConfig();
	        ConfigurationManager.getInstance().getConfig().getNode("xp", p.getName(), xp.get(p.getName())).setValue(xp.get(p.getName()));
			ConfigurationManager.getInstance().saveConfig();
			return;
		}
	}
	public Integer getXp(Player p){
		if(xp.containsKey(p.getName())){
			return xp.get(p.getName());
		}
		return 0;
	}
	public void levelUp(Player p){
		p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Leveled Up To Level ",getLevel(p),"!"));
		p.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, p.getLocation().getPosition(), 10);
		if(getXp(p)>12000){
			String st = "pokegive "+ p.getName()+ " random s";
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given A Random Shiny Pixelmon To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>10500){
			String st = "pokegive "+ p.getName()+ " random";
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 5 Random Pixelmon To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>9100){
			String st = "pokegive "+ p.getName()+ " random";
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 4 Random Pixelmon To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>7800){
			String st = "pokegive "+ p.getName()+ " random";
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 3 Random Pixelmon To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>6600){
			String st = "pokegive "+ p.getName()+ " random";
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 2 Random Pixelmon To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>5500){
			String st = "pokegive "+ p.getName()+ " random";
			Sponge.getCommandManager().process(Sponge.getServer().getConsole(), st);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given A Random Pixelmon To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>4500){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:master_ball").get()).quantity(5).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 5 MasterBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>3600){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:master_ball").get()).quantity(4).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 4 MasterBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>2800){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:master_ball").get()).quantity(3).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 3 MasterBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>2100){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:master_ball").get()).quantity(2).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 2 MasterBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>1500){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:master_ball").get()).quantity(1).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 1 MasterBall To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>1000){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:safari_ball").get()).quantity(64).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 64 SafariBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>600){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:ultra_ball").get()).quantity(64).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 64 UltraBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>300){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:great_ball").get()).quantity(64).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 64 GreatBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
		if(getXp(p)>100){
			ItemStack i = ItemStack.builder().itemType(Sponge.getRegistry().getType(ItemType.class, "pixelmon:poke_ball").get()).quantity(64).build();
			p.getInventory().offer(i);
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Have Been Given 64 PokeBalls To Celebrate!"));
			addXp(p, 0);
			return;
		}
	}
	public Integer getLevel(Player p){
		if(xp.containsKey(p.getName())){
			int exp = xp.get(p.getName());
			if(exp>12000){
				return 15;
			}
			if(exp>10500){
				return 14;
			}
			if(exp>9100){
				return 13;
			}
			if(exp>7800){
				return 12;
			}
			if(exp>6600){
				return 11;
			}
			if(exp>5500){
				return 10;
			}
			if(exp>4500){
				return 9;
			}
			if(exp>3600){
				return 8;
			}
			if(exp>2800){
				return 7;
			}
			if(exp>2100){
				return 6;
			}
			if(exp>1500){
				return 5;
			}
			if(exp>1000){
				return 4;
			}
			if(exp>600){
				return 3;
			}
			if(exp>300){
				return 2;
			}
			if(exp>100){
				return 1;
			}
			return 0;
		}
		return 0;
	}
	public Integer getXpLevel(int exp){
		if(exp>12000){
			return 15;
		}
		if(exp>10500){
			return 14;
		}
		if(exp>9100){
			return 13;
		}
		if(exp>7800){
			return 12;
		}
		if(exp>6600){
			return 11;
		}
		if(exp>5500){
			return 10;
		}
		if(exp>4500){
			return 9;
		}
		if(exp>3600){
			return 8;
		}
		if(exp>2800){
			return 7;
		}
		if(exp>2100){
			return 6;
		}
		if(exp>1500){
			return 5;
		}
		if(exp>1000){
			return 4;
		}
		if(exp>600){
			return 3;
		}
		if(exp>300){
			return 2;
		}
		if(exp>100){
			return 1;
		}
			return 0;
	}
}
