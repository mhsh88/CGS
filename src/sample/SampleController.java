package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import sample.view.beforHeater.BeforeHeaterFrame;
import sample.view.heater.HeaterFrame;

import java.io.IOException;

public class SampleController {
    BeforeHeaterFrame beforeHeaterFrame = new BeforeHeaterFrame();
    HeaterFrame heaterFrame = new HeaterFrame();
    public Button btn = new Button();
    public Button btn1 = new Button();
    public Button heater = new Button();
    public Button beforeHeaterPipeLine = new Button();
    public Button pipe1 = new Button();
    public Button pipe2 = new Button();
    public Button pipe3 = new Button();
    public Button leftFourWay = new Button();
    public Button rightFourWay = new Button();


    public SampleController() throws IOException {
        btn.getStyleClass().add("icon-button");
        btn.setPickOnBounds(true);
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

    public void beforeHeaterWindows(ActionEvent actionEvent) throws IOException {

        beforeHeaterFrame.show();
    }
    public void heaterWindows(ActionEvent actionEvent) throws  IOException{
        heaterFrame.show();
    }
}
