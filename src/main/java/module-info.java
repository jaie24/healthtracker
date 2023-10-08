module main.healthtrackersystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens main.trackers to javafx.fxml;
    exports main.trackers;
}