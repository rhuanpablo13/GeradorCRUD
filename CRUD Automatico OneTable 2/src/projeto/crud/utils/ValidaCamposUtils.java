package projeto.crud.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class ValidaCamposUtils {
	private static final String STILE_BORDER_VALIDATION = "-fx-border-color: #FF0000";
	private static final Tooltip toolTip = new Tooltip("Este campo é obrigatório!.");

	@SuppressWarnings("unchecked")
	public static boolean checkEmptyFields(Node... itemToCheck) {

		boolean flag = false;
		//used to determinate how many fields failed in validation
		List<Node> failedFields = new ArrayList<Node>();

		toolTip.setStyle("-fx-background-color: linear-gradient(#FF6B6B , #FFA6A6 );" + " -fx-font-weight: bold;");
		hackTooltipStartTiming(toolTip);

		for (Node n : arrayToList(itemToCheck)) {

			// Validate TextFields
			if (n instanceof TextField) {
				TextField textField = (TextField) n;
				textField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					removeToolTipAndBorderColor(textField, toolTip);

				});

				if (textField.getText() == null || textField.getText().trim().equals("")) {
					failedFields.add(n);
					addToolTipAndBorderColor(textField, toolTip);
					flag = true;
				} else {
					removeToolTipAndBorderColor(textField, toolTip);
					flag = false;
				}
			}


			// Validate PasswordField
			if (n instanceof PasswordField) {
				PasswordField passwordField = (PasswordField) n;
				passwordField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
								removeToolTipAndBorderColor(passwordField, toolTip);

				});

				if (passwordField.getText() == null || passwordField.getText().trim().equals("")) {
							failedFields.add(n);
							addToolTipAndBorderColor(passwordField, toolTip);
							flag = true;
				} else {
							removeToolTipAndBorderColor(passwordField, toolTip);
							flag = false;
						}
			}



			// Validate Combo Box
			else if (n instanceof ComboBox) {
				@SuppressWarnings("rawtypes")
				ComboBox comboBox = (ComboBox) n;
				comboBox.valueProperty().addListener((@SuppressWarnings("rawtypes") ObservableValue observable, Object oldValue, Object newValue) -> {
					removeToolTipAndBorderColor(comboBox, toolTip);
				});
				if (comboBox.getValue() == null) {
					failedFields.add(n);
					addToolTipAndBorderColor(comboBox, toolTip);
					flag = true;
				} else {
					removeToolTipAndBorderColor(comboBox, toolTip);
					flag = false;
				}
			}






			// Validate TextArea
			else if (n instanceof TextArea) {
				TextArea textArea = (TextArea) n;
				textArea.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					removeToolTipAndBorderColor(textArea, toolTip);
				});
				if (textArea.getText() == null || textArea.getText().trim().equals("")) {
					failedFields.add(n);
					addToolTipAndBorderColor(textArea, toolTip);
					flag = true;
				} else {
					removeToolTipAndBorderColor(textArea, toolTip);
					flag = false;
				}
			}
			//ADD YOUR VALIDATION HERE
			//TODO
	  } //end for
	  return flag;

	}


	/**
	 * *******ADD AND REMOVE STYLES********
	*/
	private static void addToolTipAndBorderColor(Node n, Tooltip t) {
		Tooltip.install(n, t);
		n.setStyle(STILE_BORDER_VALIDATION);
	}


	private static void removeToolTipAndBorderColor(Node n, Tooltip t) {
		Tooltip.uninstall(n, t);
		n.setStyle(null);
	}


	/**
	 * ***********ARRAY TO LIST UTILITY************
	*/
	private static List<Node> arrayToList(Node[] n) {
		List<Node> listItems = new ArrayList<>();
		for (Node n1 : n) {
			listItems.add(n1);
		}
		return listItems;
	}

	/**
	 * ***********FORCE TOOL TIP TO BE DISPLAYED FASTER************
	 */
	private static void hackTooltipStartTiming(Tooltip tooltip) {
		try {
			Field fieldBehavior = tooltip.getClass().getDeclaredField(
					"BEHAVIOR");
			fieldBehavior.setAccessible(true);
			Object objBehavior = fieldBehavior.get(tooltip);

			Field fieldTimer = objBehavior.getClass().getDeclaredField(
					"activationTimer");
			fieldTimer.setAccessible(true);
			Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

			objTimer.getKeyFrames().clear();
			objTimer.getKeyFrames().add(new KeyFrame(new Duration(5)));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e);
		}
	}
}
