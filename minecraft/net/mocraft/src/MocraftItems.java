package net.mocraft.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MocraftItems extends Item{
	public MocraftItems(int j){
		super(j);
		setCreativeTab(CreativeTabs.tabMaterials);
		
		
	}
	
	public String getTextureFile(){
		return ("/mocraft/moddedItems.png");
	}
}
