package phuuutschi.sheepspawneritem.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import phuuutschi.sheepspawneritem.Sheepspawneritem;

public class ModItems {
    public static final DeferredRegister<Item> ItemRegister = DeferredRegister.create(ForgeRegistries.ITEMS, Sheepspawneritem.ModId);

    public static final RegistryObject<Item> SheepSpawnerItem = SheepSpawner.register(ItemRegister);

    public static void register(IEventBus eventBus) {
        ItemRegister.register(eventBus);
    }
}
