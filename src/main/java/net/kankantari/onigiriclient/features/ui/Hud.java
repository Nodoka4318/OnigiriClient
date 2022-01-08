package net.kankantari.onigiriclient.features.ui;

import net.kankantari.onigiriclient.OnigiriClient;
import net.kankantari.onigiriclient.features.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class Hud extends GuiScreen {
    Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void hud(RenderGameOverlayEvent e) {
        ScaledResolution resolution = new ScaledResolution(mc);
        FontRenderer renderer = mc.fontRenderer;

        if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            renderer.drawString(OnigiriClient.NAME + " " + OnigiriClient.VERSION, 1, 1, Color.CYAN.getRGB());
        }
        //array list
        if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            int y = 1;

            OnigiriClient.module.modules.sort(Comparator.comparingInt(Module::getNameLength).thenComparing(Module::getName));
            Collections.reverse(OnigiriClient.module.modules);

            for (Module m : OnigiriClient.module.modules) {
                if (m.istoggled) {
                    renderer.drawString(m.name, resolution.getScaledWidth() - renderer.getStringWidth(m.name), y, Color.GREEN.getRGB());
                    y += renderer.FONT_HEIGHT + 1;
                }
            }
        }
    }
}
