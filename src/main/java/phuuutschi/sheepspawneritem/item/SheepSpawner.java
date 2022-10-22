package phuuutschi.sheepspawneritem.item;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

public class SheepSpawner extends Item {

    public static final String ItemName = "sheepspawner";

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final Item.Properties ItemProperties = new Item.Properties()
            .stacksTo(1)
            .tab(CreativeModeTab.TAB_TOOLS);

    public SheepSpawner() {
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

    public static RegistryObject<Item> register(DeferredRegister<Item> ItemRegister) {
        return ItemRegister.register(ItemName, SheepSpawner::new);
    }
}