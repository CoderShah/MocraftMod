package net.mocraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class healingBlock extends Block{
	public healingBlock(int k, int j){
		super(k,j,Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int idDropped(int k, Random r, int i){
		return MocraftBase.healingBlock.blockID;
		
	}
	
	public String getTextureFile(){
		return ("/mocraft/moddedTerrain.png");
	}
	
	@Override
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int u1, float u2, float u3, float u4){
		
		player.setEntityHealth(20);
		player.sendChatToPlayer("Thou hast been healed");
		return false;
		
	}
}
