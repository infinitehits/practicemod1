package net.alex.practicemod.GUI;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;


public class GUI extends Screen {
    protected GUI(Text title) {
        super(title);
    }
    protected void init() {
        super.init();
        int x = width / 2; // X-coordinate
        int y = height / 2; // Y-coordinate
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        super.render(drawContext, mouseX, mouseY, delta);
    }
}

