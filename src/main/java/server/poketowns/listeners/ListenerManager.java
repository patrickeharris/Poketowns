package server.poketowns.listeners;

import org.spongepowered.api.Game;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

public class ListenerManager {
	public void registerListeners(Game game, Plugin plugin){
		game.getEventManager().registerListeners(plugin, new Interact());
	}
	
	public void listListeners(){
		
	}
}
