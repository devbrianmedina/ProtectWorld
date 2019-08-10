package brianmedina.protectworld.listener;

import brianmedina.protectworld.Main;
import cn.nukkit.plugin.PluginManager;

public class AllListener {

    public AllListener(Main main){
        PluginManager listener = main.getServer().getPluginManager();
        listener.registerEvents(new PlaceListener(), main);
        listener.registerEvents(new BreakListener(), main);
        listener.registerEvents(new PvPListener(), main);
        listener.registerEvents(new DamageListener(), main);
        listener.registerEvents(new FlintSteelListener(), main);
    }
}
