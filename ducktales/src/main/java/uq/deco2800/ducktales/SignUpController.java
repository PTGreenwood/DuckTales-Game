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
public class SignUpController  {
    
    @FXML
    private Text actiontarget;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordField2;
    
    @FXML protected void handleSignUpButtonAction(ActionEvent event) throws Exception {
    	LoginController.close();
    }
   
    
}

