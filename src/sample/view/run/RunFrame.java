package sample.view.run;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.base.BaseFrame;

import java.io.IOException;

public class RunFrame  implements BaseFrame{

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("run.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();

    public RunFrame() throws IOException {
        stage.setScene(new Scene(root1, 500, 400));
        stage.setTitle("اطلاعات ران ها");
    }

    @Override
    public void show() throws IOException {
        stage.show();
    }
    @Override
    public void close() {
        stage.close();
    }
}
