package uq.deco2800.ducktales.resources;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Created by Benson on 30/8/16.]
 * A class for retrieving and updating the amount of different resources
 */
public class InventoryManager {

    private int woodAmount = 0;
    private int oresAmount = 0;
    private int foodAmount = 0;

    /** Variable for the UI elements */
    private ImageView woodSprite, rockSprite, foodSprite, oresSprite;
    private Label woodLabel, rockLabel, foodLabel, oresLabel;

    public InventoryManager() {

    }

    public InventoryManager(
            ImageView woodSprite, ImageView foodSprite, ImageView oresSprite,
            Label woodLabel, Label foodLabel, Label oresLabel) {
        // Wire up the UI elements
        this.woodLabel = woodLabel;
        this.woodSprite = woodSprite;
        this.foodLabel = foodLabel;
        this.foodSprite = foodSprite;
        this.oresLabel = oresLabel;
        this.oresSprite = oresSprite;
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
