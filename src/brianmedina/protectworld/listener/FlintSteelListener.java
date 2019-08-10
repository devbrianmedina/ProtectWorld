package brianmedina.protectworld.listener;

import brianmedina.protectworld.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.utils.Config;

public class FlintSteelListener implements Listener {

    @EventHandler
    public void onInteractFlint(PlayerInteractEvent event){
        Config config = new Config(Main.data_folder + "/config.json", Config.JSON);
        Player player = event.getPlayer();
        String level_name = player.getLevel().getFolderName();
        if(config.exists("worlds." + level_name)){
            if(config.getBoolean("worlds." + level_name + ".flint_and_steel_use")){
                if(event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK || event.getAction() == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK){
                    event.setCancelled();
                }
            }
        }
    }
}
