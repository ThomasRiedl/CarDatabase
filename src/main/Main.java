package main;

import controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        MainController.show(stage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}