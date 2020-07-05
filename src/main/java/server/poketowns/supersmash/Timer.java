package server.poketowns.supersmash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class Timer {
	private static Timer instance = new Timer();
	private Boolean x = false;
	public HashMap<Entity, Long>old = new HashMap<Entity, Long>();
	public ArrayList<Long>longs= new ArrayList<Long>();
	public ArrayList<Location<World>>locs= new ArrayList<Location<World>>();
	public ArrayList<BlockState>bType= new ArrayList<BlockState>();
	public static Timer getInstance(){
		return instance;
	}
	public void addEntity(Entity e, Long l){
		for(Entity et: old.keySet()){
			if(old.get(et)<System.currentTimeMillis()){
				et.remove();
				old.remove(et);
			}
		}
		old.put(e, l);
	}
	public void addBlock(Long l,Location<World>loc, BlockState b){
			longs.add(l);
			locs.add(loc);
			bType.add(b);
	}
	public boolean isEmpty(){
		return longs.isEmpty();
	}
	public void removeBlocks(){
		//error because this is 1 instance need to make multiple but have same hashmap
		if(!longs.isEmpty()){
			if(x==false){
				x=true;
				Long l = longs.get(0);
					if(System.currentTimeMillis()>l){
						Location<World>loc = locs.get(0);
						BlockState b = bType.get(0);
						loc.setBlock(b, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
						longs.remove(0);
						locs.remove(0);
						bType.remove(0);
					}
				x=false;
			}
		}
	}
	public void newTimer(){
		Task t = Sponge.getScheduler().createTaskBuilder()
		        .execute(task->{
		        	if(!longs.isEmpty()){
		    			if(x==false){
		    				x=true;
		    				Long l = longs.get(0);
		    					if(System.currentTimeMillis()>l){
		    						Location<World>loc = locs.get(0);
		    						BlockState b = bType.get(0);
		    						loc.setBlock(b, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
		    						longs.remove(0);
		    						locs.remove(0);
		    						bType.remove(0);
		    					}
		    				x=false;
		    			}
		    			if(longs.isEmpty()){
		    				task.cancel();
		    			}
		    		}
		        })
		        .interval(10, TimeUnit.MILLISECONDS)
		        .submit(Sponge.getPluginManager().getPlugin("server").get());
	}
}
