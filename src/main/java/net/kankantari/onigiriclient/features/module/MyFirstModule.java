package net.kankantari.onigiriclient.features.module;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class MyFirstModule extends Module {
    public MyFirstModule() {
        super("MyFirstModule", Category.CLIENT, Keyboard.KEY_I);
    }

    @Override
    public void onEnable() {
        // enabled!! とチャットに送信
        Minecraft.getMinecraft().player.sendChatMessage("enabled!!");
    }

    @Override
    public void onDisable() {
        // disabled!! とチャットに送信
        Minecraft.getMinecraft().player.sendChatMessage("disabled!!");
    }
}
