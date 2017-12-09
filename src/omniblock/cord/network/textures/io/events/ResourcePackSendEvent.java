package omniblock.cord.network.textures.io.events;

import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Event;
import omniblock.cord.util.lib.textures.ResourcePack;
import omniblock.cord.util.lib.textures.events.IResourcePackSendEvent;

import java.util.UUID;


/**
 * Created by Phoenix616 on 18.04.2015.
 */
public class ResourcePackSendEvent extends Event implements IResourcePackSendEvent, Cancellable {

    private boolean cancelled = false;
    private final UUID playerId;
    private ResourcePack pack;

    public ResourcePackSendEvent(UUID playerId, ResourcePack pack) {
        this.playerId = playerId;
        this.pack = pack;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public ResourcePack getPack() {
        return pack;
    }

    public void setPack(ResourcePack pack) {
        this.pack = pack;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
