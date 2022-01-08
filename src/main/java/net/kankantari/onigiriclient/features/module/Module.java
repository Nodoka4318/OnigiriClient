package net.kankantari.onigiriclient.features.module;

import net.minecraftforge.common.MinecraftForge;

public class Module {
    public String name;
    public Category category;
    public boolean istoggled;
    public int keybind;

    public Module(String name, Category category, int keybind) {
        super();
        this.name = name;
        this.category = category;
        this.keybind = keybind;
        this.istoggled = false;
    }

    //有効にしたとき、全モジュールに共通して行われる処理
    public void Enable() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    //無効にしたとき、全モジュールに共通して行われる処理
    public void Disable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public void onEnable() { }
    public void onDisable() { }
    public void onUpdate() { }

    public void toggle() {
        if (istoggled) {
            onDisable();
            Disable();
        } else {
            Enable();
            onEnable();
        }
        istoggled = !istoggled;
    }
}
