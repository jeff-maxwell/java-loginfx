package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ChangeSecurityController {

    @FXML
    TextField txtQuestion;

    @FXML
    TextField txtAnswer;

    @FXML
    PasswordField txtPassword;

    Encryption enc = new Encryption();

    public void change(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Hash hash = new Hash();
        byte[] saltByte = Base64.getDecoder().decode(Main.currentUser.getSalt());
        String hashedPassword = hash.getHash(txtPassword.getText(), saltByte);

        if(hashedPassword.equals(Main.currentUser.getPassword())){
            Main.currentUser.setSecurityQuestion(txtQuestion.getText());
            Main.currentUser.setAnswer(txtAnswer.getText());

            String encSec = enc.encrypt(Main.currentUser.getSecurityQuestion(), "ABC123");
            String encAns = enc.encrypt(Main.currentUser.getAnswer(), "ABC123");

            Main.currentUser.setSecurityQuestion(encSec);
            Main.currentUser.setAnswer(encAns);

        }else{
            // TODO: Show message "Password Incorrect"
        }

        Common.loadWindow(actionEvent, "Home.fxml");
    }

    public void cancel(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "Home.fxml");
    }
}
