package addbook;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library_management.LibraryManagementScreen;
import user_management.UserManagementScreen;

public class AddBookScreenController {
	
	@FXML
	private TextField book_name;
	
	@FXML
	private TextField book_id;
	
	@FXML
	private TextField book_author_name;
	
	@FXML
	private TextField book_category;
	
	@FXML
	private TextField book_price;
	
	@FXML
	private Button close_button;
	
	@FXML
	private Button save_Button;
	
	public void SaveButton(ActionEvent event) {

		String query = "INSERT INTO Book(bookName, bookId, authorName,bookCategory, bookPrice) VALUES ('"
				+ book_name.getText() + "', '" + book_id.getText() + "', '" + book_author_name.getText()+ "','"
				+  book_category.getText() + "','" + book_price.getText() + "')";

		DBUtils.executeQuery(query);
	}
	public void CloseButton(ActionEvent event) {
		try {
			new LibraryManagementScreen().show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
