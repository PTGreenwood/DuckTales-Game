package uq.deco2800.ducktales.util;

public class World {
	
	
	public int getWidth(){
		return 10;
	}
	
	
	public int getHeight(){
		return 10;
	}
	
	public boolean isPassable(int x, int y){
		if ((x == 2 && 2 < y && y < 5) || (y == 2 && 2 < x && x < 5)){
			return false;
		}
		return true;
	}

}
