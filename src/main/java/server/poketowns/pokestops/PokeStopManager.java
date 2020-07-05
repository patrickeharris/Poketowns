package server.poketowns.pokestops;

import java.util.concurrent.TimeUnit;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.item.inventory.property.SlotPos;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.Poketowns;

public class PokeStopManager {
	int times = 0;
	Poketowns plugin = new Poketowns();
    Scheduler scheduler = Sponge.getScheduler();
    Task.Builder taskBuilder = scheduler.createTaskBuilder();
	Items items = new Items();
	private Inventory i;
	public void PokeStop(final Player p) throws InterruptedException{
		Inventory i = Sponge.getRegistry().createBuilder(Inventory.Builder.class).of(InventoryArchetypes.CHEST)
				.property(InventoryDimension.PROPERTY_NAM, new InventoryDimension(9, 1))
				.property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(Text.of("PokeStop")))
				.build(this.plugin);
		this.i=i;
		items.addItems();
		build();
		p.openInventory(i,Cause.of(NamedCause.source(p)));
		 Task task = taskBuilder.execute(new Runnable() {
			public void run() {
				if(times<25){
					move();
					p.playSound(SoundTypes.BLOCK_COMPARATOR_CLICK, p.getLocation().getPosition(), 50);
				}
				times++;
				if(times==25){
					end(p);
				}
			}
		})
		            .async()
		            .name("pokestop")
		            .interval(250, TimeUnit.MILLISECONDS)
		            .submit(Sponge.getPluginManager().getPlugin("server").get().getInstance().get());

	}
	public void build(){
		if(i!=null){
			i.query(SlotPos.of(0,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(1,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(2,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(3,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(4,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(5,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(6,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(7,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			i.query(SlotPos.of(8,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
		}
	}
	public void move(){
		if(i.query(SlotPos.of(0,0)).peek().isPresent()&&i.query(SlotPos.of(1,0)).peek().isPresent()&&i.query(SlotPos.of(2,0)).peek().isPresent()&&i.query(SlotPos.of(3,0)).peek().isPresent()&&i.query(SlotPos.of(4,0)).peek().isPresent()&&i.query(SlotPos.of(5,0)).peek().isPresent()&&i.query(SlotPos.of(6,0)).peek().isPresent()&&i.query(SlotPos.of(7,0)).peek().isPresent()&&i.query(SlotPos.of(8,0)).peek().isPresent()){
			ItemStack i1 = i.query(SlotPos.of(0,0)).peek().get();
			i.query(SlotPos.of(0,0)).poll();
			ItemStack i2 = i.query(SlotPos.of(1,0)).peek().get();
			i.query(SlotPos.of(1,0)).poll();
			ItemStack i3 = i.query(SlotPos.of(2,0)).peek().get();
			i.query(SlotPos.of(2,0)).poll();
			ItemStack i4 = i.query(SlotPos.of(3,0)).peek().get();
			i.query(SlotPos.of(3,0)).poll();
			ItemStack i5 = i.query(SlotPos.of(4,0)).peek().get();
			i.query(SlotPos.of(4,0)).poll();
			ItemStack i6 = i.query(SlotPos.of(5,0)).peek().get();
			i.query(SlotPos.of(5,0)).poll();
			ItemStack i7 = i.query(SlotPos.of(6,0)).peek().get();
			i.query(SlotPos.of(6,0)).poll();
			ItemStack i8 = i.query(SlotPos.of(7,0)).peek().get();
			i.query(SlotPos.of(7,0)).poll();
			i.query(SlotPos.of(8,0)).poll();
			i.query(SlotPos.of(0,0)).set(Sponge.getRegistry().createBuilder(ItemStack.Builder.class).itemType(Sponge.getRegistry().getType(ItemType.class, items.getRandom()).get()).quantity(items.randomInt()).build());
			if(i1!=null&&i2!=null&&i3!=null&&i4!=null&&i5!=null&&i6!=null&&i7!=null&&i8!=null){
				i.query(SlotPos.of(1,0)).set(i1);
				i.query(SlotPos.of(2,0)).set(i2);
				i.query(SlotPos.of(3,0)).set(i3);
				i.query(SlotPos.of(4,0)).set(i4);
				i.query(SlotPos.of(5,0)).set(i5);
				i.query(SlotPos.of(6,0)).set(i6);
				i.query(SlotPos.of(7,0)).set(i7);
				i.query(SlotPos.of(8,0)).set(i8);
			}else{
				i.query(SlotPos.of(0,0)).poll();
				i.query(SlotPos.of(1,0)).poll();
				i.query(SlotPos.of(2,0)).poll();
				i.query(SlotPos.of(3,0)).poll();
				i.query(SlotPos.of(4,0)).poll();
				i.query(SlotPos.of(5,0)).poll();
				i.query(SlotPos.of(6,0)).poll();
				i.query(SlotPos.of(7,0)).poll();
				i.query(SlotPos.of(8,0)).poll();
				
			}
		}else{
			i.query(SlotPos.of(0,0)).poll();
			i.query(SlotPos.of(1,0)).poll();
			i.query(SlotPos.of(2,0)).poll();
			i.query(SlotPos.of(3,0)).poll();
			i.query(SlotPos.of(4,0)).poll();
			i.query(SlotPos.of(5,0)).poll();
			i.query(SlotPos.of(6,0)).poll();
			i.query(SlotPos.of(7,0)).poll();
			i.query(SlotPos.of(8,0)).poll();
		}
	}
	public void end(Player p){
		i.query(SlotPos.of(0,0)).poll();
		i.query(SlotPos.of(1,0)).poll();
		i.query(SlotPos.of(2,0)).poll();
		i.query(SlotPos.of(3,0)).poll();
		i.query(SlotPos.of(5,0)).poll();
		i.query(SlotPos.of(6,0)).poll();
		i.query(SlotPos.of(7,0)).poll();
		i.query(SlotPos.of(8,0)).poll();
		if(i.query(SlotPos.of(4,0)).peek().isPresent()){
			ItemStack reward = i.query(SlotPos.of(4,0)).peek().get();
			p.sendMessage(Text.of(TextColors.GOLD, TextStyles.BOLD, "You Have Been Awarded ",reward.getQuantity(), " ",reward.getItem().getType().getName(),"!"));
			p.getInventory().offer(reward);
			p.closeInventory(Cause.of(NamedCause.source(p)));
		}else
			p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"You Tried To Grab An Item?? That's Cheating! Guess You Just Wasted Your Chance Today."));
	}
}
