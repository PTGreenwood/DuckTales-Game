package uq.deco2800.ducktales.features.hud.menu;

import uq.deco2800.ducktales.features.hud.menu.MenuManager.MenuType;

/**
 * The grid type and index that is visible on the HUD in the main game.
 * 
 * Note: Should be used as a singleton.
 * 
 * @author mattyleggy
 *
 */
public class GridActive {
	// the current menu active in the grid
	private MenuType currentMenu;
	// the grid index value for the current grid
	private int gridIndex;

	/*
	 * invariant:
	 * 
	 * gridIndex >= 0
	 * 
	 * currentMenu must be a valid menu type
	 * 
	 */

	/**
	 * 
	 * Constructor for grid active sets the current menu to null and current
	 * index value to 0.
	 * 
	 */
	public GridActive() {
		this.currentMenu = null;
		this.gridIndex = 0;
	}

	/**
	 * Set the current menu that is visible on the HUD to the provided menu.
	 * 
	 * @param currentMenu
	 *            the menu to set as the current
	 */
	public void setCurrentMenu(MenuType currentMenu) {
		this.currentMenu = currentMenu;
	}

	/**
	 * Change the grid index to the provided index for the menu which is visible
	 * in the HUD.
	 * 
	 * The provided index must be >= 0.
	 * 
	 * @param gridIndex
	 *            the index value to set as the current
	 */
	public void setCurrentGridIndex(int gridIndex) {
		this.gridIndex = gridIndex;
	}

	/**
	 * Return the menu which is currently active on the HUD.
	 * 
	 * @return the menu which is currently active
	 */
	public MenuType getCurrentMenu() {
		return this.currentMenu;
	}

	/**
	 * Return the current grid index value of the menu which is currently active
	 * on the HUD.
	 * 
	 * @return the current grid index value
	 */
	public int getCurrentGridIndex() {
		return this.gridIndex;
	}

	/**
	 * Change the currently active grid on the HUD to the provided menu and
	 * index value.
	 * 
	 * @param currentMenu
	 *            the menu to change as the current
	 * @param gridIndex
	 *            the index value to change as the current
	 */
	public void setGridActive(MenuType currentMenu, int gridIndex) {
		this.currentMenu = currentMenu;
		this.gridIndex = gridIndex;
	}
}
