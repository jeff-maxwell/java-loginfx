package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ResetPasswordController {

    @FXML
    public TextField txtnewPassword;
    @FXML
    public TextField txtConfirm;

    public void submit(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException {
        Hash hash = new Hash();

            if (txtConfirm.getText().equals(txtnewPassword.getText())) {
                byte[] newsalt = hash.getSalt();
                String password = hash.getHash(txtnewPassword.getText(), newsalt);

                Main.currentUser.setPassword(password);
                String saltString = Base64.getEncoder().encodeToString(newsalt);
                Main.currentUser.setSalt(saltString);
                Common.loadWindow(actionEvent, "login.fxml");
            } else {
                // TODO: New password and Confirm do not match"
            }
        }
    }
