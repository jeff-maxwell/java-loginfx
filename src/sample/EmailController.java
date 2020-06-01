package sample;

import javafx.event.ActionEvent;
import java.io.IOException;

public class EmailController {

    public void send(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "Login.fxml");
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "ForgotPassword.fxml");
    }
}
