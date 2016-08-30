package uq.deco2800.ducktales.resources;

/**
 * Created by Benson on 30/8/16.]
 * A class for retrieving and updating the amount of different resources
 */
public class InventoryManager {

    private int woodAmount = 0;
    private int minesAmount = 0;
    private int foodAmount = 0;

    //define methods to retrieve and update amount of wood
    public int getWoodAmount(){
        return this.woodAmount;
    }
    public void updateWoodAmount(int gap){
        this.woodAmount= this.woodAmount + gap;
    }

    //define methods to retrieve and update amount of mines
    public int getMinesAmount(){
        return this.minesAmount;
    }
    public void updateMinesAmount(int gap){
        this.minesAmount = this.minesAmount + gap;
    }

    //define methods to retrieve and update amount of food
    public int getFoodAmount(){
        return this.foodAmount;
    }
    public void updateFoodAmount(int gap){
        this.foodAmount = this.foodAmount + gap;
    }


}
