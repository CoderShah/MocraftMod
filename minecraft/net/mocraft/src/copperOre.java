package net.mocraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class copperOre extends Block{
	public copperOre(int k, int j){
		super(k,j,Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int idDropped(int k, Random r, int i){
		return MocraftBase.copperChunk.itemID;
		
	}
	
	public String getTextureFile(){
		return ("/mocraft/moddedTerrain.png");
	}
}
