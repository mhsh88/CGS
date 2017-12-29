package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SampleController {
    public Button btn = new Button();
    public Button btn1 = new Button();
    public Button heater = new Button();
    public Button beforeHeaterPipeLine = new Button();
    public Button pipe1 = new Button();
    public Button pipe2 = new Button();
    public Button pipe3 = new Button();
    public Button leftFourWay = new Button();
    public Button rightFourWay = new Button();


    public SampleController(){
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
}
