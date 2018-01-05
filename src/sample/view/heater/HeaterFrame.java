package sample.view.heater;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class HeaterFrame implements BaseFrame {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("heater.fxml"));
    Parent root1;
    Stage stage;

    public HeaterFrame() {
        try{
            root1 = (Parent) fxmlLoader.load();
              stage = new Stage();
        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("اطلاعات گرم کن");}
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void show() throws IOException {
            stage.show();
        }

    @Override
    public void close() throws IOException {
        stage.close();
    }
}
