package library_management;

import addbook.AddBookScreen;
import adduser.AddUserScreen;
import back_to_home.BackToHomeScreen;
import deletebook.DeleteBookScreen;
import deleteuser.DeleteUserScreen;
import editbook.EditBookScreen;
import edituser.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import searchbook.SearchBookScreen;
import searchuser.SearchUserScreen;

public class LibraryManagementScreenController {
	
	@FXML
	private Button add_book;
	
	@FXML
	private Button edit_book;
	
	@FXML
	private Button search_book;
	
	@FXML
	private Button delete_book;
	
	@FXML
	private Button back_to_home;
	
	public void AddBook(ActionEvent event) {
		
	    new AddBookScreen().show();
	}
	public void EditBook(ActionEvent event) {
		
		new EditBookScreen().show();
		
	}
	public void SearchBook(ActionEvent event) {
		
		new SearchBookScreen().show();
		
	}
	public void DeleteBook(ActionEvent event) {
		
		new DeleteBookScreen().show();
		
	}
	public void BackToHome(ActionEvent event) {
		
		try {
			new BackToHomeScreen().show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}