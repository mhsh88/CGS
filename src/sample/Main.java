package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import sample.controller.stationController.StationController;
import sample.controller.stationProperty.StationPropertyFrame;

import java.io.IOException;

public class Main extends Application {
    StationController staionConroller = new StationController();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        staionConroller.launchLogingController(primaryStage);
//        Parent root = FXMLLoader.load(getClass().getResource("view/station/sample.fxml"));
//        primaryStage.setTitle("نرم افزار محاسبه مصرف گاز ایستگاه تقلیل فشار گاز");
//        primaryStage.setScene(new Scene(root, 1000, 500));
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
