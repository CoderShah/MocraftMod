package net.mocraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class rainbowBlock extends Block{
	public rainbowBlock(int k, int j){
		super(k,j,Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int idDropped(int k, Random r, int i){
		return MocraftBase.rainbowBlock.blockID;
		
	}
	
	public String getTextureFile(){
		return ("/mocraft/moddedTerrain.png");
	}
	
	@Override
	 public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
    }
}
