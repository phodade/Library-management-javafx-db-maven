package editbook;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library_management.LibraryManagementScreen;
import user_management.UserManagementScreen;

public class EditBookScreenController {
	
	@FXML
	private TextField edit_book_name;
	
	@FXML
	private TextField new_book_name;
	
	@FXML
	private TextField new_book_id;
	
	@FXML
	private TextField new_book_author_name;
	
	@FXML
	private TextField new_book_category;
	
	@FXML
	private TextField new_book_price;
	
	@FXML
	private Button edit_button;
	
	@FXML
	private Button close_button;
	
	@FXML
	private Button save_Button;
	
	public void EditButton(ActionEvent event) throws SQLException {
		boolean editstatus = editBook(edit_book_name.getText());
		
		if(editstatus) {
			editBook(null);
		}
	}
	
	private boolean editBook(String book_name) throws SQLException{
		String query = "select * from Libaryr where bookName='" + edit_book_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				new_book_name.setText(rs.getString("bookName"));
				new_book_id.setText(rs.getString("bookId"));
				new_book_author_name.setText(rs.getString("bookAuthorName"));
				new_book_category.setText(rs.getString("bookCategory"));
				new_book_price.setText(rs.getString("bookPrice"));
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}

	public void SaveButton(ActionEvent event) {
		
		String updateQuery = "update Book set "
				+ "bookName='"+new_book_name.getText()+"', bookId = '"+new_book_id.getText()+"', "
						+ "bookAuthorName='"+new_book_author_name.getText()+"', bookCategory='"+new_book_category.getText()+"', "
								+ "bookPrice='"+new_book_price.getText()+"' where bookName='"+edit_book_name.getText()+"'";
		
		DBUtils.executeQuery(updateQuery);
	}
	
	public void CloseButton(ActionEvent event) {
		try {
			new LibraryManagementScreen().show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}
