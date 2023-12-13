package login;


import java.sql.ResultSet;

import db_operations.DBUtils;
import homescreen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginScreenController {

	@FXML
	private TextField loginName;

	@FXML
	private TextField password;

	@FXML
	private Button loginButton;

	public void login(ActionEvent event) throws Exception {
		boolean loginStatus = LoginScreenController.validateUserAndPassword(loginName.getText(), password.getText());
		if (loginStatus) {
			new HomeScreen().show();
		} else {
			System.out.println("Login Failed!!!");
		}

	}

	public static boolean validateUserAndPassword(String loginName, String password) {
		String query = "SELECT * FROM user WHERE loginName='" + loginName + "' AND password = '" + password + "'";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
