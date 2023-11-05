package net.alex.practicemod.modules.misc;
import net.alex.practicemod.modules.Module;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import java.util.ArrayList;

public class NearbyPlayers extends Module {
    public static KeyBinding nearbyplayerskeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.example.nearbyplayerskeybind", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "key.category.example"));
    public NearbyPlayers() {
        super("Nearby Players", Category.MISC, nearbyplayerskeybind);
    }
    ArrayList<Text> playerList = new ArrayList<>();
    @Override
    public void tick() {
        if (enabled) {
            playerList.clear();
            for (Entity entity : mc.world.getPlayers()) {
                playerList.add(entity.getName());
            }
        }
        if(!playerList.isEmpty()){

        }
    }
    public static void drawText(WorldRenderContext context) {
        //mc.player.sendMessage(Text.literal("test1"));
        MatrixStack matrixStack = context.matrixStack();
        Matrix4f matrix4f = context.projectionMatrix();
        VertexConsumerProvider consumers = context.consumers();
        mc.textRenderer.draw("test", 100, 100, 0x111111, true, matrix4f, consumers,
                TextRenderer.TextLayerType.NORMAL,0x000000, LightmapTextureManager.MAX_LIGHT_COORDINATE);
    }
    @Override
    public void onEnable(){

    }
    @Override
    public void onDisable(){

    }
}
