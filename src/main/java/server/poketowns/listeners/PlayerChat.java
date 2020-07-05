package server.poketowns.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.experience.ExperienceManager;

public class PlayerChat {
	@Listener
	public void onMessage(MessageChannelEvent e){
		if(e.getCause().root() instanceof Player){
			Player p = (Player)e.getCause().root();
			TextRepresentable tr = e.getFormatter().getHeader().format().toBuilder().insert(0, Text.of(TextColors.GRAY,TextStyles.BOLD,"[", ExperienceManager.getInstance().getLevel(p), "] "));
			e.getFormatter().setHeader(tr);
		}
	}
}
