package sample.view.stationProperty;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.awt.*;
import java.io.IOException;

public class StationPropertyFrame extends Application implements BaseFrame {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stationProperty.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    @FXML
    TextField nitrogenTextField = new TextField();

    public StationPropertyFrame() throws IOException {
        stage.setScene(new Scene(root1, 500, 1000));
        stage.setTitle("اطلاعات ایستگاه گاز");
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        show();
    }

    @Override
    public void show() throws IOException {

        stage.close();
        stage.show();

    }

    @Override
    public void close() throws IOException {
        stage.close();

    }

}
