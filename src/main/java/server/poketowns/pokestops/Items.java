package server.poketowns.pokestops;

import java.util.ArrayList;
import java.util.Random;

public class Items {
	private ArrayList<String> items = new ArrayList<String>();
	public void addItems(){
		items.add("minecraft:diamond");
		items.add("minecraft:coal");
		items.add("minecraft:iron_ingot");
		items.add("minecraft:gold_ingot");
		items.add("minecraft:slime_ball");
		items.add("minecraft:ghast_tear");
		items.add("minecraft:tripwire_hook");
		items.add("minecraft:porkchop");
		items.add("minecraft:blaze_powder");
		items.add("minecraft:carrot");
	}
	public String getRandom(){
		Random rand = new Random();
		int  n = rand.nextInt(items.size());
		return items.get(n);
	}
	public int randomInt(){
		Random rand = new Random();
		int  n = rand.nextInt(64);
		if(n==0){
			return 1;
		}
		return n;
	}
}
