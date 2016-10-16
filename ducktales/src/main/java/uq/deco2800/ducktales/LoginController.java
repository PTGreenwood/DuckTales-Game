package uq.deco2800.ducktales;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uq.deco2800.ducktales.DuckTalesController;  


/**
 *
 * @author wentingwang
 */
public class LoginController  {
    
    @FXML
    private Text actiontarget;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordField;
    
    static Stage primaryStage;
	public static void close()
	{
		if (primaryStage != null)
			primaryStage.close();
	}
    
    @FXML protected void handleSignUpButtonAction(ActionEvent event) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("/ui/main/SignUp.fxml"));
        
		Scene scene = new Scene(root1,300,275);
		primaryStage= new Stage();
        //primaryStage.initStyle(Stage.UNDECORATED);
		primaryStage.setTitle("FXML Welcome");  
		primaryStage.setScene(scene);
		primaryStage.showAndWait();

    }
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
    	//event.fireEvent(this,new WindowEvent(this,WindowEvent.WINDOW_CLOSED));
    //if(username.getText().equals("123") && passwordField.getText().equals("456"))
    		DuckTalesController.close();
    	//else
    		actiontarget.setText("error");
    }
   
    
}

