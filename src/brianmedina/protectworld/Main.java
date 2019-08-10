package brianmedina.protectworld;

import brianmedina.protectworld.commands.ProtectWorldCommands;
import brianmedina.protectworld.listener.AllListener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;


public class Main extends PluginBase {

    public static File data_folder;

    @Override
    public void onEnable(){
        getDataFolder().mkdir();
        Config config = new Config(getDataFolder() + "/config.json", Config.JSON);
        if(!config.exists("worlds")){
            config.set("worlds." + getServer().getDefaultLevel().getFolderName() + ".place", true);
            config.set("worlds." + getServer().getDefaultLevel().getFolderName() + ".break", true);
            config.set("worlds." + getServer().getDefaultLevel().getFolderName() + ".pvp", true);
            config.set("worlds." + getServer().getDefaultLevel().getFolderName() + ".damage", true);
            config.set("worlds." + getServer().getDefaultLevel().getFolderName() + ".flint_and_steel_use", true);
            config.save();
        }
        data_folder = getDataFolder();
        new AllListener(this);
        String[] aliases = new String[1];
        aliases[0] = "protectworld";
        getServer().getCommandMap().register("pw", new ProtectWorldCommands("pw", "Protect World Commands", "/pw help", aliases));
        getLogger().info("§a--- -- ENABLED -- ---");
        getLogger().info("§a   --- TWITTER ---");
        getLogger().info("   §b@§aTheDevBrian");
        getLogger().info("§bhttps://twitter.com/TheDevBrian");
    }
}
