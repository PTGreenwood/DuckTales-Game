package uq.deco2800.ducktales.entities;

/**
 * Abstract representation of all agent-like Entities.
 * 
 * @author leggy
 *
 */
public abstract class AgentEntity extends Entity {

	protected AgentEntity(double x, double y, int lengthX, int lengthY, String type) {
		super(x, y, lengthX, lengthY, type);
	}

}
