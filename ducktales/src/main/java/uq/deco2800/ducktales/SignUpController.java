package uq.deco2800.ducktales;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


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
    
    @FXML protected void handleSignUpButtonAction() throws Exception {
    	LoginController.close();
    }
   
    
}

