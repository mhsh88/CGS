package sample.controller.beforeHeater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class BeforeHeaterFrame extends Application implements BaseFrame {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/beforHeater/beforeHeater.fxml"));
    Parent root1;
    Stage stage;

    public BeforeHeaterFrame() {
        try {
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setScene(new Scene(root1, 500, 400));
            stage.setTitle("خط لوله قبل از گرم کن");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        show();
    }


    public void show() throws IOException {
        stage.close();
        stage.show();
    }

    public void close() throws IOException {
        stage.close();
    }
}
