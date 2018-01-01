package sample.view.stationProperty;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class StationPropertyFrame implements BaseFrame{

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stationProperty.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();

    public StationPropertyFrame() throws IOException {
        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("اطلاعات ایستگاه گاز");
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
}
