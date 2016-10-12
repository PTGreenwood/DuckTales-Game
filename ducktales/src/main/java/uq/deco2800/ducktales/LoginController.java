package uq.deco2800.ducktales;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
    	//event.fireEvent(this,new WindowEvent(this,WindowEvent.WINDOW_CLOSED));
    //if(username.getText().equals("123") && passwordField.getText().equals("456"))
    		DuckTalesController.close();
    	//else
    		actiontarget.setText("error");
    }
    
   
    
}

