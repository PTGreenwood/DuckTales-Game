package uq.deco2800.ducktales.util;

/**
 * This class should be the interface for most secondary managers
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public interface SecondaryManager {

    /**
     * Reload all information of the view objects managed by this manager.
     * This method is called whenever the model - the game world has been changed
     */
    public void reload();
}
