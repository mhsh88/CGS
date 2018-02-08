package main.java.sample.controller.beforeHeater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.java.sample.view.base.BaseFrame;

import java.io.IOException;

public class BeforeHeaterFrame extends Application implements BaseFrame {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/sample/view/beforHeater/beforeHeater.fxml"));
    Parent root1;
    Stage stage;

    public BeforeHeaterFrame() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("/main/java/sample/view/base/logo2.png"));
        primaryStage.getIcons().add(icon);
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
