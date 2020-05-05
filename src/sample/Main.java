package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<User> users = new ArrayList<>();
    public static User currentUser = new User();
    public Encryption enc = new Encryption();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.show();

        Main.users = JSONFile.Load();
        for (int x=0; x < Main.users.size(); x++) {
            String name = Main.users.get(x).getName();
            String decName = enc.decrypt(name, "ABC123");
            Main.users.get(x).setName(decName);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
