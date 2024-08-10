package cc.unilock.reikafixes;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@LateMixin
public class LateMixinLoader implements ILateMixinLoader {
    @Override
    public String getMixinConfig() {
        return "mixins.reikafixes.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
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
        if (loadedMods.contains("RotaryCraft")) {
            mixins.add("rotarycraft.ISBRHMixins");
        }
        return mixins;
    }
}
