package uq.deco2800.ducktales.entities.worldentities;

import java.util.Random;

public class Tree extends WorldEntity{
	
	private static String[] TYPES = {"tree_1", "tree_2", "tree_3"};
	
	private int stage;
	private int Woodvalue = 0;

	public Tree(double x, double y) {
		super(x, y, 1, 1, TYPES[0]);
		this.stage = 0;
        this.Woodvalue = 0;
	}

	@Override
	public void tick() {
		Random random = new Random();
		
		if(random.nextDouble() < 0.005 && stage < TYPES.length - 1){
			stage++;
			updateType(TYPES[stage]);

			Woodvalue += 100;
			updateType(TYPES[Woodvalue]);
		}
		
	}

	@Override
	public boolean isPassable() {
		return false;
	}

    public int getTreeGrade(){
    	return this.Woodvalue;
	}
}
