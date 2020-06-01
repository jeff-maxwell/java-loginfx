package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SecurityController {

    Encryption enc = new Encryption();
    String answer;

    @FXML
    public TextField txtAnswer;
    @FXML
    public Label lblQuestion;

    public void initialize() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String encSec = Main.currentUser.getSecurityQuestion();
        String Question = enc.decrypt(encSec, "ABC123");
        String encAns = Main.currentUser.getAnswer();
        answer = enc.decrypt(encAns, "ABC123");
        lblQuestion.setText(Question);
    }

    public void submit(ActionEvent actionEvent) throws IOException{
        if (txtAnswer.getText().equals(answer)) {
            Common.loadWindow(actionEvent, "resetPassword.fxml");
        } else {
            //TODO: Answer is Incorrect
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(actionEvent, "ForgotPassword.fxml");
    }
}
