package sample.view.beforHeater;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BeforeHeaterFrame {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("beforeHeater.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();

    public BeforeHeaterFrame() throws IOException {
        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("خط لوله قبل از گرم کن");
    }


    public void show() throws IOException {
            stage.show();
        }
}
