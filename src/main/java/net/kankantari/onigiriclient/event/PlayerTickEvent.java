package net.kankantari.onigiriclient.event;

import net.kankantari.onigiriclient.OnigiriClient;
import net.kankantari.onigiriclient.features.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerTickEvent {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase != TickEvent.Phase.START)
            return;
        if (e.player != Minecraft.getMinecraft().player)
            return;
        for (Module m : OnigiriClient.module.modules) {
            if (m.istoggled)
                m.onUpdate();
        }
    }
}
