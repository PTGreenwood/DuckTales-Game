package uq.deco2800.ducktales.util;

/**
 * Created by Khoi on 7/09/2016.
 */
public interface SecondaryManager {

    /**
     * Reload all information of the view objects managed by this manager.
     * This method is called whenever the model - the game world has been changed
     */
    public void reload();
}
