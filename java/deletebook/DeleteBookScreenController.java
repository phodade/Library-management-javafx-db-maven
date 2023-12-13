package deletebook;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library_management.LibraryManagementScreen;
import user_management.UserManagementScreen;

public class DeleteBookScreenController {
	
	 @FXML
	 private TextField delete_book_name;
	
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
	 private Button search_button;
	 
	 @FXML
	 private Button delete_button;
	 
	 public void SearchButton(ActionEvent event)throws SQLException {
		   
		   boolean searchstatus = searchBook(delete_book_name.getText());
		   
		   if(searchstatus) {
			   searchBook(null);
		   }
	   }

	    public boolean searchBook(String productname) throws SQLException {
		
		String query = "select * from Librray where bookName='" + delete_book_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				book_name.setText(rs.getString("bookName"));
				book_id.setText(rs.getString("bookId"));
				book_author_name.setText(rs.getString("bookAuthorName"));
				book_category.setText(rs.getString("bookCategory"));
				book_price.setText(rs.getString("bookPrice"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
}
	    public void CloseButton(ActionEvent event) {
	    	try {
				new LibraryManagementScreen().show();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }


		public void DeleteButton(ActionEvent event) {
	    	String query = "delete from Library where bookName='" + delete_book_name.getText() + "' ";
			DBUtils.executeQuery(query);
	    }

}
