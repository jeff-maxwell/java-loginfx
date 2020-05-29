package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import sample.Common;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ChangePasswordController {

    @FXML
    public PasswordField txtCurrentPassword;
    @FXML
    public PasswordField txtNewPassword;
    @FXML
    public PasswordField txtConfirmNewPassword;

    public void change(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException {
        Hash hash = new Hash();
        byte[] saltByte = Base64.getDecoder().decode(Main.currentUser.getSalt());
        String hashedPassword = hash.getHash(txtCurrentPassword.getText(), saltByte);

        if (Main.currentUser.getPassword().equals(hashedPassword)) {
            if (txtConfirmNewPassword.getText().equals(txtNewPassword.getText())) {
                byte[] newsalt = hash.getSalt();
                String password = hash.getHash(txtNewPassword.getText(), newsalt);

                Main.currentUser.setPassword(password);
                String saltString = Base64.getEncoder().encodeToString(newsalt);
                Main.currentUser.setSalt(saltString);
                Common.loadWindow(actionEvent, "Home.fxml");
            } else {
                // TODO: Show message "Password Does Not Match"
            }
        }
    }

    public void cancel(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "Home.fxml");
    }
}
