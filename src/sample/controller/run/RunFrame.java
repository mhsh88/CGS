package sample.controller.run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class RunFrame extends Application implements BaseFrame {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/run/run.fxml"));
    Parent root1;
    Stage stage;

    public RunFrame() {
        try {
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setScene(new Scene(root1, 500, 400));
            stage.setTitle("اطلاعات ران ها");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        show();
    }

    @Override
    public void show() throws IOException {
        stage.close();
        stage.show();
    }

    @Override
    public void close() {
        stage.close();
    }
}
