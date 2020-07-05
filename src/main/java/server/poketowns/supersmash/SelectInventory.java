package server.poketowns.supersmash;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import server.poketowns.Poketowns;

public class SelectInventory {
	Poketowns plugin = new Poketowns();
	public void addPlayer(Player p){
		Inventory i = Sponge.getRegistry().createBuilder(Inventory.Builder.class).of(InventoryArchetypes.CHEST)
				.property(InventoryDimension.PROPERTY_NAM, new InventoryDimension(9, 1))
				.property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(Text.of("Select A Class!")))
				.build(this.plugin);
		ItemStack i1 = ItemStack.of(ItemTypes.BLAZE_ROD, 1);
		i1.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED,"Charmander"));
		ItemStack i2 = ItemStack.of(ItemTypes.WATER_BUCKET, 1);
		i2.offer(Keys.DISPLAY_NAME, Text.of(TextColors.BLUE,"Squirtle"));
		ItemStack i3 = ItemStack.of(ItemTypes.GRASS, 1);
		i3.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GREEN,"Bulbasaur"));
		i.offer(i1);
		i.offer(i2);
		i.offer(i3);
		p.openInventory(i,Cause.of(NamedCause.source(p)));
	}
}
