package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HomeController {
    @FXML
    public Label lblName;
    @FXML
    public Label lblUsername;
    @FXML
    public Label lblEmail;

    public void initialize() {
        lblName.setText(Main.currentUser.getName());
        lblEmail.setText(Main.currentUser.getEmail());
        lblUsername.setText(Main.currentUser.getUsername());
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "Login.fxml");
    }

    public void changePassword(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "ChangePassword.fxml");
    }

    public void changeSecurity(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "changeSecurity.fxml");
    }
}
