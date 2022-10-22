package phuuutschi.sheepspawneritem.item;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

public class SheepSpawnItem extends Item {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Item.Properties ItemProperties = new Item.Properties()
            .stacksTo(1)
            .tab(CreativeModeTab.TAB_TOOLS);

    public SheepSpawnItem() {
        super(ItemProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        var level = context.getLevel();
        var position = context.getClickLocation();

        var sheep = EntityType.SHEEP.create(level);
        if (sheep != null) {
            sheep.setPos(position);
            LOGGER.debug("created sheep at "+ sheep.getX()+", " +sheep.getY());

            level.addFreshEntity(sheep);
        }

        return InteractionResult.SUCCESS;
    }

    public static void register(IEventBus eventBus) {
        var ItemRegister = DeferredRegister.create(ForgeRegistries.ITEMS, "sheepspawneritem");
        ItemRegister.register(eventBus);
        ItemRegister.register("sheepspawner", SheepSpawnItem::new);
    }
}
