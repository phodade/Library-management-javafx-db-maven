package adduser;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class AddUserScreenController {
	
	@FXML
	private TextField user_name;
	
	@FXML
	private TextField login_name;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField confirm_password;
	
	@FXML
	private TextField user_role;
	
	@FXML
	private Button close_button;
	
	@FXML
	private Button save_Button;
	
	public void SaveButton(ActionEvent event) {

		String query = "INSERT INTO User(UserName, LoginName, Password, confirmPassword, userRole) VALUES ('"
				+ user_name.getText() + "', '" + login_name.getText() + "', '" + password.getText()+ "','"
				+ confirm_password.getText() + "','" + user_role.getText() + "')";

		DBUtils.executeQuery(query);
	}
	public void CloseButton(ActionEvent event) {
		try {
			new UserManagementScreen().show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
