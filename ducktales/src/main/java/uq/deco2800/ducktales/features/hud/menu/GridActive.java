package uq.deco2800.ducktales.features.hud.menu;

import uq.deco2800.ducktales.features.hud.menu.MenuManager.MenuType;

/**
 * The current grid type and index that is visible on the HUD.
 * 
 * Note: Should be used as a singleton.
 * 
 * @author mattyleggy
 *
 */
public class GridActive {
	private MenuType currentMenu;
	private int gridIndex;
	
	public GridActive() {
		this.currentMenu = null;
		this.gridIndex = 0; 
	}
	
	public void setCurrentMenu(MenuType currentMenu) {
		this.currentMenu = currentMenu;
	}
	
	public void setCurrentGridIndex(int gridIndex) {
		this.gridIndex = gridIndex;
	}
	
	public MenuType getCurrentMenu() {
		return this.currentMenu;
	}
	
	public int getCurrentGridIndex() {
		return this.gridIndex;
	}
	
	public void setGridActive(MenuType currentMenu, int gridIndex) {
		this.currentMenu = currentMenu;
		this.gridIndex = gridIndex;
	}
}
