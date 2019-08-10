package brianmedina.protectworld.listener;

import brianmedina.protectworld.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.utils.Config;

public class PlaceListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Config config = new Config(Main.data_folder + "/config.json", Config.JSON);
        Player player = event.getPlayer();
        String level_name = player.getLevel().getFolderName();
        if(config.exists("worlds." + level_name)){
            if(config.getBoolean("worlds." + level_name + ".place")){
                event.setCancelled();
            }
        }
    }
}
