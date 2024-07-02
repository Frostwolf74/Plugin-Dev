package me.frostwolf74.eventlisteners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventListeners extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        System.out.println("Player " + event.getPlayer().getName() + " has joined the server");
        event.setJoinMessage(event.getPlayer().getName() + " has joined the server OwO");

        event.getPlayer().sendMessage( "Hey! Welcome to the plugin test server");
    }

    @EventHandler
    public void OnPlayerBreakEvent(BlockBreakEvent event){
        event.getPlayer().sendMessage("You broke " + event.getBlock().getBlockData().getMaterial().name());
    }

    @EventHandler
    public void OnPlayerPlaceEvenet(BlockPlaceEvent event){
        event.getPlayer().sendMessage("You placed " + event.getBlock().getBlockData().getMaterial().name());
    }

    @EventHandler
    public void OnPlayerBlockDamageEvent(BlockDamageEvent event){
        event.getPlayer().sendMessage("You are damaging " + event.getBlock().getBlockData().getMaterial().name());
    }

    @EventHandler
    public void OnPlayerTrampleEvent(BlockPhysicsEvent event){
        getServer().broadcastMessage("----->new block = " + event.getChangedType().name() + " original block = " + event.getSourceBlock().getBlockData().getMaterial().name() + "<------------");
        if(event.getChangedType().name().equals("DIRT") && event.getSourceBlock().getBlockData().getMaterial().name().equals("FARMLAND")){
            getServer().broadcastMessage("FARMLAND has been trampled");
        }
    }
}
