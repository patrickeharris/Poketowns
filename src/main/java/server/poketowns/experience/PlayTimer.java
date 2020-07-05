package server.poketowns.experience;

import java.util.concurrent.TimeUnit;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import server.poketowns.supersmash.Timer;

public class PlayTimer {
	private static PlayTimer instance = new PlayTimer();
	public static PlayTimer getInstance(){
		return instance;
	}
	public void addPlayer(Player p){
			Task t = Sponge.getScheduler().createTaskBuilder()
			        .execute(task->{
			        	if(p.isOnline()){
			        		task.cancel();
			        	}
			        	ExperienceManager.getInstance().addXp(p, 10);
						p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Have Been Given 10 Experience For Playing For An Hour!"));
			        })
			        .interval(1, TimeUnit.HOURS)
			        .delay(1, TimeUnit.HOURS)
			        .submit(Sponge.getPluginManager().getPlugin("server").get());
	}
}
