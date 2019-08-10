package brianmedina.protectworld.commands;

import brianmedina.protectworld.Main;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.Config;

import java.io.File;

public class ProtectWorldCommands extends Command implements PluginIdentifiableCommand {

    public ProtectWorldCommands(String name, String description, String usageMessage, String[] aliases) {
        super(name, description, usageMessage, aliases);
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(args.length > 0 && sender.isOp()){
            Config config = new Config(Main.data_folder + "/config.json", Config.JSON);
            switch (args[0].toLowerCase()){
                case "help":
                    sender.sendMessage("/pw help");
                    sender.sendMessage("/pw add <level_name>");
                    sender.sendMessage("/pw remove <level_name>");
                    sender.sendMessage("/pw <1/place> <level_name>");
                    sender.sendMessage("/pw <2/break> <level_name>");
                    sender.sendMessage("/pw <3/pvp> <level_name>");
                    sender.sendMessage("/pw <4/damage> <level_name>");
                    sender.sendMessage("/pw <5/flint> <level_name>");
                    return true;
                case "add":
                    if(args.length == 2){
                        if((new File("/worlds/" + args[1] + "/")).exists()){
                            sender.getServer().loadLevel(args[1]);
                            config.set("worlds." + args[1] + ".place", false);
                            config.set("worlds." + args[1] + ".break", false);
                            config.set("worlds." + args[1] + ".pvp", false);
                            config.set("worlds." + args[1] + ".damage", false);
                            config.set("worlds." + args[1] + ".flint_and_steel_use", false);
                            config.save();
                            sender.sendMessage("§cThe world was added to the configuration");
                        }
                    }
                    return true;
                case "remove":
                    if(args.length == 2){
                        if((new File("/worlds/" + args[1] + "/")).exists()) {
                            config.remove("worlds." + args[1]);
                            config.save();
                            sender.sendMessage("§cThe world has been completely unprotected");
                        }
                    }
                    return true;
                case "place":
                case "1":
                    if(args.length == 2){
                        if((new File("/worlds/" + args[1] + "/")).exists()) {
                            if(!config.getBoolean("worlds." + args[1] + ".place")){
                                config.set("worlds." + args[1] + ".place", true);
                                config.save();
                                sender.sendMessage("§aprotection enabled!");
                            } else {
                                config.set("worlds." + args[1] + ".place", false);
                                config.save();
                                sender.sendMessage("§4protection disabled!");
                            }
                        }
                    }
                    break;
                case "break":
                case "2":
                    if(args.length == 2){
                        if((new File("/worlds/" + args[1] + "/")).exists()) {
                            if(!config.getBoolean("worlds." + args[1] + ".break")){
                                config.set("worlds." + args[1] + ".break", true);
                                config.save();
                                sender.sendMessage("§aprotection enabled!");
                            } else {
                                config.set("worlds." + args[1] + ".break", false);
                                config.save();
                                sender.sendMessage("§4protection disabled!");
                            }
                        }
                    }
                    break;
                case "pvp":
                case "3":
                    if(args.length == 2){
                        if((new File("/worlds/" + args[1] + "/")).exists()) {
                            if(!config.getBoolean("worlds." + args[1] + ".pvp")){
                                config.set("worlds." + args[1] + ".pvp", true);
                                config.save();
                                sender.sendMessage("§aprotection enabled!");
                            } else {
                                config.set("worlds." + args[1] + ".pvp", false);
                                config.save();
                                sender.sendMessage("§4protection disabled!");
                            }
                        }
                    }
                    break;
                case "damage":
                case "4":
                    if(args.length == 2){
                        if((new File("/worlds/" + args[1] + "/")).exists()) {
                            if(!config.getBoolean("worlds." + args[1] + ".damage")){
                                config.set("worlds." + args[1] + ".damage", true);
                                config.save();
                                sender.sendMessage("§aprotection enabled!");
                            } else {
                                config.set("worlds." + args[1] + ".damage", false);
                                config.save();
                                sender.sendMessage("§4protection disabled!");
                            }
                        }
                    }
                    break;
                case "flint":
                case "5":
                    if(args.length == 2){
                        if((new File("/worlds/" + args[1] + "/")).exists()) {
                            if(!config.getBoolean("worlds." + args[1] + ".flint_and_steel_use")){
                                config.set("worlds." + args[1] + ".flint_and_steel_use", true);
                                config.save();
                                sender.sendMessage("§aprotection enabled!");
                            } else {
                                config.set("worlds." + args[1] + ".flint_and_steel_use", false);
                                config.save();
                                sender.sendMessage("§4protection disabled!");
                            }
                        }
                    }
                    break;
                default:
                    sender.sendMessage("/pw help");
                    sender.sendMessage("/pw add <level_name>");
                    sender.sendMessage("/pw remove <level_name>");
                    sender.sendMessage("/pw <1/place> <level_name>");
                    sender.sendMessage("/pw <2/break> <level_name>");
                    sender.sendMessage("/pw <3/pvp> <level_name>");
                    sender.sendMessage("/pw <4/damage> <level_name>");
                    sender.sendMessage("/pw <5/flint> <level_name>");
                    return true;
            }
        } else {
            sender.sendMessage(usageMessage);
        }
        return false;
    }

    @Override
    public Plugin getPlugin() {
        return null;
    }
}
