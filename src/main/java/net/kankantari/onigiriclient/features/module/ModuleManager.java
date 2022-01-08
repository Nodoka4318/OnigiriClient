package net.kankantari.onigiriclient.features.module;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new MyFirstModule());
    }
}
