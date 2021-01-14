package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    @FXML private TextField text;
    @FXML private Button search;
    @FXML private Button searchExact;
    @FXML private ListView list;

    private Stage stage;

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/sample/list.fxml"));
            Parent root = fxmlLoader.load();

            MainController ctrl = fxmlLoader.getController();
            ctrl.setStage(stage);

            stage.setTitle("Car Database");
            stage.setScene(new Scene(root, 605, 405));
            stage.show();
        }

        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }
    }
}