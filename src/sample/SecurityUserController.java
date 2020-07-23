package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SecurityUserController {

    @FXML
    public TextField txtUsername;

    public void submit(ActionEvent actionEvent) throws IOException {
        for (int x = 0; x < Main.users.size(); x++) {
            if (txtUsername.getText().equals(Main.users.get(x).getUsername())) {
                Main.currentUser = Main.users.get(x);
                Common.loadWindow(actionEvent, "Security.fxml");
            } else {
                //TODO: Username Not found
            }
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "ForgotPassword.fxml");
    }
}
