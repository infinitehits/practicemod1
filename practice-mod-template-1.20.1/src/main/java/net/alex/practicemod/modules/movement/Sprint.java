package net.alex.practicemod.modules.movement;
import net.alex.practicemod.modules.Module;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;



public class Sprint extends Module {
    public static KeyBinding sprintKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.example.sprintKeybind", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "key.category.example"));
    public Sprint() {
        super("Sprint", Category.MOVEMENT, sprintKeybind);
    }
    @Override
    public void tick(){
        if (mc.player.input.pressingForward && !mc.player.isSneaking() && !mc.player.horizontalCollision){
            mc.player.setSprinting(true);
        }
    }
    @Override
    public void onEnable(){

    }
    @Override
    public void onDisable(){
        mc.player.setSprinting(false);
    }
}
