package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Common;

import java.io.IOException;

public class ForgotPasswordController {
    public void email(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "Email.fxml");
    }

    public void security(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "SecurityUser.fxml");
    }

    public void cancel(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "Login.fxml");
    }
}
