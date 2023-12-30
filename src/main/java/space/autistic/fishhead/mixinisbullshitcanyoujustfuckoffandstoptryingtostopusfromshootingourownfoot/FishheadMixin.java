package space.autistic.fishhead.mixinisbullshitcanyoujustfuckoffandstoptryingtostopusfromshootingourownfoot;

import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.SimpleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import space.autistic.fishhead.WearablePufferfishItem;

@Mixin(Items.class)
public class FishheadMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Items;register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;"), index = 1)
    private static Item fishhead_adjustPufferfish(String id, Item item) {
        if (id == "pufferfish") {
            return new WearablePufferfishItem(new Item.Settings().food(FoodComponents.PUFFERFISH));
        }
        return item;
    }

}
