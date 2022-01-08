package net.kankantari.onigiriclient.features.module;

import net.kankantari.onigiriclient.features.module.movement.Sprint;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new MyFirstModule());
        modules.add(new Sprint());
    }
}
