package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all agent-like Entities.
 * 
 * @author Leggy
 *
 */
public abstract class AgentEntity extends Entity {

	/**
	 * Main constructor of the {@link AgentEntity} class
	 * @param x
	 * @param y
	 * @param lengthX
	 * @param lengthY
	 * @param type
	 */
	protected AgentEntity(double x, double y, int lengthX, int lengthY, ResourceType type) {
		super(x, y, lengthX, lengthY, type);
	}

}
