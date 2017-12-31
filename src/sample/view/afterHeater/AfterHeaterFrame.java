package sample.view.afterHeater;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class AfterHeaterFrame implements BaseFrame {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("afterHeater.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();

    public AfterHeaterFrame() throws IOException {
        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("خط لوله بعد از گرم کن");
    }


    public void show() throws IOException {
        stage.show();
    }

    public void close() throws IOException{
        stage.close();
    }
}
