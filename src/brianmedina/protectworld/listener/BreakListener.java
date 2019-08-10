package brianmedina.protectworld.listener;

import brianmedina.protectworld.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.utils.Config;

public class BreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Config config = new Config(Main.data_folder + "/config.json", Config.JSON);
        Player player = event.getPlayer();
        String level_name = player.getLevel().getFolderName();
        if(config.exists("worlds." + level_name)){
            if(config.getBoolean("worlds." + level_name + ".break")){
                event.setCancelled();
            }
        }
    }
}
