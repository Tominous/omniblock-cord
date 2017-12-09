package omniblock.cord.util.lib.textures;

import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

import omniblock.cord.util.lib.textures.events.IResourcePackSelectEvent;
import omniblock.cord.util.lib.textures.events.IResourcePackSendEvent;

/**
 * Created by Phoenix616 on 03.02.2016.
 */
public interface ResourcepacksPlugin {

    /**
     * Resends the pack that corresponds to the player's server
     * @param playerId The UUID of the player to resend the pack for
     */
    void resendPack(UUID playerId);

    /**
     * Set the resoucepack of a connected player
     * @param playerId The UUID of the player to set the pack for
     * @param pack The resourcepack to set for the player
     * @deprecated Please use {@link PackManager#setPack(UUID, ResourcePack)}!
     */
    @Deprecated
    void setPack(String playername, UUID playerId, ResourcePack pack);

    /**
     * Internal method to send a resoucepack to a player, please use {@link PackManager#setPack(UUID, ResourcePack)}!
     * @param playerId The UUID of the player to send the pack to
     * @param pack The resourcepack to send to a player
     */
    void sendPack(UUID playerId, ResourcePack pack);

    void clearPack(UUID playerId);

    PackManager getPackManager();

    UserManager getUserManager();

    /**
     * Get a message from the config
     * @param key The message's key
     * @return The defined message string or an error message if the variable isn't known.
     */
    String getMessage(String key);

    /**
     * Get a message from the config and replace variables
     * @param key The message's key
     * @param replacements The replacements in a mapping variable-replacement
     * @return The defined message string or an error message if the variable isn't known.
     */
    String getMessage(String key, Map<String, String> replacements);

    ResourcepacksPlayer getPlayer(UUID playerId);

    ResourcepacksPlayer getPlayer(String playerName);

    /**
     * Send a message to a player
     * @param player The the player
     * @param message The message to send
     * @return <tt>true</tt> if the message was sent; <tt>false</tt> if the player was offline
     */
    boolean sendMessage(ResourcepacksPlayer player, String message);

    /**
     * Send a message to a sender
     * @param sender The the sender
     * @param level The level to log to if the sender is the console!
     * @param message The message to send
     * @return <tt>true</tt> if the message was sent; <tt>false</tt> if the player was offline
     */
    boolean sendMessage(ResourcepacksPlayer sender, Level level, String message);

    /**
     * Check whether or not a player has a permission
     * @param resourcepacksPlayer The player to check
     * @param perm The permission to check for
     * @return <tt>true</tt> if the player has the permission; <tt>false</tt> if not
     */
    boolean checkPermission(ResourcepacksPlayer resourcepacksPlayer, String perm);

    /**
     * Check whether or not a player has a permission
     * @param playerId The UUID of the player
     * @param perm The permission to check for
     * @return <tt>true</tt> if the player has the permission; <tt>false</tt> if not
     */
    boolean checkPermission(UUID playerId, String perm);

    /**
     * Get the format of the pack this player can maximally use
     * @param playerId The UUID of the player
     * @return The pack format
     */
    int getPlayerPackFormat(UUID playerId);

    /**
     * Call the ResourcePackSelectEvent on the corresponding server
     * @param playerId The UUID of the player
     * @param pack The ResourcePack that was selected or null if none was selected
     * @param status The status of the selection
     * @return The ResourcePackSelectEvent interface which might have been modified (especially the pack)
     */
    IResourcePackSelectEvent callPackSelectEvent(UUID playerId, ResourcePack pack, IResourcePackSelectEvent.Status status);

    /**
     * Call the ResourcePackSendEvent on the corresponding server
     * @param playerId The UUID of the player
     * @param pack The ResourcePack that was send
     * @return The ResourcePackSendEvent interface which might have been modified or cancelled
     */
    IResourcePackSendEvent callPackSendEvent(UUID playerId, ResourcePack pack);

    /**
     * Check whether or not a certain player is currently logged in with auth plugins (currently supports AuthMe Reloaded)
     * @param playerId The UUID of the player
     * @return <tt>true</tt> if he is loggedin; <tt>false</tt> if not or the status is unknown
     */
    boolean isAuthenticated(UUID playerId);

    /**
     * Run a sync task
     * @param runnable What to run
     * @return The task id
     */
    int runTask(Runnable runnable);

    /**
     * Run a task asynchronously
     * @param runnable What to run
     * @return The task id
     */
    int runAsyncTask(Runnable runnable);

    /**
     * Set the pack that the player should get when logging in when no other pack applies
     * and that gets used instead of the empty pack on reset
     * @param playerId  UUID of the player
     * @param packName  Name of the pack
     */
    void setStoredPack(UUID playerId, String packName);

    /**
     * Get the pack that a certain player has stored
     * @param playerId  The UUID of the player
     * @return The name of the pack or <tt>null</tt> if none was stored
     */
    String getStoredPack(UUID playerId);

    /**
     * Get whether or not the default /usepack behaviour is to apply temporary opr permanent
     * @return <tt>true</tt> if it's temporary, <tt>false</tt> if not
     */
    boolean isUsepackTemporary();
}
