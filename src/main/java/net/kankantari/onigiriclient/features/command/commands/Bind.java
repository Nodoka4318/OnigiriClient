package net.kankantari.onigiriclient.features.command.commands;

import net.kankantari.onigiriclient.OnigiriClient;
import net.kankantari.onigiriclient.features.command.Command;
import net.kankantari.onigiriclient.features.module.Module;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {
    public Bind() {
        super("Bind");
    }

    @Override
    public void onCommand() {
        try {
            for (Module m : OnigiriClient.module.modules) {
                if (m.name.toLowerCase().equals(getArg(1).toLowerCase())) {
                    m.keybind = Keyboard.getKeyIndex(getArg(2).toUpperCase());
                    sendMessage(m.name + " was bound to " + Keyboard.getKeyName(m.keybind));
                    return;
                }
            }
            sendMessage("no such module");
        } catch (Exception ex) {
            sendMessage("error");
        }
    }
}
