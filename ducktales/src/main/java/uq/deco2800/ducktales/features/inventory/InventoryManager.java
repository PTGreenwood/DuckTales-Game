package uq.deco2800.ducktales.features.inventory;

import javafx.scene.control.Label;

/**
 * Created by Benson on 30/8/16.]
 * A class for retrieving and updating the amount of different resources
 */
public class InventoryManager {

    
    private int woodAmount = 0;
    public int oresAmount = 0;
    public int foodAmount = 0;
    
    
    
    /** Variable for the UI elements */
    private Label woodLabel;
    private Label rockLabel;
    private Label foodLabel;
    private Label oresLabel;

    public InventoryManager() {
    
    }

	public InventoryManager(Label woodLabel, Label foodLabel, Label oresLabel) {
		// Wire up the UI elements
		this.woodLabel = woodLabel;
		this.foodLabel = foodLabel;
		this.oresLabel = oresLabel;
		
	}

    //define methods to retrieve and update amount of wood
    public int getWoodAmount(){
        return this.woodAmount;
    }
    public void updateWoodAmount(int gap){
        this.woodAmount= this.woodAmount + gap;

        // Update UI element
        this.woodLabel.setText("" + this.woodLabel);
    }

    //define methods to retrieve and update amount of mines
    public int getOresAmount(){
        return this.oresAmount;
    }
    public void updateOresAmount(int gap){
        this.oresAmount = this.oresAmount + gap;

        // Update UI element
        this.oresLabel.setText("" + this.oresAmount);
    }

    //define methods to retrieve and update amount of food
    public int getFoodAmount(){
        return this.foodAmount;
    }
    public void updateFoodAmount(int gap){
        this.foodAmount = this.foodAmount + gap;

        // Update UI element
        this.foodLabel.setText("" + this.foodAmount);
    }


}
