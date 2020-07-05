package server.poketowns.listeners;

import java.util.Optional;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.property.block.MatterProperty;
import org.spongepowered.api.data.property.block.MatterProperty.Matter;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class WaterFlow {
	@Listener
	public void stopLiquidFlow(ChangeBlockEvent.Pre event,@Root LocatableBlock block) {
		if(block.getBlockState().getType().equals(BlockTypes.FLOWING_WATER)){
			for (Location<World> trans : event.getLocations()) {
				if(trans.getX()<24470&&trans.getX()>24313&&trans.getZ()<26881&&trans.getZ()>26726&&event.getTargetWorld().getName().equals("world")){
	    			event.setCancelled(true);
	    		}
	    	}
	    }
	}
}
