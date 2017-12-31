package sample.view.heater;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HeaterFrame {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("heater.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();

    public HeaterFrame() throws IOException {
        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("اطلاعات گرم کن");
    }


    public void show() throws IOException {
            stage.show();
        }
}
