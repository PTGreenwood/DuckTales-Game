package uq.deco2800.ducktales.features.hud.menu;

import org.junit.Test;

import uq.deco2800.ducktales.features.hud.menu.MenuManager.MenuType;

import org.junit.Assert;

public class GridActiveTest {
	@Test
	public void gridActiveTest() {
		GridActive gridActive = new GridActive();
		Assert.assertEquals(gridActive.getCurrentGridIndex(), 0);
		Assert.assertEquals(gridActive.getCurrentMenu(), null);

		gridActive.setCurrentGridIndex(5);
		Assert.assertEquals(gridActive.getCurrentGridIndex(), 5);

		// Not set to a valid index but is still allowed as this is outside the
		// pre-condition and does not guarantee anything.
		gridActive.setCurrentGridIndex(-5);
		Assert.assertEquals(gridActive.getCurrentGridIndex(), -5);
		
		gridActive.setCurrentMenu(MenuType.ANIMAL);
		Assert.assertEquals(gridActive.getCurrentMenu(), MenuType.ANIMAL);
		
		gridActive.setCurrentMenu(MenuType.BUILDING);
		Assert.assertEquals(gridActive.getCurrentMenu(), MenuType.BUILDING);
		
		gridActive.setCurrentMenu(null);
		Assert.assertEquals(gridActive.getCurrentMenu(), null);
		
		gridActive.setGridActive(MenuType.ANIMAL, 0);
		Assert.assertEquals(gridActive.getCurrentMenu(), MenuType.ANIMAL);
		Assert.assertEquals(gridActive.getCurrentGridIndex(), 0);
	}
}
