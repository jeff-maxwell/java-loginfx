package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginController {

    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;

    public void login(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException {
        for (int x = 0; x < Main.users.size(); x++) {
            if (Main.users.get(x).getUsername().equals(txtUsername.getText())) {
                Main.currentUser = Main.users.get(x);
                continue;
            } else {
                // TODO: Show message "Username or Password Incorrect".
            }
        }

        if (Main.currentUser.getUsername() != null) {
            Hash hash = new Hash();
            byte[] saltByte = Base64.getDecoder().decode(Main.currentUser.getSalt());

            String hashedPassword = hash.getHash(txtPassword.getText(), saltByte);
            if (Main.currentUser.getPassword().equals(hashedPassword)) {
                Common.loadWindow(actionEvent, "Home.fxml");
            } else {
                // TODO: Show message "Username or Password Incorrect"
            }
        }


    }

    public void signup(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "Signup.fxml");
    }

    public void forgot(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "ForgotPassword.fxml");
    }

}
