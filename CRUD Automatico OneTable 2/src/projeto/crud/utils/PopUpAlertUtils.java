package projeto.crud.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopUpAlertUtils {

	public static void getWarning(String title, String header, String content){
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
	}


}
