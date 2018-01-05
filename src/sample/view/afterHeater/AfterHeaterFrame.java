package sample.view.afterHeater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class AfterHeaterFrame extends Application implements BaseFrame {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("afterHeater.fxml"));
    Parent root1;
    Stage stage;

    public AfterHeaterFrame() {
        try{root1   = (Parent) fxmlLoader.load();
        stage = new Stage();

        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("خط لوله بعد از گرم کن");}
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        show();
    }


    public void show() throws IOException {
        stage.show();
    }

    public void close() throws IOException{
        stage.close();
    }
}
