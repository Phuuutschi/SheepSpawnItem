package phuuutschi.sheepspawneritem;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import phuuutschi.sheepspawneritem.item.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Sheepspawneritem.ModId)
public class Sheepspawneritem {

    public static final String ModId = "sheepspawneritem";

    public Sheepspawneritem() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
