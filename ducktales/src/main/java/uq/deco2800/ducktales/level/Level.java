package uq.deco2800.ducktales.level;

public class Level {
private static Level INSTANCE = new Level();
	
	int experience;
	int experienceTotal;
	int level;



	public static Level getInstance() {
		return INSTANCE;		
	}
	public Level(){
		this.experienceTotal = 0;
		this.level = 0;
	}
	public void LevelUp(){
		this.level = this.level + 1;
	}
	public void setLevel(int level){
		this.level = level;
	}
	public int getLevel(){
		return this.level;
	}
	
}
