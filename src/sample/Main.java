package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.controller.stationController.StationController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StationController staionConroller = StationController.getInstance();
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
