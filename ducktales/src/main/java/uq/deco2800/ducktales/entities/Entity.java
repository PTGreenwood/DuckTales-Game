package uq.deco2800.ducktales.entities;

public class Entity implements Comparable<Entity> {

	private int x;
	private int y;

	private int lengthX;
	private int lengthY;

	public double dxbinside;

	private double dybtop;
	private double dybbottom;

	public Entity(int x, int y, int lengthX, int lengthY) {
		this.x = x;
		this.y = y;
		this.lengthX = lengthX;
		this.lengthY = lengthY;

		if (x > y) {
			dxbinside = (x - y - lengthX) / 2.0;
		} else if (y > x) {
			dxbinside = (y - x - lengthY) / 2.0;
		} else {
			dxbinside = -Math.max(lengthY, lengthX) / 2.0;
		}

		this.dybbottom = (y + x) / 2;
		this.dybtop = dybbottom - (double) (lengthX + lengthY) / 2;
	}

	@Override
	public int compareTo(Entity entity) {
		if (this.dybtop == entity.dybtop) {
			if (this.dybbottom == entity.dybbottom) {
				if (this.dxbinside == entity.dxbinside) {
					return 0;
				} else if (this.dxbinside < entity.dxbinside) {
					return -1;
				} else {
					return 1;
				}
			} else if (this.dybbottom < entity.dybbottom) {
				return -1;
			} else {
				return 1;
			}
		} else if (this.dybtop < entity.dybtop) {
			return -1;
		} else {
			return 1;
		}
	}

	public boolean equals(Object object) {
		if (!(object instanceof Entity)) {
			return false;
		}

		Entity entity = (Entity) object;
		return this.x == entity.x && this.y == entity.y
				&& this.lengthX == entity.lengthX
				&& this.lengthY == entity.lengthY;
	}

	public int hashCode() {
		return 4;
	}

	public String toString() {
		return String.format("[%d %d %d %d    %f]", x, y, lengthX, lengthY,
				dxbinside);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getYLength(){
		return lengthY;
	}
	public int getXLength(){
		return lengthX;
	}
	
	public String getType(){
		return "void";
	}

}
