package net.kankantari.onigiriclient.features.command.commands;

import net.kankantari.onigiriclient.OnigiriClient;
import net.kankantari.onigiriclient.features.command.Command;
import net.kankantari.onigiriclient.features.module.Module;

import java.util.Locale;

public class Toggle extends Command {
    public Toggle() {
        super("Toggle");
    }

    @Override
    public void onCommand() {
        try {
            for (Module m : OnigiriClient.module.modules) {
                if (m.name.toLowerCase().equals(getArg(1).toLowerCase())) {
                    m.toggle();
                    return;
                }
            }
            sendMessage("no such module");
        } catch (Exception ex) {
            sendMessage("error");
        }
    }
}
