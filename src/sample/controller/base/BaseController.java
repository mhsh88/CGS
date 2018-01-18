package sample.controller.base;

import javafx.scene.control.Alert;

public class BaseController {
    public void showAlert(String title, String info, String message,Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(info);
        alert.setContentText(message);
        alert.showAndWait();
    }

}