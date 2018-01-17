package sample.controller.stationController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.controller.calculate.CalculateController;
import sample.controller.stationProperty.StationPropertyController;
import sample.controller.afterHeater.AfterHeaterFrame;
import sample.controller.beforeHeater.BeforeHeaterFrame;
import sample.controller.heaterController.HeaterFrame;
import sample.controller.run.RunFrame;
import sample.view.showResult.ShowResultsFrame;
import sample.controller.stationProperty.StationPropertyFrame;

import java.io.IOException;

public class StationController {
    Stage stage;
    Scene scene;
    FXMLLoader fxmlLoader;
    Parent root1;
//    private static final StationController instance = new StationController();
    StationPropertyController stationPropertyController = new StationPropertyController();
    BeforeHeaterFrame beforeHeaterFrame = new BeforeHeaterFrame();
    HeaterFrame heaterFrame = new HeaterFrame();
    AfterHeaterFrame afterHeaterFrame = new AfterHeaterFrame();
    RunFrame runFrame = new RunFrame();
    StationPropertyFrame stationPropertyFrame = new StationPropertyFrame();
    ShowResultsFrame showResultsFrame = new ShowResultsFrame();
    CalculateController calculateController = new CalculateController();
    public Button btn = new Button();
    public Button btn1 = new Button();
    public Button heater = new Button();
    public Button beforeHeaterPipeLine = new Button();
    public Button pipe1 = new Button();
    public Button pipe2 = new Button();
    public Button pipe3 = new Button();
    public Button leftFourWay = new Button();
    public Button rightFourWay = new Button();

    public StationPropertyFrame getStationPropertyFrame() {
        return stationPropertyFrame;
    }


    public StationController(){
//        btn.getStyleClass().add("icon-button");
//        btn.setPickOnBounds(true);
    }
//
//    public static StationController getInstance(){
//        return instance;
//    }




    public void sayHelloWorld(ActionEvent actionEvent) {
    }

    public void changIcon(ActionEvent actionEvent) {

        btn.getStyleClass().add("icon-button");
        btn.setPickOnBounds(true);
    }

    public void launchLogingController(Stage stage) throws IOException {
        this.stage = stage;
        fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/station/sample.fxml"));
        root1 = (Parent) fxmlLoader.load();
//        stage = new Stage();
        stage.setScene(new Scene(root1, 1000, 700));
        stage.setTitle("نرم افزار محاسبه مصرف گاز ایستگاه تقلیل فشار گاز");
//        stage.setTitle("User Login");
//        stage.setScene(scene);
//        stage.setResizable(true);
//        stage.hide();
        stage.show();
    }

    public void beforeHeaterWindows(ActionEvent actionEvent) throws IOException {
//        beforeHeaterFrame.close();
        beforeHeaterFrame.show();
    }
    public void heaterWindows(ActionEvent actionEvent) throws  IOException{
//        heaterFrame.close();
        heaterFrame.show();
    }

    public void afterWindows(ActionEvent actionEvent) throws IOException {
//        afterHeaterFrame.close();
        afterHeaterFrame.show();
    }

    public void runWindows(ActionEvent actionEvent) throws IOException{
//        runFrame.close();
        runFrame.show();
    }

    public void stationPropertyWindows(ActionEvent actionEvent) throws IOException {
//        stationPropertyController.show();

//        stationPropertyFrame.close();
        stationPropertyFrame.show();

    }

    public void showResultsWindows(ActionEvent actionEvent) throws IOException {
//        showResultsFrame.close();
        showResultsFrame.show();
    }

    public void calculateButton(ActionEvent actionEvent) throws IOException {
        calculateController.calculate();
        showResultsFrame.show();
//        calculateButtonFrame.close();



    }


}


