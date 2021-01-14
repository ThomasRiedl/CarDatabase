package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CarDatabase;
import model.Vehicle;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    @FXML private TextField field;
    @FXML private TextArea area;

    public CarDatabase db = new CarDatabase();
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

    public void search(){
        final long timeSearchStart = System.currentTimeMillis();
        area.clear();
        ArrayList<Vehicle> data = db.search(field.getText());
        for (Vehicle v : data) {
            area.appendText(v.toString() + "\n");
        }
        final long timeSearchEnd = System.currentTimeMillis();
        System.out.println("Search took: " + (timeSearchEnd-timeSearchStart) + "ms");
    }

    public void exactSearch()
    {
        final long timeSearchStart = System.currentTimeMillis();
        area.clear();
        try
        {
            area.setText(db.exactSearch(field.getText()).toString());
        }
        catch (NullPointerException e)
        {
            System.out.println("License plate not found");
        }
        final long timeSearchEnd = System.currentTimeMillis();
        System.out.println("Search took: " + (timeSearchEnd-timeSearchStart) + "ms");
    }
}