package uq.deco2800.ducktales.features.inventory;

/**
 * Created by Benson on 30/8/16.]
 * A class for retrieving and updating the amount of different resources
 */

public class InventoryManager {

    
    public int woodAmount = 0;
    public int oresAmount = 0;
    public int foodAmount = 0;

    public InventoryManager(int wood, int ores, int food) {
        //* Initialize a inventory container */
        this.woodAmount = wood;
        this.oresAmount = ores;
        this.foodAmount = food;
    }


    
    /** Variable for the UI elements */
  //  private Label woodLabel;
   // private Label rockLabel;
   // private Label foodLabel;
   // private Label oresLabel;

    public InventoryManager() {

    }

	//public InventoryManager(Label woodLabel, Label foodLabel, Label oresLabel) {
		// Wire up the UI elements
	//	this.woodLabel = woodLabel;
	//	this.foodLabel = foodLabel;
	//	this.oresLabel = oresLabel;

	//}

    //** define methods to retrieve and update amount of wood */
    public int getWoodAmount(){
        return this.woodAmount;
    }

    public void updateWoodAmount(int amount) {
        //* To make sure the amount of resources won't be below 0 */
        if (amount + this.woodAmount < 0) {
            this.woodAmount = 0;

            // Update UI element
         //   this.woodLabel.setText("" + this.woodLabel);
        } else {
            this.woodAmount = this.woodAmount + amount;
            // Update UI element
        //    this.woodLabel.setText("" + this.woodLabel);
        }
    }




    //** define methods to retrieve and update amount of mines */
    public int getOresAmount(){
        return this.oresAmount;
    }

    public void updateOresAmount(int amount){
        //* To make sure the amount of resources won't be below 0 */
        if(amount + this.oresAmount < 0 ){
            this.oresAmount = 0;

            // Update UI element
          //  this.oresLabel.setText("" + this.oresAmount);
        }
        else {
            this.oresAmount = this.oresAmount + amount;

            // Update UI element
          //  this.oresLabel.setText("" + this.oresAmount);
        }
    }

    //** define methods to retrieve and update amount of food */
    public int getFoodAmount(){
        return this.foodAmount;
    }

    public void updateFoodAmount(int amount){
        //* To make sure the amount of resources won't be below 0 */
        if(amount + this.foodAmount < 0 ){
            this.foodAmount = 0;

            // Update UI element
         //   this.foodLabel.setText("" + this.foodAmount);
        }
        else {
            this.foodAmount = this.foodAmount + amount;

            // Update UI element
          //  this.foodLabel.setText("" + this.foodAmount);
        }
    }


}
