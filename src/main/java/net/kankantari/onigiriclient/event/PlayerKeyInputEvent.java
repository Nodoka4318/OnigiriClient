package net.kankantari.onigiriclient.event;

import net.kankantari.onigiriclient.OnigiriClient;
import net.kankantari.onigiriclient.features.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class PlayerKeyInputEvent {
    @SubscribeEvent
    public void toggle(InputEvent.KeyInputEvent e) {
        if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world ==null)
            return;
        if (Keyboard.isCreated() && Keyboard.getEventKeyState()) {
            int key = Keyboard.getEventKey();
            for (Module m : OnigiriClient.module.modules) {
                if (m.keybind == key) {
                    m.toggle();
                    return;
                }
            }
        }
    }
}
