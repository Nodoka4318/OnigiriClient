package net.kankantari.onigiriclient.features.module.movement;

import net.kankantari.onigiriclient.features.module.Category;
import net.kankantari.onigiriclient.features.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.MOVEMENT, Keyboard.KEY_U);
    }

    @Override
    public void onUpdate() {
        if (Minecraft.getMinecraft().player.moveForward > 0) { //前に進んでいるならば
            Minecraft.getMinecraft().player.setSprinting(true); //走れ
        }
    }
}
