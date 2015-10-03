package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController{

	@FXML
	private Button btnAsk;
	
	@FXML
	private Label txtName;
	
	public void changeText(ActionEvent event){
		txtName.setText("Renan!");
	}

}
