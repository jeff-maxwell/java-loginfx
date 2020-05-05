package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Common {
    public static boolean loadWindow(ActionEvent actionEvent, String window) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(Common.class.getResource(window)));
        stage.setScene(scene);
        stage.show();

        return true;
    }
}
