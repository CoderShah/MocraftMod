package net.mocraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class rainbowOre extends Block{
	public rainbowOre(int k, int j){
		super(k,j,Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int idDropped(int k, Random r, int i){
		return MocraftBase.rainbowShard.itemID;
		
	}
	
	public String getTextureFile(){
		return ("/mocraft/moddedTerrain.png");
	}
}
