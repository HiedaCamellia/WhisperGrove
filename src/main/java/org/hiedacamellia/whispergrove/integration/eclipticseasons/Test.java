package org.hiedacamellia.whispergrove.integration.eclipticseasons;

import com.teamtea.eclipticseasons.api.constant.solar.SolarTerm;
import com.teamtea.eclipticseasons.api.util.EclipticUtil;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import org.hiedacamellia.whispergrove.Config;
import org.hiedacamellia.whispergrove.core.debug.Debug;

public class Test {

    public void test(Level level) {

        if(ModList.get().isLoaded("eclipticseasons")&& Config.eclipticCompact) {
            Debug.debug("EclipticSeasons is loaded");
            SolarTerm solarTerm = EclipticUtil.getNowSolarTerm(level);
        } else {
            Debug.debug("EclipticSeasons is not loaded");
        }
    }
}
