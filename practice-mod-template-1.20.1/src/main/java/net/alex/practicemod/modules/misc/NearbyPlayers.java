package net.alex.practicemod.modules.misc;
import net.alex.practicemod.modules.Module;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.InputUtil;
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
    public VertexConsumerProvider.Immediate immediate = mc.getBufferBuilders().getEffectVertexConsumers();
    ArrayList<Text> playerList = new ArrayList<>();
    DrawContext drawContext = new DrawContext(mc, immediate);
    @Override
    public void tick() {
        if (enabled) {
            playerList.clear();
            for (Entity entity : mc.world.getPlayers()) {
                playerList.add(entity.getName());
            }
        }

        drawText(drawContext,"test", 100, 100);
        if(!playerList.isEmpty()){

        }
    }
    private void drawText(DrawContext drawContext, String text, int x, int y ) {

        //drawContext.getMatrices().push();
        TextRenderer textRenderer = mc.textRenderer;
        drawContext.drawTextWithShadow(textRenderer, text,x,y,0x20FFFFFF);

        //immediate.draw();
        drawContext.getMatrices().pop();
    }
    @Override
    public void onEnable(){

    }
    @Override
    public void onDisable(){

    }
}
