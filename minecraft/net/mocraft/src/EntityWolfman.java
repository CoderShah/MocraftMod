package net.mocraft.src;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityWolfman extends EntityMob{

	public EntityWolfman(World par1World) {
		super(par1World);
		this.texture="/mocraft/mobs/Wolfman.png";
		this.moveSpeed= 0.25F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
	}
	
	public int getTotalArmorValue()
	{
		return 4;
	}
	
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}
	
	protected String getHurtSound()
	{
		return "mob.skeleton.hurt";
	}
	
	protected String getDeathSound()
	{
		return "mob.wolf.death";
	}
	
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.worldObj.playSoundAtEntity(this, "mob.zombie.wood", 0.15F, 1.0F);
	}
	
	protected boolean isAIEnabled()
	{
		return true;
	}
	
	protected int getDropItem()
	{
		return Item.bone.itemID;
	}
	
	protected void dropRareDrop(int par1)
	{
		switch(this.rand.nextInt(2))
		{
		case 0:
			this.dropItem(Item.shovelSteel.itemID, 1);
		case 1:
			this.dropItem(Item.diamond.itemID, 1);
		}
	}
	
	protected void dropFewItems(boolean par1, int par2)
	{
		if(this.rand.nextInt(4) == 0){
			this.dropItem(Item.flintAndSteel.itemID, 1);
		}
	}
	
	@Override
	public int getMaxHealth() {
		return 20;
	}
	
	public int getAttackStrength(Entity par1Entity){
		return 4;
	}
	
	public EnumCreatureAttribute getCreatureAttribute(){
		return EnumCreatureAttribute.UNDEAD;
	}

}
