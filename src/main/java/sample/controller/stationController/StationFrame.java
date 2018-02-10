package sample.controller.stationController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class StationFrame extends Application implements BaseFrame {
//    private static final StationFrame instance = new StationFrame();

    //private constructor to avoid client applications to use constructor

//    public static StationFrame getInstance(){
//        return instance;
//    }
//    String locationString = System.getProperty("user.dir") + "/src/main/java/sample/view/station/sample.fxml";
//    URL locationURL = new URL(locationString);
//    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./sample.fxml"));
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./sample.fxml"));
        InputStream ur = StationFrame.class.getResourceAsStream(".");
        URL url = StationFrame.class.getResource(".");
        URL url2 = getClass().getResource("../../view/");
        URL url3 = getClass().getClassLoader().getResource(".");

//        URL url3 = new URL();
//    FXMLLoader fxmlLoader = new FXMLLoader(StationFrame.class.getResource("sample.fxml"));
    Parent root1;
    Stage stage;
    @FXML
    TextField nitrogenTextField = new TextField();

    public StationFrame() throws MalformedURLException {
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
//        Image icon = new Image(getClass().getResourceAsStream("/sample/view/base/logo2.png"));
//        primaryStage.getIcons().add(icon);

//        getFrame().setIconImage(
//                new ImageIcon(getClass().getClassLoader().getResource("PATH/TO/YourImage.png"))
//        );
        primaryStage.setOnCloseRequest(e -> Platform.exit());
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
//        Image icon = new Image(getClass().getResourceAsStream("/sample/view/base/logo.png"));
//        this.stage.getIcons().add(icon);


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
