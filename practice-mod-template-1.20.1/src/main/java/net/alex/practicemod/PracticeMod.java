package net.alex.practicemod;


import net.alex.practicemod.modules.Module;
import net.alex.practicemod.modules.misc.NearbyPlayers;
import net.alex.practicemod.modules.movement.Sprint;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static net.alex.practicemod.modules.Module.mc;



public class PracticeMod implements ModInitializer {
	public static ArrayList<Module> modules = new ArrayList<>();
	public static final String MOD_ID = "practicemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		System.out.println("test");
		modules.add(new Sprint());
		modules.add(new NearbyPlayers());
		ClientTickEvents.END_CLIENT_TICK.register(this::clientTickEvent);
	}

	public void clientTickEvent(MinecraftClient client) {

		if (mc.player == null || mc.world == null || mc.currentScreen != null) {
			return;
		}

		for (Module m : modules) {
			if (m.getKeybind().wasPressed()) {
				client.player.sendMessage(Text.literal(m.getName() + " toggled " + (m.isEnabled() ? "off" : "on")));
				m.toggle();
			}
			if (m.isEnabled()) {
				m.tick();
			}
		}
	}
}



