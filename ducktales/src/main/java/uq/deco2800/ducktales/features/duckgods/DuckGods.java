package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

/**
 * Base class for all duck gods and their bonuses
 * 
 * @author Alison Collins
 * @author freddy
 *
 */

public class DuckGods {

	protected String requiredSacrifice;
	protected int requiredAmount;
	// The name of the duck god selected.
	protected String duckName;
	// The bonus implemented by the duck god.
	protected GodType godType;
	protected String bonus;
	// The image to be rendered of the duck god.
	protected ImageIcon image;

	/** flags to control the state of the god */
	protected boolean isBuilt = false;
	protected boolean isWorshiped = false;
	protected boolean isSelected = false;

	/**
	 * Main constructor of {@link DuckGods}.
	 * 
	 * @param name
	 * @param bonus
	 * @param image
	 */
	public DuckGods(String name, String bonus, ImageIcon image) {
		this.duckName = name;
		this.bonus = bonus;
		this.image = image;
	}

	public String getDuckName() {
		return duckName;
	}
}
