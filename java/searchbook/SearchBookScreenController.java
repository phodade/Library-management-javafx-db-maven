package searchbook;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import editbook.EditBookScreen;
import edituser.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library_management.LibraryManagementScreen;
import user_management.UserManagementScreen;

public class SearchBookScreenController {

	 @FXML
	   private TextField search_book_name;
	   
	   @FXML
	   private TextField book_name;
	   
	   @FXML
	   private TextField book_id;
	   
	   @FXML
	   private TextField book_category;
	   
	   @FXML
	   private TextField book_quantity;
	   
	   @FXML
	   private TextField book_price;
	   
	   @FXML
	   private Button search_button;
	   
	   @FXML
	   private Button close_button;
	   
	   @FXML
	   private Button delete_button;
	   
	   @FXML
	   private Button edit_button;
	   
	   public void SearchButton(ActionEvent event)throws SQLException {
		   
		   boolean searchstatus = searchBook(search_book_name.getText());
		   
		   if(searchstatus) {
			   searchBook(null);
		   }
	   }

	    public boolean searchBook(String productName) throws SQLException {
		
		String query = "select * from Library where bookName='" + search_book_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				book_name.setText(rs.getString("bookName"));
				book_id.setText(rs.getString("bookId"));
				book_category.setText(rs.getString("bookAuthorName"));
				book_quantity.setText(rs.getString("bookCategory"));
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
	    public void EditButton(ActionEvent event) {
	    	try {
	    		new EditBookScreen().show();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    public void DeleteButton(ActionEvent event) {
	    	String query = "delete from Library where bookName='" + search_book_name.getText() + "' ";
			DBUtils.executeQuery(query);
	    }
}
