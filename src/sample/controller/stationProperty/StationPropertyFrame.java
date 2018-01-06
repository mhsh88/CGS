package sample.controller.stationProperty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class StationPropertyFrame extends Application implements BaseFrame {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/stationProperty/stationProperty.fxml"));
    Parent root1;
    Stage stage;

    public StationPropertyFrame() {
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        root1 = (Parent) fxmlLoader.load();
        stage = primaryStage;
        stage.setScene(new Scene(root1, 1000, 700));
        stage.setTitle("اطلاعات ایستگاه گاز");
        show();
    }

    @Override
    public void show() throws IOException {
        if(root1 == null & stage == null){
            try {
                start(new Stage());
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        stage.close();
        stage.show();

    }

    @Override
    public void close() throws IOException {
        stage.close();

    }

}
