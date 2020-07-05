package server.poketowns.supersmash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.entity.projectile.arrow.TippedArrow;
import org.spongepowered.api.entity.projectile.explosive.fireball.Fireball;
import org.spongepowered.api.entity.projectile.explosive.fireball.SmallFireball;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSources;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackGenerator;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.util.blockray.BlockRay;
import org.spongepowered.api.util.blockray.BlockRayHit;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;

import server.poketowns.Poketowns;

public class Abilities {
	Poketowns plugin;
	HashMap<Player, String>pokes = new HashMap<Player, String>();
	HashMap<Player, Long>cooldownPrimary = new HashMap<Player, Long>();
	HashMap<Player, Long>cooldownSecondary = new HashMap<Player, Long>();
	private static Abilities instance = new Abilities();
	public static Abilities getInstance(){
		return instance;
	}
	public void addPoke(Player p, String s){
			pokes.put(p, s);
			if(s=="charmander"){
				Abilities.getInstance().passiveCharmander(p);
			}
			if(s=="squirtle"){
				Abilities.getInstance().passiveSquirtle(p);
			}
			if(s=="bulbasaur"){
				Abilities.getInstance().passiveBulbasaur(p);
			}
	}
	public void removePoke(Player p){
		pokes.remove(p);
	}
	public String getPoke(Player p){
		return pokes.get(p);
	}
	
	//charmander: fire arrow, fire charge(Proximity from above?) passive:fire resist
	//squirtle: snowball, FLOWING_WATER wall (decays after 5 sec)
	//bulbasaur:
	
	//break/place block cancel event!!!!!!!!!!
	public void primaryCharmander(Player p){
		if(cooldownPrimary.containsKey(p)){
			if(cooldownPrimary.get(p)>System.currentTimeMillis()){
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Do This Again For ",(cooldownPrimary.get(p)-System.currentTimeMillis())/1000," seconds!"));
				return;
			}
			cooldownPrimary.replace(p, System.currentTimeMillis()+2000);
		}else
			cooldownPrimary.put(p, System.currentTimeMillis()+2000);
		Optional<TippedArrow> fireArrow = p.launchProjectile(TippedArrow.class);
		PotionEffectData arrowEffect = fireArrow.get().getOrCreate(PotionEffectData.class).get();
		arrowEffect.addElement(PotionEffect.builder().amplifier(0).duration(1000).potionType(PotionEffectTypes.WITHER).build());
		fireArrow.get().offer(arrowEffect);
		fireArrow.get().damage(1, DamageSources.FIRE_TICK);
		fireArrow.get().offer(Keys.AGE, 1100);
		Timer.getInstance().addEntity(fireArrow.get(), System.currentTimeMillis()+10000);
		//for(Entity e: fireArrow.get().getNearbyEntities(1)){
			//int x = e.getLocation().getBlockX();
			//int y = e.getLocation().getBlockY()+1;
			//int z = e.getLocation().getBlockZ();
			//Location<World> block = new Location<World>(Sponge.getServer().getWorld("world").get(),x,y,z);
			//block.setBlockType(BlockTypes.FIRE, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
		//}
	}
	public void secondaryCharmander(Player p){
		if(cooldownSecondary.containsKey(p)){
			if(cooldownSecondary.get(p)>System.currentTimeMillis()){
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Do This Again For ",(cooldownSecondary.get(p)-System.currentTimeMillis())/1000," seconds!"));
				return;
			}
			cooldownSecondary.replace(p, System.currentTimeMillis()+10000);
		}else
			cooldownSecondary.put(p, System.currentTimeMillis()+10000);
		Optional<SmallFireball> fireCharge = p.launchProjectile(SmallFireball.class);
		fireCharge.get().damage(2, DamageSources.FIRE_TICK);
	}
	public void passiveCharmander(Player p){
		PotionEffectData resist = p.getOrCreate(PotionEffectData.class).get();
		resist.addElement(PotionEffect.builder().amplifier(0).duration(10000).potionType(PotionEffectTypes.RESISTANCE).build());
		p.offer(resist);
	}
	public void primarySquirtle(Player p){
		if(cooldownPrimary.containsKey(p)){
			if(cooldownPrimary.get(p)>System.currentTimeMillis()){
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Do This Again For ",(cooldownPrimary.get(p)-System.currentTimeMillis())/1000," seconds!"));
				return;
			}
			cooldownPrimary.replace(p, System.currentTimeMillis()+2000);
		}else
			cooldownPrimary.put(p, System.currentTimeMillis()+2000);
		Optional<Snowball> snowBall = p.launchProjectile(Snowball.class);
		snowBall.get().damage(1, DamageSources.MELTING);
	}
	public void secondarySquirtle(Player p){
		BlockRay ray = BlockRay.from(p).distanceLimit(5).skipFilter(hit -> { //Java 8 Lamda
		    Extent extent = hit.getExtent(); //Get the extent from the ray hit
		    Vector3i pos = hit.getBlockPosition(); //Get the block pos of the ray hit
		    BlockType bType = extent.getBlockType(pos); //Get the type of block at the position
		    return !bType.equals(BlockTypes.AIR); //If it's air, exclude, otherwise its cool
		}).build();
		Optional block = ray.end();
		if(!block.isPresent()){
			p.sendMessage(Text.of("That Block Isn't Close Enough!"));
		}
		if (block.isPresent()) {
			if(cooldownSecondary.containsKey(p)){
				if(cooldownSecondary.get(p)>System.currentTimeMillis()){
					p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Do This Again For ",(cooldownSecondary.get(p)-System.currentTimeMillis())/1000," seconds!"));
					return;
				}
				cooldownSecondary.replace(p, System.currentTimeMillis()+10000);
			}else
				cooldownSecondary.put(p, System.currentTimeMillis()+10000);
            BlockRayHit defBlock = (BlockRayHit) block.get();
            BlockType type = p.getWorld().getLocation(defBlock.getPosition()).getBlockType();
           	p.sendMessage(Text.of("You are looking at a " + type.getName()));
           	int x = p.getWorld().getLocation(defBlock.getPosition()).getBlockX();
           	int y = p.getWorld().getLocation(defBlock.getPosition()).getBlockY();
           	int z = p.getWorld().getLocation(defBlock.getPosition()).getBlockZ();
           	//set blocks back after 5 sec, set up commands
        	Timer.getInstance().newTimer();
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+1, z), p.getWorld().getLocation(x, y+1, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+2, z), p.getWorld().getLocation(x, y+2, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+3, z), p.getWorld().getLocation(x, y+3, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+1, z), p.getWorld().getLocation(x+1, y+1, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+2, z), p.getWorld().getLocation(x+1, y+2, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+3, z), p.getWorld().getLocation(x+1, y+3, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+1, z), p.getWorld().getLocation(x-1, y+1, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+2, z), p.getWorld().getLocation(x-1, y+2, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+3, z), p.getWorld().getLocation(x-1, y+3, z).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+1, z+1), p.getWorld().getLocation(x, y+1, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+2, z+1), p.getWorld().getLocation(x, y+2, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+3, z+1), p.getWorld().getLocation(x, y+3, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+1, z-1), p.getWorld().getLocation(x, y+1, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+2, z-1), p.getWorld().getLocation(x, y+2, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+3, z-1), p.getWorld().getLocation(x, y+3, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+1, z+1), p.getWorld().getLocation(x+1, y+1, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+2, z+1), p.getWorld().getLocation(x+1, y+2, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+3, z+1), p.getWorld().getLocation(x+1, y+3, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+1, z-1), p.getWorld().getLocation(x-1, y+1, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+2, z-1), p.getWorld().getLocation(x-1, y+2, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+3, z-1), p.getWorld().getLocation(x-1, y+3, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+1, z-1), p.getWorld().getLocation(x+1, y+1, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+2, z-1), p.getWorld().getLocation(x+1, y+2, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+3, z-1), p.getWorld().getLocation(x+1, y+3, z-1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+1, z+1), p.getWorld().getLocation(x-1, y+1, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+2, z+1), p.getWorld().getLocation(x-1, y+2, z+1).getBlock());
           	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+3, z+1), p.getWorld().getLocation(x-1, y+3, z+1).getBlock());
           	p.getWorld().getLocation(x, y+1, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+2, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+3, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+1, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+2, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+3, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+1, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+2, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+3, z).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+1, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+2, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+3, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+1, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+2, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+3, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+1, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+2, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+3, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+1, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+2, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+3, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+1, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+2, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+3, z-1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+1, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+2, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+3, z+1).setBlockType(BlockTypes.FLOWING_WATER, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
		}
	}
	public void passiveSquirtle(Player p){
		PotionEffectData fireResist = p.getOrCreate(PotionEffectData.class).get();
		fireResist.addElement(PotionEffect.builder().amplifier(0).duration(10000).potionType(PotionEffectTypes.FIRE_RESISTANCE).build());
		p.offer(fireResist);
	}
	public void primaryBulbasaur(Player p){
		if(cooldownPrimary.containsKey(p)){
			if(cooldownPrimary.get(p)>System.currentTimeMillis()){
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Do This Again For ",(cooldownPrimary.get(p)-System.currentTimeMillis())/1000," seconds!"));
				return;
			}
			cooldownPrimary.replace(p, System.currentTimeMillis()+2000);
		}else
			cooldownPrimary.put(p, System.currentTimeMillis()+2000);
		Optional<TippedArrow> blockArrow = p.launchProjectile(TippedArrow.class);
		//FallingBlock entity = (FallingBlock) Sponge.getServer().getWorld("world").get().createEntity(EntityTypes.FALLING_BLOCK, p.getLocation().getPosition().add(0, 15, 0));
        //entity.offer(Keys.CAN_PLACE_AS_BLOCK, true);
       // entity.offer(Keys.CAN_DROP_AS_ITEM, true);
        //entity.offer(Keys.FALL_TIME, 120);
		ArmorStand entity2 = (ArmorStand) Sponge.getServer().getWorld("world").get().createEntity(EntityTypes.ARMOR_STAND, p.getLocation().getPosition());
		ItemStack i = ItemStack.of(ItemTypes.DIRT, 1);
		//blockArrow.get().offer(Keys.VANISH, true);
		blockArrow.get().offer(Keys.AGE, 1100);
		entity2.setHelmet(i);
		entity2.offer(Keys.INVISIBLE, true);
		entity2.offer(Keys.ARMOR_STAND_IS_SMALL, true);
		entity2.offer(Keys.ARMOR_STAND_MARKER, true);
		entity2.offer(Keys.AGE, 59900);
		entity2.offer(Keys.ARMOR_STAND_HAS_BASE_PLATE, false);
		entity2.offer(Keys.HAS_GRAVITY, false);
		Timer.getInstance().addEntity(entity2, System.currentTimeMillis()+10000);
		Timer.getInstance().addEntity(blockArrow.get(), System.currentTimeMillis()+10000);
		//entity.offer(Keys.VELOCITY, new Vector3d(0.0, 0.0, 0.0));
        //BlockState blockState = Sponge.getServer().getWorld("world").get().getBlock(p.getLocation().getPosition().toInt().sub(0, 1, 0));
        //entity.offer(Keys.FALLING_BLOCK_STATE, blockState);
		Sponge.getServer().getWorld("world").get().spawnEntity(entity2, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
		blockArrow.get().addPassenger(entity2);
		blockArrow.get().damage(3, DamageSources.GENERIC);
	}
	public void secondaryBulbasaur(Player p){
		if(cooldownSecondary.containsKey(p)){
			if(cooldownSecondary.get(p)>System.currentTimeMillis()){
				p.sendMessage(Text.of(TextColors.RED, TextStyles.BOLD,"You Cannot Do This Again For ",(cooldownSecondary.get(p)-System.currentTimeMillis())/1000," seconds!"));
				return;
			}
			cooldownSecondary.replace(p, System.currentTimeMillis()+10000);
		}else
			cooldownSecondary.put(p, System.currentTimeMillis()+10000);
           	int x = p.getLocation().getBlockX();
           	int y = p.getLocation().getBlockY();
           	int z = p.getLocation().getBlockZ();
           	//set blocks back after 5 sec, set up commands
        	Timer.getInstance().newTimer();
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y, z), p.getWorld().getLocation(x+1, y, z).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x+1, y+1, z), p.getWorld().getLocation(x+1, y+1, z).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+2, z), p.getWorld().getLocation(x, y+2, z).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y, z+1), p.getWorld().getLocation(x, y, z+1).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+1, z+1), p.getWorld().getLocation(x, y+1, z+1).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y, z), p.getWorld().getLocation(x-1, y, z).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x-1, y+1, z), p.getWorld().getLocation(x-1, y+1, z).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y, z-1), p.getWorld().getLocation(x, y, z-1).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y+1, z-1), p.getWorld().getLocation(x, y+1, z-1).getBlock());
        	Timer.getInstance().addBlock(System.currentTimeMillis()+5000, p.getWorld().getLocation(x, y-1, z), p.getWorld().getLocation(x, y-1, z).getBlock());
           	p.getWorld().getLocation(x+1, y, z).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x+1, y+1, z).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+2, z).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y, z+1).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+1, z+1).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y, z).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x-1, y+1, z).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y, z-1).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
           	p.getWorld().getLocation(x, y+1, z-1).setBlockType(BlockTypes.DIRT, Cause.source(Sponge.getPluginManager().getPlugin("server").get()).build());
	}
	public void passiveBulbasaur(Player p){
		PotionEffectData speed = p.getOrCreate(PotionEffectData.class).get();
		speed.addElement(PotionEffect.builder().amplifier(0).duration(10000).potionType(PotionEffectTypes.SPEED).build());
		p.offer(speed);
	}
}
