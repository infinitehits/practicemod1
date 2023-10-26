package net.alex.practicemod.modules;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public class Module {
    public String name;
    public Category category;
    public boolean enabled = false;
    public KeyBinding keybind;
    public static final MinecraftClient mc = MinecraftClient.getInstance();


    public Module(String name, Category category, KeyBinding keybind ){
        this.name = name;
        this.category = category;
        this.keybind = keybind;
    }

    public void toggle(){
        enabled = !enabled;
        if (enabled == true) onEnable();
        else onDisable();
    }

    public void tick(){

    }
    public KeyBinding getKeybind() {
        return this.keybind;
    }

    public String getName(){
        return this.name;
    }

    public Category getCategory(){
        return this.category;
    }

    public boolean isEnabled(){
        return this.enabled;
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public enum Category {
        COMBAT("Combat"),
        MISC("Misc"),
        RENDER("Render"),
        MOVEMENT("Movement"),
        PLAYER("Player");



        private final String name;

        Category(String n) {
            name = n;
        }

        public String getName() {
            return name;
        }
    }
}
