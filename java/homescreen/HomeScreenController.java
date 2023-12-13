package homescreen;

import back.BackScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import library_management.LibraryManagementScreen;
import user_management.UserManagementScreen;

public class HomeScreenController {
	
	@FXML
	private Button userManagement;
	
	@FXML
	private Button libraryManagement;
	
	@FXML
	private Button back;
	
	public void showUserManagementScreen(ActionEvent event) {
		new UserManagementScreen().show();
	}
	public void showLibraryManagementScreen(ActionEvent event) {
		new LibraryManagementScreen().show();
		
	}
	public void backToHomeScreen(ActionEvent event) {
		try {
			new BackScreen().show();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
