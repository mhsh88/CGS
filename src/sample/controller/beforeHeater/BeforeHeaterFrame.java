package sample.controller.beforeHeater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class BeforeHeaterFrame extends Application implements BaseFrame {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/beforHeater/beforeHeater.fxml"));
    Parent root1;
    Stage stage;

    public BeforeHeaterFrame() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root1 = (Parent) fxmlLoader.load();
        stage = primaryStage;
        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("خط لوله قبل از گرم کن");
        BeforeHeaterController controller = (BeforeHeaterController) fxmlLoader.getController();
        controller.setStage(stage);
        show();
    }


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

    public void close() throws IOException {
        stage.close();
    }
}
