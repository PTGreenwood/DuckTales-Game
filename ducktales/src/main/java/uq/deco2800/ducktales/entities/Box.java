package uq.deco2800.ducktales.entities;

public class Box extends Entity{
	
	protected Box(int x, int y, int lengthX, int lengthY) {
		super(x, y, lengthX, lengthY);
	}

	public Box(int x, int y){
		super(x, y, 1, 1);
	}
	
	public String getType(){
		return "box";
	}
}
