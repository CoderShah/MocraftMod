package net.mocraft.src.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import net.mocraft.src.EntityWolfman;
import net.mocraft.src.ModelWolfman;
import net.mocraft.src.RenderWolfman;
import net.mocraft.src.common.CommonProxyMocraft;

public class ClientProxyMocraft extends CommonProxyMocraft{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/mocraft/moddedItems.png");
		MinecraftForgeClient.preloadTexture("/mocraft/moddedTerrain.png");
		RenderingRegistry.registerEntityRenderingHandler(EntityWolfman.class, new RenderWolfman(new ModelWolfman(), 0.3F));
	}
}
