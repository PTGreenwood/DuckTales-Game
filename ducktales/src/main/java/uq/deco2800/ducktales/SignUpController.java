package uq.deco2800.ducktales;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

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
    boolean IsExitUser(String s)
    {
    	
    	return false;
    }
    
    @FXML protected void handleSignUpButtonAction(ActionEvent event) throws Exception {
    	boolean bexit = false;
    	if(passwordField.getText().equals(passwordField2.getText()))
    	{
    		String user = username.getText()+":"+passwordField.getText();
    		File file=new File("user.txt");
            if(!file.exists()||file.isDirectory())
            {
            	;
            }
            else
            {
            	BufferedReader br=new BufferedReader(new FileReader(file));
                String temp=null;
                StringBuffer sb=new StringBuffer();
                while((temp=br.readLine()) != null)
                {
                	if(temp.toString().equals(user))
                	{
                		bexit = true;
                		actiontarget.setText("signUP error:user exists");
                		break;
                	}
                }
            }
            if(username.getText().toString().length() == 6 && passwordField.getText().toString().length() == 6)
            {
            	if(!bexit)
        		{
        			try{
                        FileOutputStream out=new FileOutputStream("user.txt");
                        PrintStream p=new PrintStream(out);
                        p.println(username.getText()+":"+passwordField.getText());
                        out.close();
                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
            		LoginController.close();
        		}
            }
            else
            {
            	actiontarget.setText("username/password \nlength must be 6 number");
            }
    	}
    	else
    	{
    		actiontarget.setText("password not consistent.");
    	}
    }
   
    
}

