package user_management;

import adduser.AddUserScreen;
import back_to_home.BackToHomeScreen;
import deleteuser.DeleteUserScreen;
import edituser.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import searchuser.SearchUserScreen;

public class UserManagementScreenController {
	
	@FXML
	private Button addUser;
	
	@FXML
	private Button editUser;
	
	@FXML
	private Button searchUser;
	
	@FXML
	private Button deleteUser;
	
	@FXML
	private Button backToHome;
	
	public void showAddUserScreen(ActionEvent event) {
		
	    new AddUserScreen().show();
		
	}
	public void showEditUserScreen(ActionEvent event) throws Exception {
		
		new EditUserScreen().show();
		
	}
	public void showSearchUserScreen(ActionEvent event) {
		
		new SearchUserScreen().show();
		
	}
	public void showDeleteUserScreen(ActionEvent event) {
		
		new DeleteUserScreen().show();
	}
	public void showBackToHomeScreen(ActionEvent event) {
		
		try {
			new BackToHomeScreen().show();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
