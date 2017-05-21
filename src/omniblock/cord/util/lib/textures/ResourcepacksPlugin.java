package omniblock.cord.util.lib.textures;

import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import omniblock.cord.util.lib.textures.events.IResourcePackSelectEvent;
import omniblock.cord.util.lib.textures.events.IResourcePackSendEvent;

/**
 * Created by Phoenix616 on 03.02.2016.
 */
public interface ResourcepacksPlugin {

    /**
     * Get whether the plugin successful enabled or not
     * @return <tt>true</tt> if the plugin was proberly enabled
     */
    boolean isEnabled();

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
    void setPack(UUID playerId, ResourcePack pack);

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

    /**
     * Get the name of the plugin
     * @return The plugin's name as a string
     */
    String getName();

    /**
     * Get the version of the plugin
     * @return The plugin's version as a string
     */
    String getVersion();

    Logger getLogger();

    File getDataFolder();

    Level getLogLevel();

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

}
