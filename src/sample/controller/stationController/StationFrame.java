package sample.controller.stationController;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.awt.*;
import java.io.IOException;

public class StationFrame extends Application implements BaseFrame {
//    private static final StationFrame instance = new StationFrame();

    //private constructor to avoid client applications to use constructor

//    public static StationFrame getInstance(){
//        return instance;
//    }

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/station/sample.fxml"));
    Parent root1;
    Stage stage;
    @FXML
    TextField nitrogenTextField = new TextField();

    public StationFrame() {
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        run(primaryStage);
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

    public void run(Stage stage) throws IOException {
        root1 = (Parent) fxmlLoader.load();
//        stage = new Stage();
        this.stage = stage;
        this.stage.setScene(new Scene(root1, 1000, 700));
        this.stage.setTitle("نرم افزار محاسبه مصرف گاز ایستگاه تقلیل فشار گاز");

    }

    public Stage getStage(){
        return stage;
    }

//    @Override
//    public void stop(){
//
//        System.out.println("Stage is closing");
//        // Save file
//    }

}