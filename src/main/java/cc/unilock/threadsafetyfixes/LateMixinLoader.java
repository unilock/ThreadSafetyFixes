package cc.unilock.threadsafetyfixes;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@LateMixin
public class LateMixinLoader implements ILateMixinLoader {
    @Override
    public String getMixinConfig() {
        return "mixins.threadsafetyfixes.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
        if (loadedMods.contains("betterstorage")) {
            mixins.add("betterstorage.TileCBSMixins");
        }
        if (loadedMods.contains("ChromatiCraft")) {
            mixins.add("chromaticraft.ISBRHMixins");
        }
        if (loadedMods.contains("ElectriCraft")) {
            mixins.add("electricraft.CableRendererMixin");
        }
        if (loadedMods.contains("GeoStrata")) {
            mixins.add("geostrata.ISBRHMixins");
            mixins.add("geostrata.OreVeinRendererMixin");
        }
        if (loadedMods.contains("ImmersiveEngineering")) {
            mixins.add("immersiveengineering.ClientUtilsMixin");
        }
        if (loadedMods.contains("Mariculture")) {
            mixins.add("mariculture.RenderOysterMixin");
        }
        if (loadedMods.contains("RotaryCraft")) {
            mixins.add("rotarycraft.ISBRHMixins");
        }
        return mixins;
    }
}
