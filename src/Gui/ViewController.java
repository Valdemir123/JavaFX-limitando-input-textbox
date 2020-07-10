package Gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import Gui.Util.Alerts;
import Gui.Util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable {

	@FXML
	private TextField txtNumber1;

	@FXML
	private TextField txtNumber2;

	@FXML
	private Label lblResult;

	@FXML
	private Button btSum;

	@FXML
	public void onBtSumAction() {
		try {

			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());
			double sum = number1 + number2;

			lblResult.setText(String.format("%.2f", sum));
		} catch (NumberFormatException e) {
			Alerts.ShowAlert("ERROR", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);

		Constraints.setTextFieldMaxLenght(txtNumber1, 4);
		Constraints.setTextFieldMaxLenght(txtNumber2, 4);
	}
}
