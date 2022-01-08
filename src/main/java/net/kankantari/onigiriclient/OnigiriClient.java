package net.kankantari.onigiriclient;

import net.kankantari.onigiriclient.event.PlayerKeyInputEvent;
import net.kankantari.onigiriclient.event.PlayerTickEvent;
import net.kankantari.onigiriclient.features.command.CommandManager;
import net.kankantari.onigiriclient.features.module.ModuleManager;
import net.kankantari.onigiriclient.features.ui.Hud;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = OnigiriClient.MODID, name = OnigiriClient.NAME, version = OnigiriClient.VERSION)
public class OnigiriClient {
    public static final String MODID = "onigiri";
    public static final String NAME = "Onigiri Client";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    public static ModuleManager module = new ModuleManager();
    public PlayerKeyInputEvent playerKeyInputEvent = new PlayerKeyInputEvent();
    public PlayerTickEvent playerTickEvent = new PlayerTickEvent();
    public Hud hud = new Hud();
    public CommandManager commands = new CommandManager();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle(NAME + " " + VERSION);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(playerKeyInputEvent);
        MinecraftForge.EVENT_BUS.register(playerTickEvent);
        MinecraftForge.EVENT_BUS.register(hud);
        MinecraftForge.EVENT_BUS.register(commands);
    }
}
