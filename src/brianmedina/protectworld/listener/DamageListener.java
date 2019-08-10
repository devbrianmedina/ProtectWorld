package brianmedina.protectworld.listener;

import brianmedina.protectworld.Main;
import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.utils.Config;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        Config config = new Config(Main.data_folder + "/config.json", Config.JSON);
        Entity entity = event.getEntity();
        if(entity instanceof Player){
            Player player = ((Player) entity).getPlayer();
            String level_name = player.getLevel().getFolderName();
            if(config.exists("worlds." + level_name)){
                if(config.getBoolean("worlds." + level_name + ".damage")){
                    event.setCancelled();
                }
            }
        }
    }
}
