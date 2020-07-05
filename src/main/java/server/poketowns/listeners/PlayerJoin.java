package server.poketowns.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;

import server.poketowns.experience.PlayTimer;

public class PlayerJoin {
	@Listener
	public void onPlayerJoin(ClientConnectionEvent.Join e){
		if(e.getCause().root() instanceof Player){
			Player p = (Player)e.getCause().root();
			PlayTimer.getInstance().addPlayer(p);
		}
	}
}
