package net.mocraft.src;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.MinecraftForgeClient;
import net.mocraft.src.common.CommonProxyMocraft;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.modloader.ModLoaderEntitySpawnCallback;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod (modid = "mod_mocraft", name = "MoCraft", version = "Dev 1.0.0.0001 MC 1.4.7")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MocraftBase{
		//BLOCKS
		
		@SidedProxy(clientSide = "net.mocraft.src.client.ClientProxyMocraft", serverSide = "net.mocraft.src.common.CommonProxyMocraft")
		public static CommonProxyMocraft proxy;
		
		
		static int startEntityId = 300;
	
		public static final Block rainbowOre = new rainbowOre(3000,0).setHardness(3.0F).setBlockName("rainbowOre").setStepSound(Block.soundStoneFootstep);
		public static final Block rainbowBlock = new rainbowBlock(3001,1).setHardness(9.0F).setBlockName("rainbowBlock").setStepSound(Block.soundStoneFootstep);
		public static final Block copperOre = new copperOre(3002,3).setHardness(1.0F).setBlockName("copperOre").setStepSound(Block.soundStoneFootstep);
		public static final Block tinOre = new tinOre(3003,2).setHardness(1.0F).setBlockName("tinOre").setStepSound(Block.soundStoneFootstep);
		public static final Block copperBlock = new copperBlock(3004,4).setHardness(1.0F).setBlockName("copperBlock").setStepSound(Block.soundStoneFootstep);
		public static final Block tinBlock = new tinBlock(3005,5).setHardness(1.0F).setBlockName("tinBlock").setStepSound(Block.soundStoneFootstep);
		public static final Block springTrap = new springTrap(3006,6).setHardness(5*1.5F).setBlockName("springTrap").setStepSound(Block.soundStoneFootstep);
		public static final Block healingBlock = new healingBlock(3007,7).setHardness(5*1.5F).setBlockName("healingBlock").setStepSound(Block.soundStoneFootstep);
		
		
		//ITEMS
		public static final Item rainbowShard = new MocraftItems(3100).setIconCoord(0, 0).setItemName("rainbowShard");
		public static final Item fryingPan = new MocraftItems(3101).setIconCoord(1, 0).setItemName("fryingPan");
		public static final Item butter = new MocraftItems(3102).setIconCoord(2, 0).setItemName("butter");
		public static final Item rainbowGem = new MocraftItems(3103).setIconCoord(3, 0).setItemName("rainbowGem");
		public static final Item flour = new MocraftItems(3104).setIconCoord(4, 0).setItemName("flour");
		public static final Item copperChunk = new MocraftItems(3105).setIconCoord(5, 0).setItemName("copperChunk");
		public static final Item tinChunk = new MocraftItems(3106).setIconCoord(6, 0).setItemName("tinChunk");
		public static final Item copperIngot = new MocraftItems(3107).setIconCoord(8, 0).setItemName("copperIngot");
		public static final Item tinIngot = new MocraftItems(3108).setIconCoord(9, 0).setItemName("tinIngot");
		
		//FOOD
		public static final Item chocolateBar = new ItemFood(3200,4,0F,false).setIconCoord(7, 0).setItemName("chocolateBar").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		public static final Item orange = new ItemFood(3201,4,0F,false).setIconCoord(10, 0).setItemName("orange").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		public static final Item banana = new ItemFood(3202,4,0F,false).setIconCoord(11, 0).setItemName("banana").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		public static final Item fruitsalad = new ItemFood(3203,4,0F,false).setIconCoord(12, 0).setItemName("fruitsalad").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		public static final Item scone = new ItemFood(3204,4,0F,false).setIconCoord(13, 0).setItemName("scone").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		public static final Item strawberry = new ItemFood(3205,4,0F,false).setIconCoord(14, 0).setItemName("strawberry").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		public static final Item jam = new ItemFood(3206,4,0F,false).setIconCoord(15, 0).setItemName("jam").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		public static final Item jamscone = new ItemFood(3207,4,0F,false).setIconCoord(16, 0).setItemName("jamscone").setCreativeTab(CreativeTabs.tabFood).setTextureFile("/mocraft/moddedItems.png");
		
		//LOAD THE ITEMS
		@Init
		public void load(FMLInitializationEvent event){
			
			proxy.registerRenderThings();
			
			//Load the items into the game with the correct name
			GameRegistry.registerBlock(rainbowOre, "rainbowOre");
			LanguageRegistry.addName(rainbowOre, "Rainbow Ore");
			
			GameRegistry.registerBlock(copperOre, "copperOre");
			LanguageRegistry.addName(copperOre, "Copper Ore");
			
			GameRegistry.registerBlock(tinOre, "tinOre");
			LanguageRegistry.addName(tinOre, "Tin Ore");
			
			GameRegistry.registerBlock(healingBlock, "healingBlock");
			LanguageRegistry.addName(healingBlock, "Healing Block");

			GameRegistry.registerBlock(springTrap, "springTrap");
			LanguageRegistry.addName(springTrap, "Spring Trap");
			
			GameRegistry.registerBlock(rainbowBlock, "rainbowBlock");
			LanguageRegistry.addName(rainbowBlock, "Rainbow Block");
			
			GameRegistry.registerWorldGenerator(new MocraftWorldGenerator());
			GameRegistry.registerItem(rainbowShard, "rainbowShard");
			LanguageRegistry.addName(rainbowShard, "Rainbow Shard");
			
			GameRegistry.registerItem(fryingPan, "fryingPan");
			LanguageRegistry.addName(fryingPan, "Frying Pan");
			
			GameRegistry.registerItem(butter, "butter");
			LanguageRegistry.addName(butter, "Butter");
			
			GameRegistry.registerItem(rainbowGem, "rainbowGem");
			LanguageRegistry.addName(rainbowGem, "Rainbow Gem");
			
			GameRegistry.registerItem(flour, "flour");
			LanguageRegistry.addName(flour, "Flour");
			
			GameRegistry.registerItem(copperChunk, "copperChunk");
			LanguageRegistry.addName(copperChunk, "Copper Chunk");
			
			GameRegistry.registerItem(tinChunk, "tinChunk");
			LanguageRegistry.addName(tinChunk, "Tin Chunk");
			
			GameRegistry.registerItem(chocolateBar, "chocolateBar");
			LanguageRegistry.addName(chocolateBar, "Chocolate Bar");
			
			GameRegistry.registerItem(copperIngot, "copperIngot");
			LanguageRegistry.addName(copperIngot, "Copper Ingot");
			
			GameRegistry.registerItem(tinIngot, "tinIngot");
			LanguageRegistry.addName(tinIngot, "Tin Ingot");
			
			GameRegistry.registerItem(banana, "banana");
			LanguageRegistry.addName(banana, "Banana");
			
			GameRegistry.registerItem(orange, "orange");
			LanguageRegistry.addName(orange, "Orange");
			
			GameRegistry.registerItem(fruitsalad, "fruitsalad");
			LanguageRegistry.addName(fruitsalad, "Fruit Salad");
			
			GameRegistry.registerItem(scone, "scone");
			LanguageRegistry.addName(scone, "Plain Scone");
			
			GameRegistry.registerItem(strawberry, "strawberry");
			LanguageRegistry.addName(strawberry, "Strawberry");
			
			GameRegistry.registerItem(jam, "jam");
			LanguageRegistry.addName(jam, "Strawberry Jam");
			
			GameRegistry.registerItem(jamscone, "jamscone");
			LanguageRegistry.addName(jamscone, "Jam Scone");
			
			EntityRegistry.registerModEntity(EntityWolfman.class, "Wolfman", 1, this, 80, 3, true);
			
			EntityRegistry.addSpawn(EntityWolfman.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.forest);
			
			LanguageRegistry.instance().addStringLocalization("entity.mod_mocraft.Wolfman.name", "Wolfman");
			
			registerEntityEgg(EntityWolfman.class, 0xF2EDC2, 0x6B6B6B);
			
			addRecipes();
			addSmelting();
		}
		
		public static int getUniqueEntityId()
		{
			do
			{
				startEntityId++;
			}
			while(EntityList.getStringFromID(startEntityId) != null);
			
			return startEntityId;
		}
		
		public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
		{
			int id = getUniqueEntityId();
			EntityList.IDtoClassMapping.put(id, entity);
			EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
		}
		//Smelting Recipes
		public void addSmelting()
		{
			//Copper Ingot
			GameRegistry.addSmelting(copperChunk.itemID, new ItemStack(copperIngot, 1), 0F);
			
			//Tin Ingot
			GameRegistry.addSmelting(tinChunk.itemID, new ItemStack(tinIngot, 1), 0F);
		}
		//Crafting Recipes
		public void addRecipes(){
			
			//Rainbow Gem
			GameRegistry.addRecipe(new ItemStack(rainbowGem, 1), new Object[]{
				
				"#","#", Character.valueOf('#'), rainbowShard
				
			});
			
			//Chocolate Bar
			GameRegistry.addRecipe(new ItemStack(chocolateBar, 1), new Object[]{
				
				"#","S", Character.valueOf('#'), butter, Character.valueOf('S'), Item.sugar
				
			});
			
			//Rainbow Block
			GameRegistry.addRecipe(new ItemStack(rainbowBlock, 1), new Object[]{
				
				"###","###","###", Character.valueOf('#'), rainbowGem
				
			});
			
			//Flour
			GameRegistry.addRecipe(new ItemStack(flour, 1), new Object[]{
				
				"#", Character.valueOf('#'), Item.wheat
				
			});
			
			//Fruit Salad
			GameRegistry.addRecipe(new ItemStack(fruitsalad, 1), new Object[]{
				
				"A","B","O", Character.valueOf('A'), Item.appleRed, Character.valueOf('B'), banana, Character.valueOf('O'), orange
				
			});
			
			//Jam
			GameRegistry.addRecipe(new ItemStack(jam, 1), new Object[]{
				
				"#","S", Character.valueOf('#'), strawberry, Character.valueOf('S'), Item.sugar
				
			});
			
			//Jam Scone
			GameRegistry.addRecipe(new ItemStack(jamscone, 1), new Object[]{
				
				"J","S", Character.valueOf('J'), jam, Character.valueOf('S'), scone
				
			});
			
			//Plain Scone
			GameRegistry.addRecipe(new ItemStack(scone, 1), new Object[]{
				
				"F","B","E", Character.valueOf('F'), flour, Character.valueOf('B'), butter, Character.valueOf('E'), Item.egg
				
			});
			
			// Spring Trap
			GameRegistry.addRecipe(new ItemStack(springTrap, 1), new Object[]{
				
				"LLL","III","PPP", Character.valueOf('L'), Item.leather, Character.valueOf('I'), Item.ingotIron, Character.valueOf('P'), Block.stone
				
			});
			
			GameRegistry.addRecipe(new ItemStack(healingBlock, 1), new Object[]{
				
				"ABC","CAB","BCA", Character.valueOf('A'), Item.appleGold, Character.valueOf('B'), Item.goldenCarrot, Character.valueOf('C'),  Item.diamond
				
			});
			
		}
		
		
		@PreInit
		public void init(FMLPreInitializationEvent event){
			
		}
	
}
