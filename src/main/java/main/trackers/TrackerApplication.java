package main.trackers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A Class that is responsible for the actual launch of the GUI.
 * Author: Jiayi Teh
 * @version 1.0
 */
public class TrackerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrackerApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        stage.setTitle("FitnessTracker");
        stage.setScene(scene);
        stage.show();
    }

    //simply here in order to send the "ARGS" to the trackercontroller
    public static void main(String[] args) {
        TrackerController.args = args;
        launch();
    }
}