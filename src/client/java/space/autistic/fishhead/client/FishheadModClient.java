package space.autistic.fishhead.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.item.Items;

public class FishheadModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ArmorRenderer.register(new FishheadArmorRenderer(), Items.PUFFERFISH);
    }
}
