package sample.controller.stationController;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.view.afterHeater.AfterHeaterFrame;
import sample.view.beforHeater.BeforeHeaterFrame;
import sample.view.calculate.CalculateButtonFrame;
import sample.view.heater.HeaterFrame;
import sample.view.run.RunFrame;
import sample.view.showResult.ShowResultsFrame;
import sample.view.stationProperty.StationPropertyFrame;

import java.io.IOException;

public class StationController {
    Stage stage;
    Scene scene;
    private static final StationController instance = new StationController();
    BeforeHeaterFrame beforeHeaterFrame = new BeforeHeaterFrame();
    HeaterFrame heaterFrame = new HeaterFrame();
    AfterHeaterFrame afterHeaterFrame = new AfterHeaterFrame();
    RunFrame runFrame = new RunFrame();
    StationPropertyFrame stationPropertyFrame = StationPropertyFrame.getInstance();
    ShowResultsFrame showResultsFrame = new ShowResultsFrame();
    CalculateButtonFrame calculateButtonFrame = new CalculateButtonFrame();
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


    private StationController(){
//        btn.getStyleClass().add("icon-button");
//        btn.setPickOnBounds(true);
    }

    public static StationController getInstance(){
        return instance;
    }




    public void sayHelloWorld(ActionEvent actionEvent) {
    }

    public void changIcon(ActionEvent actionEvent) {

        btn.getStyleClass().add("icon-button");
        btn.setPickOnBounds(true);
//        pipe1.getStyleClass().add("pipe");
//        pipe2.getStyleClass().add("pipe");
//        pipe3.getStyleClass().add("pipe");
//        leftFourWay.getStyleClass().add("fourWay");
//        rightFourWay.getStyleClass().add("fourWay");
//        rightFourWay.setPickOnBounds(true);
//        leftFourWay.setPickOnBounds(true);
//        pipe1.setPickOnBounds(true);
//        pipe2.setPickOnBounds(true);
//        pipe3.setPickOnBounds(true);

    }
    public void launchLogingController(Stage stage) {
        this.stage = stage;
        stage.setTitle("User Login");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.hide();
        stage.show();
    }

    public void beforeHeaterWindows(ActionEvent actionEvent) throws IOException {
        beforeHeaterFrame.close();
        beforeHeaterFrame.show();
    }
    public void heaterWindows(ActionEvent actionEvent) throws  IOException{
        heaterFrame.close();
        heaterFrame.show();
    }

    public void afterWindows(ActionEvent actionEvent) throws IOException {
        afterHeaterFrame.close();
        afterHeaterFrame.show();
    }

    public void runWindows(ActionEvent actionEvent) throws IOException{
        runFrame.close();
        runFrame.show();
    }

    public void stationPropertyWindows(ActionEvent actionEvent) throws IOException {

        stationPropertyFrame.close();
        stationPropertyFrame.show();

    }

    public void showResultsWindows(ActionEvent actionEvent) throws IOException {
        showResultsFrame.close();
        showResultsFrame.show();
    }

    public void calculateButton(ActionEvent actionEvent) throws IOException {
        calculateButtonFrame.close();
        calculateButtonFrame.show();



    }
}


