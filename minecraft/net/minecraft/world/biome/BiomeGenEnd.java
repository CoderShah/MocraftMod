package net.minecraft.world.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;

public class BiomeGenEnd extends BiomeGenBase
{
    public BiomeGenEnd(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.field_82914_M.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = (byte)Block.dirt.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator = new BiomeEndDecorator(this);
    }

    @SideOnly(Side.CLIENT)

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
}
