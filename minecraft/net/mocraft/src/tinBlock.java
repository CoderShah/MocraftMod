package net.mocraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class tinBlock extends Block{
	public tinBlock(int k, int j){
		super(k,j,Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int idDropped(int k, Random r, int i){
		return MocraftBase.tinBlock.blockID;
		
	}
	
	public String getTextureFile(){
		return ("/mocraft/moddedTerrain.png");
	}
}
