package sample.view.stationProperty;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.stationController.StationController;
import sample.view.base.BaseFrame;

import java.awt.*;
import java.io.IOException;

public class StationPropertyFrame extends Application implements BaseFrame {
    private static final StationPropertyFrame instance = new StationPropertyFrame();

    //private constructor to avoid client applications to use constructor

    public static StationPropertyFrame getInstance(){
        return instance;
    }

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stationProperty.fxml"));
    StationController controller = fxmlLoader.<StationController>getController();
    Parent root1;
    Stage stage;
    @FXML
    TextField nitrogenTextField = new TextField();

    private StationPropertyFrame() {
        try {
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setScene(new Scene(root1, 1000, 700));
            stage.setTitle("اطلاعات ایستگاه گاز");
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
