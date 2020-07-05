package server.poketowns;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.LocatableBlock;

import com.google.inject.Inject;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import server.poketowns.commands.AddExp;
import server.poketowns.commands.Console;
import server.poketowns.commands.Edit;
import server.poketowns.commands.Join;
import server.poketowns.commands.Leave;
import server.poketowns.commands.gyms.AddGym;
import server.poketowns.commands.gyms.GymAcceptChallenge;
import server.poketowns.commands.gyms.GymCancelChallenge;
import server.poketowns.commands.gyms.GymChallenge;
import server.poketowns.commands.gyms.GymLeaderboard;
import server.poketowns.commands.gyms.GymList;
import server.poketowns.commands.gyms.GymLose;
import server.poketowns.commands.gyms.GymOnline;
import server.poketowns.commands.gyms.GymPlayerLeaderboard;
import server.poketowns.commands.gyms.GymPlayerStats;
import server.poketowns.commands.gyms.GymStats;
import server.poketowns.commands.gyms.GymWin;
import server.poketowns.commands.gyms.RemoveGym;
import server.poketowns.commands.island.IslandCreate;
import server.poketowns.commands.island.IslandHome;
import server.poketowns.commands.island.IslandInfo;
import server.poketowns.commands.island.IslandInvite;
import server.poketowns.commands.island.IslandRemove;
import server.poketowns.commands.island.IslandRemoveInvite;
import server.poketowns.commands.island.IslandSetBiome;
import server.poketowns.commands.island.IslandSetHome;
import server.poketowns.config.ConfigurationManager;
import server.poketowns.experience.ExperienceManager;
import server.poketowns.gyms.GymManager;
import server.poketowns.islands.IslandManager;
import server.poketowns.listeners.AttackEntity;
import server.poketowns.listeners.ClickInventory;
import server.poketowns.listeners.DropItem;
import server.poketowns.listeners.Interact;
import server.poketowns.listeners.LeftClick;
import server.poketowns.listeners.PlayerChat;
import server.poketowns.listeners.PlayerDeath;
import server.poketowns.listeners.PlayerJoin;
import server.poketowns.listeners.PlayerMove;
import server.poketowns.listeners.PlayerQuit;
import server.poketowns.listeners.RightClick;
import server.poketowns.listeners.WaterFlow;
import server.poketowns.supersmash.Inventories;
import server.poketowns.supersmash.Timer;

@Plugin(id = "server", name = "Poketowns", version = "1.0.0")

public class Poketowns {
	@Inject
	public Game game;
	
	@Inject
	@DefaultConfig(sharedRoot = true)
	private Path configFile;
	
	@Inject
	@DefaultConfig(sharedRoot = true)
	ConfigurationLoader<CommentedConfigurationNode> configManager;
	
	@Listener
	public void onServerStart(GameInitializationEvent e){
		ConfigurationManager.getInstance().setup(configFile, configManager);
		game.getEventManager().registerListeners(this, new Interact());
		game.getEventManager().registerListeners(this, new ClickInventory());
		game.getEventManager().registerListeners(this, new LeftClick());
		game.getEventManager().registerListeners(this, new RightClick());
		game.getEventManager().registerListeners(this, new PlayerDeath());
		game.getEventManager().registerListeners(this, new PlayerMove());
		game.getEventManager().registerListeners(this, new WaterFlow());
		game.getEventManager().registerListeners(this, new PlayerQuit());
		game.getEventManager().registerListeners(this, new DropItem());
		game.getEventManager().registerListeners(this, new PlayerChat());
		game.getEventManager().registerListeners(this, new PlayerJoin());
		game.getEventManager().registerListeners(this, new AttackEntity());
		CommandSpec join = CommandSpec.builder()
				.description(Text.of("Join A SuperPixelmonBros Game(In Beta)!"))
				.executor(new Join())
				.build();
		CommandSpec leave = CommandSpec.builder()
				.description(Text.of("Leave A SuperPixelmonBros Game(In Beta)!"))
				.executor(new Leave())
				.build();
		CommandSpec pixelmonGame = CommandSpec.builder()
				.description(Text.of("SuperPixelmonBros Commands(In Beta)!"))
				.child(join, "join","j")
				.child(leave, "leave","l")
				.build();
		CommandSpec console = CommandSpec.builder()
				.description(Text.of("Console Command!"))
				.permission("perm.console")
				.arguments(GenericArguments.string(Text.of("player")),GenericArguments.string(Text.of("change")))
				.executor(new Console())
				.build();
		CommandSpec edit = CommandSpec.builder()
				.description(Text.of("Edit Pixelmon Attributes!"))
				.arguments(GenericArguments.integer(Text.of("slot")),GenericArguments.string(Text.of("change")), GenericArguments.string(Text.of("detail")))
				.executor(new Edit())
				.build();
		CommandSpec createIsland = CommandSpec.builder()
				.description(Text.of("Create An Island!"))
				.executor(new IslandCreate())
				.build();
		CommandSpec removeIsland = CommandSpec.builder()
				.description(Text.of("Remove An Island!"))
				.arguments(GenericArguments.optional(GenericArguments.string(Text.of("confirm"))))
				.executor(new IslandRemove())
				.build();
		CommandSpec home = CommandSpec.builder()
				.description(Text.of("Teleport To Your Island's Home!"))
				.arguments(GenericArguments.optional(GenericArguments.string(Text.of("name"))))
				.executor(new IslandHome())
				.build();
		CommandSpec setHome = CommandSpec.builder()
				.description(Text.of("Set Your Island's Home!"))
				.executor(new IslandSetHome())
				.build();
		CommandSpec invite = CommandSpec.builder()
				.description(Text.of("Invite Someone To Your Island!"))
				.arguments(GenericArguments.string(Text.of("invite")))
				.executor(new IslandInvite())
				.build();
		CommandSpec removeInvite = CommandSpec.builder()
				.description(Text.of("Deny Someone Access To Your Island!"))
				.arguments(GenericArguments.string(Text.of("invite")))
				.executor(new IslandRemoveInvite())
				.build();
		CommandSpec setBiome = CommandSpec.builder()
				.description(Text.of("Set Your Island's Biome!"))
				.arguments(GenericArguments.string(Text.of("biome")))
				.executor(new IslandSetBiome())
				.build();
		CommandSpec info = CommandSpec.builder()
				.description(Text.of("Check Your Island Info Or The Info Of Another Player's Island!"))
				.arguments(GenericArguments.optional(GenericArguments.string(Text.of("name"))))
				.executor(new IslandInfo())
				.build();
		CommandSpec island = CommandSpec.builder()
				.description(Text.of("Main Command For Pixelmon Island's!"))
				.child(createIsland, "create","c")
				.child(removeIsland, "remove","r")
				.child(home, "home","h")
				.child(setHome, "sethome","sh")
				.child(invite, "invite","i")
				.child(removeInvite, "removeinvite","rinvite","ri")
				.child(setBiome, "setbiome","sbiome","sb")
				.child(info, "info","i")
				.build();
		//args and perms
		CommandSpec addGym = CommandSpec.builder()
				.description(Text.of("Add A Gym!"))
				.permission("admin")
				.arguments(GenericArguments.string(Text.of("owner")),GenericArguments.string(Text.of("type")),GenericArguments.string(Text.of("min")),GenericArguments.string(Text.of("max")),GenericArguments.string(Text.of("badgeId")))
				.executor(new AddGym())
				.build();
		CommandSpec gymChallenges = CommandSpec.builder()
				.description(Text.of("Challenge A Gym Leader!"))
				.arguments(GenericArguments.string(Text.of("gym_leader")))
				.executor(new GymChallenge())
				.build();
		CommandSpec gymAcceptChallenges = CommandSpec.builder()
				.description(Text.of("Accept A Player's Request To Battle!"))
				.arguments(GenericArguments.string(Text.of("gym_leader")))
				.executor(new GymAcceptChallenge())
				.build();
		CommandSpec gymCancelChallenges = CommandSpec.builder()
				.description(Text.of("Cancel A Challenge To A Gym Leader!"))
				.executor(new GymCancelChallenge())
				.build();
		CommandSpec gymLeaderboard = CommandSpec.builder()
				.description(Text.of("See The Top 10 Gyms!"))
				.executor(new GymLeaderboard())
				.build();
		CommandSpec gymList = CommandSpec.builder()
				.description(Text.of("See A List Of All The Gyms!"))
				.executor(new GymList())
				.build();
		CommandSpec gymLose = CommandSpec.builder()
				.description(Text.of("Add A Loss Against A Gym Leader!"))
				.permission("gymLeader")
				.arguments(GenericArguments.string(Text.of("player")))
				.executor(new GymLose())
				.build();
		CommandSpec gymOnline = CommandSpec.builder()
				.description(Text.of("See A List Of Online Gyms!"))
				.executor(new GymOnline())
				.build();
		CommandSpec gymPlayerLeaderboard = CommandSpec.builder()
				.description(Text.of("See The Top 10 Players!"))
				.executor(new GymPlayerLeaderboard())
				.build();
		CommandSpec gymPlayerStats = CommandSpec.builder()
				.description(Text.of("Check The Stats Of A Player!"))
				.arguments(GenericArguments.optional(GenericArguments.string(Text.of("player"))))
				.executor(new GymPlayerStats())
				.build();
		CommandSpec gymStats= CommandSpec.builder()
				.description(Text.of("Check A Gym's Stats!"))
				.arguments(GenericArguments.string(Text.of("gym_leader")))
				.executor(new GymStats())
				.build();
		CommandSpec gymWin = CommandSpec.builder()
				.description(Text.of("Add A Win Against A Gym Leader!"))
				.permission("gymLeader")
				.arguments(GenericArguments.string(Text.of("player")))
				.executor(new GymWin())
				.build();
		CommandSpec removeGym = CommandSpec.builder()
				.description(Text.of("Remove A Gym!"))
				.permission("admin")
				.arguments(GenericArguments.string(Text.of("owner")))
				.executor(new RemoveGym())
				.build();
		CommandSpec gyms = CommandSpec.builder()
				.description(Text.of("Main Command For Gyms!"))
				.child(gymList, "list","l")
				.child(gymOnline,"online","o")
				.child(gymChallenges,"challenge","c")
				.child(gymAcceptChallenges, "acceptchallenge","ac")
				.child(gymCancelChallenges, "cancelchallenge","cc")
				.child(gymLeaderboard,"leaderboard","l")
				.child(gymPlayerLeaderboard,"pleaderboard","pl")
				.child(gymStats,"stat","s")
				.child(gymPlayerStats,"pstat","ps")
				.child(gymWin,"addwin","aw")
				.child(gymLose,"addlose","al")
				.child(addGym,"addgym","ag")
				.child(removeGym,"removegym","rg")
				.build();
		CommandSpec addExp = CommandSpec.builder()
				.description(Text.of("Add Exp To A Player!"))
				.permission("console")
				.arguments(GenericArguments.string(Text.of("player")),GenericArguments.integer(Text.of("amount")))
				.executor(new AddExp())
				.build();
		game.getCommandManager().register(this, addExp, "addxp");
		game.getCommandManager().register(this, pixelmonGame, "game","spb","superpixelmonbros");
		game.getCommandManager().register(this, console, "console");
		game.getCommandManager().register(this, edit, "edit");
		game.getCommandManager().register(this, island, "island","islands");
		game.getCommandManager().register(this, gyms, "gym","gyms");
	}
	@Listener
	public void onServerStarted(GameStartedServerEvent e){
		ConfigurationManager.getInstance().loadConfig();
		IslandManager.getInstance().onStart();
		ExperienceManager.getInstance().onStart();
		GymManager.getInstance().onStart();
		Interact.getInstance().onStart();
	}
	@Listener
	public void onServerStop(GameStoppingServerEvent e){
		HashMap<Player, ArrayList<ItemStack>> map = Inventories.getInstance().getMap();
		for(Player p:map.keySet()){
			p.getInventory().clear();
			for(ItemStack i :Inventories.getInstance().getInventory(p)){
				if(i.getItem().equals(ItemTypes.CHAINMAIL_HELMET)||i.getItem().equals(ItemTypes.LEATHER_HELMET)||i.getItem().equals(ItemTypes.DIAMOND_HELMET)||i.getItem().equals(ItemTypes.GOLDEN_HELMET)||i.getItem().equals(ItemTypes.IRON_HELMET)){
					p.setHelmet(i);
				}else
					if(i.getItem().equals(ItemTypes.CHAINMAIL_CHESTPLATE)||i.getItem().equals(ItemTypes.LEATHER_CHESTPLATE)||i.getItem().equals(ItemTypes.DIAMOND_CHESTPLATE)||i.getItem().equals(ItemTypes.GOLDEN_CHESTPLATE)||i.getItem().equals(ItemTypes.IRON_CHESTPLATE)||i.getItem().equals(ItemTypes.ELYTRA)){
						p.setChestplate(i);
					}else
						if(i.getItem().equals(ItemTypes.CHAINMAIL_LEGGINGS)||i.getItem().equals(ItemTypes.LEATHER_LEGGINGS)||i.getItem().equals(ItemTypes.DIAMOND_LEGGINGS)||i.getItem().equals(ItemTypes.GOLDEN_LEGGINGS)||i.getItem().equals(ItemTypes.IRON_LEGGINGS)){
							p.setLeggings(i);
						}else
							if(i.getItem().equals(ItemTypes.CHAINMAIL_BOOTS)||i.getItem().equals(ItemTypes.LEATHER_BOOTS)||i.getItem().equals(ItemTypes.DIAMOND_BOOTS)||i.getItem().equals(ItemTypes.GOLDEN_BOOTS)||i.getItem().equals(ItemTypes.IRON_BOOTS)){
								p.setBoots(i);
							}else
								p.getInventory().offer(i);
			}
			Inventories.getInstance().removeInventory(p);
			if(PlayerDeath.getInstance().hasLives(p)){
				PlayerDeath.getInstance().removeLives(p);
			}
		}
	}
}
